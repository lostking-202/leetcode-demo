package com.example.demo.leetcode.lc;

import com.example.demo.leetcode.datastructure.ListNode;
import org.junit.Test;

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 *
 * 无重复字符的最长子串
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Leetcode3 {

    @Test
    public void test(){
        String s="aab";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        int maxLength=0;
        if(s==null||s.length()==0){
            return maxLength;
        }
        int currentLength=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            String a=s.substring(i,i+1);
            int j=sb.indexOf(a);
            if(j!=-1){
                sb=new StringBuilder(sb.substring(j+1,sb.length()));
            }
            sb.append(a);
            currentLength=sb.length();
            maxLength=Math.max(currentLength,maxLength);
        }
        return maxLength;
    }

    //删除链表中等于给定值 val 的所有节点。
    //https://leetcode-cn.com/problems/remove-linked-list-elements/
    public ListNode removeElements(ListNode head, int val) {
        ListNode currentNode=head;
        while(currentNode!=null){
            if(currentNode.val==val){
                
            }
            currentNode=currentNode.next;
        }
        return head;
    }


    //https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int length=nums.length;
        int[] arr= new int[length];
        for(int i=0;i<length;i++){
           arr[i]=length-1;
        }
        for(int i=0;i<length-1;i++){
            for(int j=i+1;j<length;j++){
                if(nums[i]>nums[j]){
                    arr[j]--;
                }else if(nums[i]<nums[j]){
                    arr[i]--;
                }else{
                    arr[j]--;
                    arr[i]--;
                }
            }
        }
        return arr;
    }
}

