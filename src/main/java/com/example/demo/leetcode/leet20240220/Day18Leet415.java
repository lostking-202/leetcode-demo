package com.example.demo.leetcode.leet20240220;

import org.junit.Test;

/**
 * https://leetcode.cn/problems/add-strings/description/
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 *
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 */
public class Day18Leet415 {
    public String addStrings(String num1, String num2) {
        int i=num1.length()-1;
        int j=num2.length()-1;
        boolean plusOne=false;
        StringBuffer result=new StringBuffer();
        while(i>=0||j>=0||plusOne){
            int char1=i>=0?Character.getNumericValue(num1.charAt(i)):0;
            int char2=j>=0?Character.getNumericValue(num2.charAt(j)):0;
            int res;
            if(plusOne){
                res=char1+char2+1;
            }else{
                res=char1+char2;
            }
            if(res>9){
                plusOne=true;
            }else{
                plusOne=false;
            }
            result.append(res%10);
            i--;j--;
        }
        return result.reverse().toString();
    }
    @Test
    public void test(){
        StringBuffer sb=new StringBuffer();
        sb.append(1);
        sb.append(2);
        sb.append(3);
        System.out.println(sb.reverse());
        String num1="1";
        String num2="9";
        System.out.println(addStrings(num1,num2));
    }
}
