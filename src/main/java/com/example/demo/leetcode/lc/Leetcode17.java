package com.example.demo.leetcode.lc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class Leetcode17 {

    @Test
    public void test(){
        System.out.println(letterCombinations("432"));
    }

    String[] arrays={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> combines=new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return combines;
        }
        combineLetters(new StringBuilder(),combines,digits);
        return combines;
    }

    private void combineLetters(StringBuilder stringBuilder, List<String> combines, String digits) {
        if(stringBuilder.length()==digits.length()){
            combines.add(stringBuilder.toString());
            return;
        }
        int index=stringBuilder.length();
        String letter=arrays[Integer.parseInt(digits.substring(index,index+1))];
        for(int i=0;i<letter.length();i++){
            stringBuilder.append(letter.substring(i,i+1));
            combineLetters(stringBuilder,combines,digits);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }

    public List<String> combineLetters(String dig){
        List<String> combines=new ArrayList<>();
        if(dig==null||dig.length()==0){
            return combines;
        }
        combineLetters2(new StringBuilder(),combines,dig);
        return combines;
    }

    public void combineLetters2(StringBuilder stringBuilder,List<String> combines,String dig){
        if(stringBuilder.length()==dig.length()){
            combines.add(stringBuilder.toString());
            return;
        }
        int index=stringBuilder.length();
        String letter=arrays[Integer.parseInt(dig.substring(index,index+1))];
        for(Character c:letter.toCharArray()){
            stringBuilder.append(c);
            combineLetters2(stringBuilder,combines,dig);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }

    // BFS解法
    public List<String> letterCombinations2(String digits){
        LinkedList<String> res=new LinkedList<>();
        char[][] tab = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
                {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
        res.add("");
        while(res.peek().length()!=digits.length()){
            String remove=res.poll();
            char[] c=tab[digits.charAt(remove.length())-'2'];
            for(Character cc:c){
                res.add(remove+cc);
            }
        }
        return res;
    }

    @Test
    public void test2(){

    }
}
