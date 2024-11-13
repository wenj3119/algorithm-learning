package com.douwen.top;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InventoryUpdateConcurrencyDemo {
    // 数据库连接信息
    private static final String DB_URL = "jdbc:mysql://localhost:3306/order_info";
    private static final String USER = "root";
    private static final String PASSWORD = "Wenjun100..";

    // SQL 语句
    private static final String UPDATE_STOCK_SQL = "UPDATE inventory SET stock = stock - 1 WHERE product_id = ? AND stock > 0";

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 120; // 并发线程数
        int productId = 1;   // 假设更新的产品 ID 是 1
        CountDownLatch latch = new CountDownLatch(threadCount);
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        for (int i = 0; i < threadCount; i++) {
            executor.submit(() -> {
                try {
                    updateStock(productId);
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await(); // 等待所有线程执行完毕
        executor.shutdown();
        System.out.println("All threads completed.");
    }

    // 更新库存的方法
    public static void updateStock(int productId) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STOCK_SQL)) {

            // 开启事务
            connection.setAutoCommit(false);

            // 设置参数
            preparedStatement.setInt(1, productId);

            // 执行更新
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Stock decremented by 1 for product_id: " + productId);
                connection.commit(); // 提交事务
            } else {
                System.out.println("No stock updated for product_id: " + productId + " (possibly out of stock)");
                connection.rollback(); // 如果没有更新则回滚
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
