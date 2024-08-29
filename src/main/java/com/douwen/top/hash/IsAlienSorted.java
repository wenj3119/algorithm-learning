package com.douwen.top.hash;

public class IsAlienSorted {


    public static void main(String[] args) {

    }

    public boolean isAlienSorted(String[] words, String order){
        //初始化一个数组模拟哈希表
        int[] orderArray = new int[order.length()];
        for(int i = 0; i < order.length(); i ++){
            //将字母表的字符减去'a'可以将字母模拟成数组下标，数组下标对应的值为字母表中字符的顺序
            orderArray[order.charAt(i) - 'a'] = i;
        }
        //再遍历字符串的字符
        for(int i = 0; i < words.length - 1; i ++){
            //将当前字符串与数组中后一位字符串的字符位置顺序进行比较
            if(!isSorted(words[i],words[i + 1],orderArray)){
                return false;
            }
        }
        return true;
    }
    private boolean isSorted(String word1,String word2,int[] order){
        int i = 0;
        for(; i < word1.length() && i < word2.length(); ++i){
            char ch1 = word1.charAt(i);
            char ch2 = word2.charAt(i);
            //字符也减去'a'即可获取字符在哈希表中的顺序，如果当前的比下一个小，则说明顺序正确。
            if(order[ch1 - 'a'] < order[ch2 - 'a']){
                return true;
            }
            //如果当前字符顺序大于后面字符的顺序，则顺序不对，返回false
            if(order[ch1 - 'a'] > order[ch2 - 'a']){
                return false;
            }
        }
        // 说明连个字符串字符一样，再判断字符长度是否一致，如果一致，则返回true
        return i == word1.length();
    }

}
