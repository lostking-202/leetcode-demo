package com.example.demo.leetcode.order;

import java.util.List;

public class TeaOrder {

    public OrderResult getOrder(List<Combination> combinations){
        try{
            int sumPrice=0;
            if(combinations==null||combinations.size()==0||combinations.size()>10){
                throw new IllegalStateException();
            }
            for(Combination c:combinations){
                c.validate();
                c.price= c.getPrice();
                sumPrice+=c.getPrice();
            }
            return new OrderResult(sumPrice,combinations);
        }catch (Exception e){
            return new OrderResult(-1,null);
        }
    }
}
class OrderResult{
    int totalPrice;
    List<Combination> combinations;

    public OrderResult(int i, List<Combination> combinations) {
        this.totalPrice=i;
        this.combinations=combinations;
    }
}

class Combination{
    Drink drink;
    List<Dessert> desserts;
    int price;
    void validate(){
        if(drink==null){
            throw new IllegalStateException("必须点饮品");
        }
        //每杯饮品每种料最多加一份
        if(desserts!=null){
            if(desserts.size()!=desserts.stream().distinct().count()){
                throw new IllegalStateException("每杯饮品每种料最多加一份");
            }
            if (desserts.contains(Dessert.dessert3)&&desserts.contains(Dessert.dessert4)){
                throw new IllegalStateException("奥利奥奶盖和芝士奶盖不能同时添加");
            }
        }
        if(drink==Drink.Coffee1||drink==Drink.Coffee2){
            if(desserts!=null){
                if(desserts.contains(Dessert.dessert2)||desserts.contains(Dessert.dessert1)){
                    throw new IllegalStateException("咖啡只能加奶盖");
                }
            }
        }

    }
    int getPrice(){
        int price=drink.price;
        if(desserts!=null){
            for(Dessert d:desserts){
                price+=d.price;
            }
        }
        return price;
    }
}
enum Drink{
    Tea1("椰果奶茶",10),
    Tea2("西米奶茶",10),
    Tea3("蜂蜜奶茶",12),
    Tea4("杏仁奶茶",14),
    Coffee1("美式咖啡",11),
    Coffee2("拿铁咖啡",12);
    String chnName;
    int price;
    Dessert dessert;
    Drink(String chnName,int price){
        this.chnName=chnName;
        this.price=price;
    }
}
enum Dessert{
    dessert1("红豆",2),
    dessert2("芋圆",2),
    dessert3("奥利奥奶盖",4),
    dessert4("芝士奶盖",5);
    String chnName;
    int price;
    Dessert(String chnName,int price){
        this.chnName=chnName;
        this.price=price;

    }
}
