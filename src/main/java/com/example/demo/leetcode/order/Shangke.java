package com.example.demo.leetcode.order;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Shangke {

    @Test
    public void test() throws InterruptedException, ExecutionException {
        System.out.println(asyncSum2());
    }

    public int asyncSum2() throws  InterruptedException {
        long start = System.currentTimeMillis();
        AtomicInteger sum=new AtomicInteger(0);
        Thread t1=new Thread(()-> {
            try {
                sum.addAndGet(getAService());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });t1.start();t1.join();

        Thread t2=new Thread(()-> {
            try {
                sum.addAndGet(getBService());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });t2.start();t2.join();

        Thread t3=new Thread(()-> {
            try {
                sum.addAndGet(getCService());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });t3.start();t3.join();
        System.out.println(System.currentTimeMillis()-start);
        return sum.get();
    }

    /**
     * 编写一个Java函数，通过调用AService.get()、BService.get()、CService.get()三个接口，获取三个整数，然后将这三个整数累加，最终返回累加的值。要求：
     * 1.调用三个接口的操作需要并行执行，以提高效率；
     * 2.累加操作需要在获取三个整数的操作完成后进行，因此需要保证三个整数均已获取后才能进行累加操作；
     * 3.考虑多线程安全问题。
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public int asyncSum() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();

        FutureTask<Integer> task1=new FutureTask(() -> getAService());
        new Thread(task1).start();
        FutureTask<Integer> task2=new FutureTask(() -> getBService());
        new Thread(task2).start();
        FutureTask<Integer> task3=new FutureTask(() -> getCService());
        new Thread(task3).start();
        int sum= task1.get()+task2.get()+task3.get();
        System.out.println(System.currentTimeMillis()-start);
        return sum;
    }
    int getAService() throws InterruptedException {
        Thread.sleep(1000);
        return 1;
    }
    int getBService() throws InterruptedException {
        Thread.sleep(2000);
        return 2;
    }
    int getCService() throws InterruptedException {
        Thread.sleep(3000);
        return 3;
    }

    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照顺序的方式存储的，并且每个节点只能存储一位数字。
     * 请你将两个数相减，并以相同形式返回一个表示相减结果的链表。
     * 你可以假设
     * 1）除了数字 0 之外，这两个数都不会以 0 开头。
     * 2）给定的第一数字一定比第二个数字大。
     * 举例：
     * 输入：l1 = [9,8,7], l2 = [5,1,2]
     * 输出：[4,7,5]
     * 解释：987-512 = 475.
     */
    public ListNode solution3(ListNode node1, ListNode node2){
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

    @org.junit.Test
    public void test2(){
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
    class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val=val;
        }
    }

}
