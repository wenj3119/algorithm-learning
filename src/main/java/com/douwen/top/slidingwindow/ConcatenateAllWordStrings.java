package com.douwen.top.slidingwindow;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConcatenateAllWordStrings {
    public static void main(String[] args) {
        String[] words = {"bar", "foo", "the"};
        List<Integer> barfoofoobarthefoobarman = allWordStrings("barfoofoobarthefoobarman", words);
        PrintStream out = System.out;
        barfoofoobarthefoobarman.forEach(i -> {
                    out.println(i);
                }
        );
    }

    public static List<Integer> allWordStrings(String s, String[] words) {
        int wordSize = words.length;
        int wordLength = words[0].length();
        int sLength = s.length();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < wordLength; i++) {
            //判断退出条件
            if (i + wordSize * wordLength > sLength) {
                break;
            }

            //初始化容器存放词语出现的次数
            Map<String, Integer> differ = new HashMap<>();
            for (int j = 0; j < wordSize; j++) {
                String word = s.substring(i + j * wordLength, i + (j + 1) * wordLength);
                differ.put(word, differ.getOrDefault(word, 0) + 1);
            }
            for (String word : words) {
                differ.put(word, differ.getOrDefault(word, 0) - 1);
                if (differ.get(word) == 0) {
                    differ.remove(word);
                }
            }
            for (int start = i; start < sLength - wordSize * wordLength + 1; start += wordLength) {
                if (start != i) {
                    String word = s.substring(start + (wordSize - 1) * wordLength, start + wordSize * wordLength);
                    differ.put(word, differ.getOrDefault(word, 0) + 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                    word = s.substring(start - wordLength, start);
                    differ.put(word, differ.getOrDefault(word, 0) - 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                }
                if (differ.isEmpty()) {
                    result.add(start);
                }
            }

        }
        return result;
    }
}
