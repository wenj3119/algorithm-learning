package com.douwen.top.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AlignTextLeftAndRight {

    public static void main(String[] args) {
        List<Integer> zlist = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        StringBuffer reverse = sb.reverse();
    }

    public static List<String> alignText(String[] words,int maxWidth){
        List<String> result = new ArrayList<>();
        int right = 0, n = words.length;
        while(true){
            int left = right;
            int sumLen = 0;
            while (right < n && sumLen + words[left].length() + right - left <= maxWidth){
                sumLen += words[right ++].length();
            }

            if(right == n){
                StringBuffer sb = join(words,left,right," ");
                sb.append(blank(maxWidth - sb.length()));
                result.add(sb.toString());
                return result;
            }

            int numWords = right - left;
            int numSpaces = maxWidth - sumLen;
            if(numWords == 1){
                StringBuffer sb = new StringBuffer(words[left]);
                sb.append(blank(numSpaces));
                result.add(sb.toString());
                continue;
            }

            int avgSpaces = numSpaces / (numWords - 1);
            int extraSpaces = numSpaces % (numWords - 1);

            StringBuffer sb = new StringBuffer();
            sb.append(join(words,left,left + extraSpaces + 1,blank(avgSpaces + 1)));
            sb.append(blank(avgSpaces));
            sb.append(join(words,left + extraSpaces + 1, right, blank(avgSpaces)));
            result.add(sb.toString());

        }
    }


    //返回n个空字符串拼接
    public static String blank(int n){
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < n; i ++){
            sb.append(' ');
        }
        return sb.toString();
    }

    //返回seq拼接的 [left,right]的字符串
    public static  StringBuffer join(String[] words, int left, int right, String seq){
        StringBuffer sb = new StringBuffer(words[left]);
        for(int i = left + 1; i < right; i ++){
            sb.append(seq);
            sb.append(words[i]);
        }
        return sb;
    }


}
