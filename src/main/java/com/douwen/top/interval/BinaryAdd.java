package com.douwen.top.interval;

public class BinaryAdd {

    public static void main(String[] args) {
        String s = addBinary("11", "01");
        System.out.println(s);
    }

    public static String addBinary(String a,String b){
        StringBuffer result = new StringBuffer();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        //从最右边开始计算
        while(i >= 0 || j >= 0){
            // 获取对应位置的二进制数值，如果为空则返回0
            int digitA = i >= 0 ? a.charAt(i--) - '0': 0;
            int digitB = j >= 0 ? b.charAt(j--) - '0': 0;
            // 获取对应二进制两个位置的和并加上进位值
            int sum = digitA + digitB + carry;
            // 进位值，如果和大于等于2,则进位为1,否则进位为0
            carry = sum >= 2 ? 1 : 0;
            // 如果和大于等于2,则和为sum - 2,否则为sum，sum可能为0、1、2、3,如果为2、3的话，因为有进位，所以为sum - 2
            sum = sum >= 2 ? sum - 2 : sum;
            result.append(sum);
        }
        //如果还有进位，则再往结果中增加一位
        if(carry == 1){
            result.append(carry);
        }
        // 因为从右往前append的，所以需要对结果字符串进行反转
        return result.reverse().toString();
    }

    public static int singleNumber(int[] nums){
        int[] bitSums = new int[32];
        for(int num : nums){
            for(int i = 0; i < 32; i ++){
                bitSums[i] += (num >> (31 - i)) & 1;
            }
        }
        int result = 0;
        for(int i = 0; i < 32; i ++){
            result = (result << 1) + bitSums[i] % 3;
        }
        return result;
    }

    public static int maxProduct(String[] words){
        //获取字符串数组长度
        int wordsLength = words.length;
        //声明一个hash表存放每个字符串包含的字符标记
        boolean[][] flags = new boolean[wordsLength][26];
        for(int i = 0; i < wordsLength; i ++){
            char[] tempChars = words[i].toCharArray();
            for(char ch : tempChars){
                flags[i][ch - 'a'] = true;
            }
        }
        int result = 0;
        //循环遍历两个字符串是否包含相同字符，
        for(int i = 0; i < wordsLength; i ++){
            for(int j = i + 1; j < wordsLength; j ++){
                int k = 0;
                for(; k < 26; k ++){
                    //包含相同字符则终止当前循环
                    if(flags[i][k] && flags[j][k]){
                        break;
                    }
                }
                //如果26个字符遍历完还没有重复的，则将两个字符串长度进行相乘，并比较结果大小进行替换
                if(k == 26){
                    int tempResult = words[i].length() * words[j].length();
                    result = Math.max(result,tempResult);
                }
            }
        }
        return result;
    }
}
