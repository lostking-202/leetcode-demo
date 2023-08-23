package com.example.demo.leetcode.lc;

import com.example.demo.leetcode.datastructure.ListNode;
import com.example.demo.leetcode.datastructure.TreeNode;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;


import java.util.*;
import java.util.stream.Collectors;

public class Leetcode1 {
    @Test
    public void test1(){
        int i=0;
        i++;
        System.out.println(i);
    }

    //给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
    //https://leetcode-cn.com/problems/two-sum/
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                int[] a={map.get(target-nums[i]),i};
                return a;
            }
            map.put(nums[i],i);
        }
        return null;
    }

    //给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
    //https://leetcode-cn.com/problems/reverse-integer/
    public int reverse(int x) {
        int b=0;
        while(x!=0){
            int temp=b*10+x%10;
            if((temp-x%10)/10!=b){
                return 0;
            }
            x=x/10;
            b=temp;
        }
        return b;
    }

    //判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
    //https://leetcode-cn.com/problems/palindrome-number/
    public boolean isPalindrome(int x) {
        if(x!=0&&x%10==0)return false;
        int a;
        int b=0;
        while(x>b){
            a=x%10;
            x=x/10;
            b=b*10+a;
        }
        return x==b||x==b/10;
    }

    //罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
    //https://leetcode-cn.com/problems/roman-to-integer/
    public int romanToInt1(String s) {
        if(s.length()==0)return 0;
        Map<String,Integer> map1=new HashMap<>();
        map1.put("I",1);
        map1.put("V",5);
        map1.put("X",10);
        map1.put("L",50);
        map1.put("C",100);
        map1.put("D",500);
        map1.put("M",1000);
        map1.put("IV",4);
        map1.put("IX",9);
        map1.put("XL",40);
        map1.put("XC",90);
        map1.put("CD",400);
        map1.put("CM",900);
        int sum=0;
        while(s.length()>0){
            if(s.length()>1&&map1.containsKey(s.substring(0,2))){
                sum+=map1.get(s.substring(0,2));
                s=s.substring(2);
            }else{
                sum+=map1.get(s.substring(0,1));
                s=s.substring(1);
            }
        }
        return sum;
    }

    public int romanToInt2(String s) {
        if(s.length()==0)return 0;
        Map<String,Integer> map1=new HashMap<>();
        map1.put("I",1);
        map1.put("V",5);
        map1.put("X",10);
        map1.put("L",50);
        map1.put("C",100);
        map1.put("D",500);
        map1.put("M",1000);
        map1.put("IV",4);
        map1.put("IX",9);
        map1.put("XL",40);
        map1.put("XC",90);
        map1.put("CD",400);
        map1.put("CM",900);
        int sum=0;
        for(int i=0;i<s.length();){
            if(i+2<=s.length()&&map1.containsKey(s.substring(i,i+2))){
                sum+=map1.get(s.substring(i,i+2));
                i+=2;
            }else{
                sum+=map1.get(s.substring(i,i+1));
                i++;
            }
        }
        return sum;
    }

    //编写一个函数来查找字符串数组中的最长公共前缀。
    //如果不存在公共前缀，返回空字符串 ""。
    //https://leetcode-cn.com/problems/longest-common-prefix/
    public String longestCommonPrefix1(String[] strs) {
        if(strs.length==0)return "";
        String s= Arrays.stream(strs).min(Comparator.comparing(String::length)).get();
        int len=s.length();
        for(int i=0;i<len;i++){
            String finalS = s;
            if (Arrays.stream(strs).allMatch(a -> a.startsWith(finalS))) {
                return s;
            } else {
                s = s.substring(0, s.length() - 1);
            }
        }
        return "";
    }

    public String longestCommonPrefix2(String[] strs) {
        if(strs.length==0)return "";
        String s= strs[0];
        for(int i=1;i<strs.length;i++){
            int j=0;
            for(;j<s.length()&&j<strs[i].length();j++){
                if(s.charAt(j)!=strs[i].charAt(j)){
                    break;
                }
            }
            s=s.substring(0,j);
            if("".equals(s)){
                return "";
            }
        }
        return s;
    }

    //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
    //有效字符串需满足：
    //1.左括号必须用相同类型的右括号闭合。
    //2.左括号必须以正确的顺序闭合。
    //注意空字符串可被认为是有效字符串。
    public boolean isValid1(String s) {
        if(s.length()==0)return true;
        Map<String,String> map=new HashMap<>();
        map.put("(",")");
        map.put("{","}");
        map.put("[","]");
        String[] ss=s.split("");
        Stack<String> stringStack=new Stack<>();
        for(String sss:ss){
            if(map.containsKey(sss)){
                stringStack.push(map.get(sss));
            }else{
                if(stringStack.empty()||!sss.equals(stringStack.pop())){
                    return false;
                };
            }
        }
        return stringStack.empty();
    }

    //括号成对去除直到为空
    public boolean isValid2(String s) {
        List<String> ss=new ArrayList<>();
        ss.add("{}");
        ss.add("()");
        ss.add("[]");
        int len=s.length();
        for(int i=0;i<len/2;){
            boolean flag=false;
            for(String sss:ss){
                if(s.contains(sss)){
                    String sb=s.replace(sss,"");
                    i+=(s.length()-sb.length())/2;
                    s=sb;
                    flag=true;
                }
            }
            if(!flag){
                return false;
            }
        }
        return s.isEmpty();
    }

    //将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    //https://leetcode-cn.com/problems/merge-two-sorted-lists/
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        List<Integer> a=new ArrayList<>();
        while(l1!=null){
            a.add(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            a.add(l2.val);
            l2=l2.next;
        }
        a.sort(Integer::compareTo);
        if(a.isEmpty()){
            return null;
        }
        ListNode b=new ListNode(a.get(0));
        ListNode nextNode;
        ListNode currentNode=b;
        for(int i=1;i<a.size();i++){
            nextNode=new ListNode(a.get(i));
            currentNode.next=nextNode;
            currentNode=nextNode;
        }
        return b;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if(l1.val<l2.val){
            l1.next=mergeTwoLists2(l1.next,l2);
            return l1;
        }else{
            l2.next=mergeTwoLists2(l1,l2.next);
            return l2;
        }
    }

    //给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
    //不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
    //https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
    public int removeDuplicates1(int[] nums) {
        nums=Arrays.stream(nums).distinct().toArray();
        return nums.length;
    }

    public int removeDuplicates2(int[] nums) {
        Set<Integer> a=new HashSet<>();
        for(Integer num:nums){
            if(!a.contains(nums)){
                a.add(num);
            }
        }
        return a.size();
    }

    //每次遇到不等的就挪到下一个位置，因为第一次遇到不等的时候前面肯定有一个值了
    public int removeDuplicates3(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }

    //给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
    //不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
    //元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
    //https://leetcode-cn.com/problems/remove-element/
    public int removeElement(int[] nums, int val) {
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=val){
                nums[i]=nums[j];
                i++;
            }
        }
        return i;
    }

    //给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
    //https://leetcode-cn.com/problems/implement-strstr/
    public int strStr1(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    //给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    //你可以假设数组中无重复元素。
    //https://leetcode-cn.com/problems/search-insert-position/
    public int searchInsert1(int[] nums, int target) {
        return binarySearch(nums,0,nums.length-1,target);
    }

    private int binarySearch(int[] nums,int m,int n,int target){
        if(m==n)return nums[m]>=target?m:m+1;
        if(nums[m]<target&&nums[n]>target){
            if(n-m==1){
                return m+1;
            }else{
                int l=(m+n)/2;
                if(nums[l]==target){
                    return l;
                }else if(nums[l]>target){
                    return binarySearch(nums,m,l,target);
                }else{
                    return binarySearch(nums,l,n,target);
                }
            }
        }else if(nums[m]==target){
            return m;
        }else if(nums[n]==target){
            return n;
        }else if(nums[m]>target){
            return m;
        }else{
            return n+1;
        }
    }

    public int searchInsert2(int[] nums, int target) {
        int len=nums.length;
        if(len==0)return 0;
        if(nums[len-1]<target)return len;
        int left=0;
        int right=len-1;
        while(left<right){
            int mid=(left+right)>>>1;
            if(nums[mid]<target){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }

    //「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
    //https://leetcode-cn.com/problems/count-and-say/
    public String countAndSay1(int n) {
        if(n==1)return "1";
        String[] ss=countAndSay1(n-1).split("");
        StringBuffer sb=new StringBuffer();
        int j=1;
        for(int i=0;i<ss.length;i++){
            if(i==ss.length-1) {
                sb.append(j).append(ss[ss.length - 1]);
                return sb.toString();
            }
            if(ss[i].equals(ss[i+1])){
                j++;
            }else{
                sb.append(j).append(ss[i]);
                j=1;
            }
        }
        return sb.toString();
    }

    public String countAndSay2(int n) {
        if(n==1)return "1";
        String s=countAndSay2(n-1);
        StringBuffer sb=new StringBuffer();
        int j=0;
        int i;
        for(i=1;i<s.length();i++){
            if(s.charAt(j)!=s.charAt(i)){
                sb.append(i-j).append(s.charAt(j));
                j=i;
            }
        }
        if (j!=i) {
            sb.append(i-j).append(s.charAt(j));
        }
        return sb.toString();
    }

    //给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
    //https://leetcode-cn.com/problems/maximum-subarray/
    public int maxSubArray(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>0){
                sum+=nums[i];
            }else{
                continue;
            }
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]>0){
                    sum+=nums[j];
                }else if((sum=sum+nums[j])<0){
                    break;
                }else{
                    continue;
                }
            }

        }
        return 0;
    }

    private double mySqrt(int x){
        double b=1.0;
        double check;
        do{
            b=(b+x/b)/2;
            check=b*b-x;
        }while((check>=0?check:-check)>1);
        return b;
    }

    //假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
    //每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
    //https://leetcode-cn.com/problems/climbing-stairs/
    public int climbStairs1(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return climbStairs1(n-1)+climbStairs1(n-2);
    }

    public int climbStairs2(int n){
        //将递归转化为数组，动态规划，将问题转化为规模更小的问题（或多个规模更小的问题）
       int[] dp=new int[n+1];
       dp[0]=1;
       dp[1]=1;
       for(int i=2;i<=n;i++){
           dp[i]=dp[i-1]+dp[i-2];
       }
       return dp[n];
    }
    public int[] plusOne1(int[] digits) {
        int a=digits.length-1;
        if(a==-1){
            return null;
        }
        if(digits[a]+1>9){
            if(a==0){
                int[] b={1,0};
                return b;
            }else{
                int[] b={0};
                return ArrayUtils.addAll(plusOne1(Arrays.copyOf(digits,a)),b);
            }
        }else{
            digits[a]=digits[a]+1;
            return digits;
        }
    }

    public int[] plusOne2(int[] digits) {
        for(int i=digits.length-1;i>-1;i--){
            digits[i]++;
            digits[i]=digits[i]%10;
            if(digits[i]!=0){
                return digits;
            }
        }
        int[] b=new int[digits.length+1];
        b[0]=1;
        return b;
    }

    //给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
    public ListNode deleteDuplicates1(ListNode head) {
        List<Integer> a=new ArrayList<>();
        while(head!=null){
            a.add(head.val);
            head=head.next;
        }
        List<Integer> b=a.stream().distinct().collect(Collectors.toList());
        if(b.isEmpty()){
            return null;
        }
        ListNode c=new ListNode(b.get(0));
        ListNode currentNode=c;
        ListNode nextNode;
        for(int i=1;i<b.size();i++){
            nextNode=new ListNode(b.get(i));
            currentNode.next=nextNode;
            currentNode=nextNode;
        }
        return c;
    }

    //给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
    public ListNode deleteDuplicates2(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode preNode=head;
        ListNode a=new ListNode(head.val);
        ListNode currentNode=a;
        head=head.next;
        while(head!=null){
            if(preNode.val!=head.val){
                //重新构造链表时，每次都只取一个点，千万别取多了
                currentNode.next=new ListNode(head.val);
                currentNode=currentNode.next;
                preNode=head;
                head=head.next;
            }else{
                head=head.next;
            }
        }
        return a;
    }

    //给你两个二进制字符串，返回它们的和（用二进制表示）。
    //输入为 非空 字符串且只包含数字 1 和 0。
    //https://leetcode-cn.com/problems/add-binary/
    public String addBinary(String a, String b) {

        a=new StringBuffer(a).reverse().toString();
        b=new StringBuffer(b).reverse().toString();
        while(a.length()!=b.length()){
            if(a.length()>b.length()){
                b=new StringBuffer(b).append(0).toString();
            }else{
                a=new StringBuffer(a).append(0).toString();
            }
        }
        StringBuffer sb=new StringBuffer();
        boolean flag=false;
        char aa='1';
        char bb='0';
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)==aa&&b.charAt(i)==aa){
                if(flag){
                    sb.append(1);
                }else{
                    sb.append(0);
                }
                flag=true;
            }else if(a.charAt(i)==bb&&b.charAt(i)==bb){
                if (flag){
                    sb.append(1);
                }else{
                    sb.append(0);
                }
                flag=false;
            }else{
                if(flag){
                    sb.append(0);
                    flag=true;
                }else{
                    sb.append(1);
                    flag=false;
                }
            }
        }
        if(flag){
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    @Test
    public void test3() {
        char c='1';
        System.out.println("1".charAt(0)==c);
    }

    //https://leetcode-cn.com/problems/delete-middle-node-lcci/
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }

    public int maxDepth2(TreeNode root) {
        if(root==null)return 0;
        int count=0;
        Stack<TreeNode> nodes=new Stack<>();
        nodes.push(root);
        while(!nodes.empty()){
            count++;
            int size=nodes.size();
            //这样做可以保证同一层的节点,count只加一次
            while(size>0){
                root=nodes.pop();
                if(root.right!=null){
                    nodes.push(root.right);
                }
                if(root.left!=null){
                    nodes.push(root.left);
                }
                size--;
            }
        }
        return count;
    }

    public int[] twoSum2(int[] nums, int target) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(!list.contains(target-nums[i])){
                list.add(nums[i]);
            }else{
                int[] arrays={list.indexOf(target-nums[i]),list.size()};
                return arrays;
            }
        }
        return new int[0];
    }

    @Test
    public void test(){
        int[] nums={2,7,11,15};
        int target=9;
        Arrays.stream(twoSum2(nums,target)).forEach(System.out::println);
    }
}

