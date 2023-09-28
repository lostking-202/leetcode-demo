package com.example.demo.leetcode.order;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PokerGame {
    @Test
    public void test(){
        startPokerGame();
    }

    public void startPokerGame(){
        List<Poker> pokers=new ArrayList<>();
        for(int i=0;i<=13;i++){
            pokers.add(new Poker(i,'A'));
            pokers.add(new Poker(i,'B'));
            pokers.add(new Poker(i,'C'));
            pokers.add(new Poker(i,'D'));
        }
        pokers.add(new Poker(20,'K'));
        pokers.add(new Poker(20,'Q'));

        List<Poker> getPokers1=new ArrayList<>();
        List<Poker> getPokers2=new ArrayList<>();
        List<Poker> getPokers3=new ArrayList<>();
        List<Poker> getPokers4=new ArrayList<>();

        int[] sum=new int[4];

        Collections.shuffle(pokers);

        for(int i=0;i<=51;i++){
            if(i%4==0){
                getPokers1.add(pokers.get(i));
            }else if(i%4==1){
                getPokers2.add(pokers.get(i));
            }else if(i%4==2){
                getPokers3.add(pokers.get(i));
            }else{
                getPokers4.add(pokers.get(i));
            }
        }

        for(int i=0;i<getPokers1.size();i++){
            List<Poker> compareList=List.of(getPokers1.get(i), getPokers2.get(i), getPokers3.get(i),getPokers4.get(i));
            int j=compare(compareList);
            sum[j]+=compareList.stream().map(Poker::getScore).mapToLong(Long::valueOf).sum();
        }

        // 打乱拿排顺序
        List<String> persons=List.of("甲","乙","丙","丁").stream().collect(Collectors.toList());
        Collections.shuffle(persons);

        System.out.println(persons.get(0)+"拿牌"+getPokers1);
        System.out.println(persons.get(1)+"拿牌"+getPokers2);
        System.out.println(persons.get(2)+"拿牌"+getPokers3);
        System.out.println(persons.get(3)+"拿牌"+getPokers4);

        System.out.println(persons.get(0)+"得分："+sum[0]);
        System.out.println(persons.get(1)+"得分："+sum[1]);
        System.out.println(persons.get(2)+"得分："+sum[2]);
        System.out.println(persons.get(3)+"得分："+sum[3]);

        System.out.println("1号队得分"+(sum[0]+sum[2]));
        System.out.println("2号队得分"+(sum[1]+sum[3]));

        System.out.println("得分最多："+((sum[0]+sum[2])>(sum[1]+sum[3])?"1号队":"2号队")+"，人员是"+((sum[0]+sum[2])>(sum[1]+sum[3])?persons.get(0)+persons.get(2):persons.get(1)+persons.get(3)));
    }

    private int compare(List<Poker> compareList){
        int biggerIndex=0;
        for(int i=1;i<compareList.size();i++){
            if(compareList.get(i).compareTo(compareList.get(biggerIndex))>0){
                biggerIndex=i;
            }
        }
        return biggerIndex;
    }
}

class Poker{

    private final int num;
    private final char color;

    public Poker(int num,char color){
        this.num=num;
        this.color=color;
    }
    public int getNum() {
        return num;
    }

    public char getColor() {
        return color;
    }

    public String getName(){
        return String.valueOf(num)+color;
    }
    // 修改牌的分值可以修改或重写该方法
    public int getScore(){
        return num;
    }

    // 修改大小比较规则可以修改或重写该方法
    public int compareTo(Poker another){
        if(num==another.num){
            return -Character.valueOf(color).compareTo(another.getColor());
        }
        return Integer.valueOf(num).compareTo(another.getNum());
    }

    public String toString(){
        return getName();
    }
}
