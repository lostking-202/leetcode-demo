package com.example.demo.leetcode.order;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Meituan {

    /**
     * 题目：编写一个Java函数，实现批量获取数据的功能（BService.get(List<Integer> ids)）。具体要求如下：
     * 1)提供一个函数BService.get(List<Integer> ids)，支持最多传入100个id；
     * 2)在BService.get((List<Integer> ids)函数内部，需要将传入的id列表分批（每批10个id）进行调用AService.get(List<Integer> ids)函数获取数据；
     * 3)BService.get((List<Integer> ids)函数需要返回所有批次获取的数据的合并结果，即一个包含所有数据的List<Integer>；
     * @param ids
     * @return
     */

    public List<Integer> solution1(List<Integer> ids){
        return partition(ids,10).stream().flatMap(List::stream).collect(Collectors.toList());
    }

    private static List<List<Integer>> partition(final List<Integer> list, final int size) {
        Integer limit = (list.size() + size - 1) / size;
        List<List<Integer>> splitList = Stream.iterate(0, n -> n + 1).limit(limit).parallel()
                .map(a -> list.stream().skip(a * size).limit(size).parallel().collect(Collectors.toList())).map(Meituan::get)
                .collect(Collectors.toList());
        return splitList;
    }

    public static List<Integer> get(List<Integer> ids){
        return null;
    }

    /**
     *
     * 给你一个列表List<StudentScore>，记录了学生每门课程的分数。
     * 请实现一个函数，过滤出所有课程分数均大于等于筛选条件的学生的名字。
     * @param studentScores
     * @param filters
     * @return
     */

    public List<String> solution2(List<StudentScore> studentScores,List<FilterScore> filters){
        Map<String,Integer> filterMap=filters.stream().collect(Collectors.toMap(FilterScore::getCourse,FilterScore::getScore));
        Map<String,List<StudentScore>> stringIntegerMap=studentScores.stream().collect(Collectors.groupingBy(StudentScore::getName));
        List<String> studentNames=new ArrayList<>();
        for(Map.Entry<String,List<StudentScore>> entry:stringIntegerMap.entrySet()){
            if(entry.getValue().stream().filter(studentScore -> studentScore.getSocre()<filterMap.get(studentScore.getCourse())).findAny().isEmpty()){
                studentNames.add(entry.getKey());
            }
        }
        return studentNames;
    }

    @Test
    public void test(){
        ListNode node1=new ListNode(9);
        ListNode node2=new ListNode(0);
        ListNode node3=new ListNode(0);
        node1.next=node2;
        node2.next=node3;
        ListNode node4=new ListNode(1);
        ListNode node5=new ListNode(1);
        node4.next=node5;
        ListNode result=solution3(node1,node4);
        System.out.println(result);
    }

    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照顺序的方式存储的，并且每个节点只能存储一位数字。
     * 请你将两个数相减，并以相同形式返回一个表示相减结果的链表。
     * 你可以假设
     * 1）除了数字 0 之外，这两个数都不会以 0 开头。
     * 2）给定的第一个数字一定比第二个数字大。
     * 举例：
     * 输入：l1 = [9,8,7], l2 = [5,1,2]
     * 输出：[4,7,5]
     * 解释：987-512 = 475
     *
     * @param node1
     * @param node2
     * @return
     */
    public ListNode solution3(ListNode node1,ListNode node2){
        boolean subOne=false;
        ListNode result=null;
        node1=reverseList2(node1);
        node2=reverseList2(node2);
        while(node1!=null||node2!=null){
            int val1=node1==null?0:node1.val;
            int val2=node2==null?0:node2.val;
            int res=val1-val2-(subOne?1:0);
            if(res<0){
                subOne=true;
            }
            ListNode node=new ListNode(res>=0?res:10+res);
            node.next=result;
            result=node;
            node1=node1==null?null:node1.next;
            node2=node2==null?null:node2.next;
        }
        return result;
    }

    private ListNode reverseList2(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            //取出旧链表的后几个节点
            ListNode next=curr.next;
            //将旧链表的当前节点接到新链表的前面
            curr.next=prev;
            //重置新链表的头节点
            prev=curr;
            // 重置旧链表的头节点
            curr=next;
        }
        return prev;
    }
}

class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val=val;
    }
}

class StudentScore{
    private String name;
    private String course;
    private Integer socre;

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public Integer getSocre() {
        return socre;
    }
}
class FilterScore{
    private String course;
    private Integer score;

    public String getCourse() {
        return course;
    }

    public Integer getScore() {
        return score;
    }
}