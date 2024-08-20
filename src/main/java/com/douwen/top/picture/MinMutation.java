package com.douwen.top.picture;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinMutation {

    public static void main(String[] args) {
       String startGene =
               "AACCGGTT";
       String endGene =
               "AAACGGTA";
        String[] bank = {"AACCGATT","AACCGATA","AAACGATA","AAACGGTA"};
        System.out.println(minMutation(startGene, endGene, bank));
    }

    public static int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>();
        for(String bk : bank){
            bankSet.add(bk);
        }
        int result = 0;
        if(!bankSet.contains(endGene)){
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 8; i ++){
            char s = startGene.charAt(i);
            char e = endGene.charAt(i);
            if(s == e){
                continue;
            }
            list.add(i);
            result ++;
        }
        if(result > bank.length){
            return -1;
        }
        if(result == 0){
            return result;
        }
        char[] temp = startGene.toCharArray();
        String tempS = startGene;
        List<Integer> exist = new ArrayList<>();
        for(int j = 0; j < list.size(); j ++){
            for(int i : list){
                if(exist.contains(i)){
                    continue;
                }
                if(exist.size() == list.size()){
                    return result;
                }
                char s = tempS.charAt(i);
                char e = endGene.charAt(i);
                temp[i] = e;
                if(bankSet.contains(new String(temp))){
                    exist.add(i);
                    tempS = new String(temp);
                    continue;
                }
                temp[i] = s;
            }
        }
        if(exist.size() != list.size()){
            return -1;
        }

        return result;
    }

}
