package com.douwen.top.test;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

public class IntrospectionExample {
    public static void main(String[] args) throws Exception {
        Person person = new Person();
        person.setName("Alice");

        // 获取 Person 类的 BeanInfo
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);

        // 遍历属性
        for (PropertyDescriptor propertyDesc : beanInfo.getPropertyDescriptors()) {
            String propertyName = propertyDesc.getName();

            // 获取属性的 getter 和 setter 方法
            if ("name".equals(propertyName)) {
                // 调用 getter 获取属性值
                System.out.println("Name (before): " + propertyDesc.getReadMethod().invoke(person));

                // 调用 setter 设置属性值
                propertyDesc.getWriteMethod().invoke(person, "Bob");

                // 验证修改
                System.out.println("Name (after): " + propertyDesc.getReadMethod().invoke(person));
            }
        }
    }
}
