package com.example.demo.selftest;

import org.junit.Test;

/**
 * 两个用字符串表示的数，要求他们的乘积，用字符串表示
 */
public class BigMultiply {
    @Test
    public void test(){
        System.out.println(solution("99","99"));
    }
    public String solution(String s1,String s2){
        int[] res=new int[s1.length()+s2.length()];
        int[] n1=new int[s1.length()];
        int[] n2=new int[s2.length()];
        for(int i=0;i<s1.length();i++){
            n1[i]=Character.getNumericValue(s1.charAt(i));
        }
        for(int i=0;i<s2.length();i++){
            n2[i]=Character.getNumericValue(s2.charAt(i));
        }

        for(int i=0;i<n1.length;i++){
            for (int j=0;j<n2.length;j++){
                res[i+j]+=n1[i]*n2[j];
            }
        }

        for(int i=res.length-1;i>0;i--){
            res[i-1]+=res[i]/10;
            res[i]=res[i]%10;
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<res.length-1;i++){
            sb.append(res[i]);
        }
        System.out.println(sb);



        return sb.toString();
    }
}
