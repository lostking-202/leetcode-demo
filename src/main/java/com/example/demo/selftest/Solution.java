package com.example.demo.selftest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    @Test
    public void test(){
        System.out.println(letterCombinations("234"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        // 使用对象前，必须要判断对象是否为空
        if(digits == null || digits.length() == 0){
            return combinations;
        }
        combineLetters(new StringBuilder(), combinations, digits);
        return combinations;
    }

    // 在这里的final修饰符，可以减少空间的使用率，具体区别在知乎专栏上
    private void combineLetters(StringBuilder prefix, List<String> combinations, final String digits){
        // 如果数字与字符串长度相等，说明已经匹配结束，所以返回
        if(prefix.length() == digits.length()){
            combinations.add(prefix.toString());
            return;
        }
        // 如果不相等，就只能是字符串长度还没到数字串长度，因此继续找下一个数字对应的字符串
        int curDigit = digits.charAt(prefix.length()) - '0';
        String letter = KEYS[curDigit];
        for(char c : letter.toCharArray()){
            // 添加该字符到字符串中
            prefix.append(c);
            // 用该字符和先前字符串进行组合
            combineLetters(prefix, combinations, digits);
            // 删除该字符，腾出位置，为尝试其他字符，这里体现了回溯算法的思想
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
}
// @lc code=end