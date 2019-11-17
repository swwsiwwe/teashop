package com.mycompany;

import java.util.Random;

public class Main {
    public static void main (String...args)throws Exception{
        TeaShop teaShop = new TeaShop();
        Random random = new Random(47);//方便测试，选用固定种子
        //进货
        for(int i=0;i<30;i++){
            teaShop.addIngredient(new Bubble(2019,11,random.nextInt(15)+1));
            teaShop.addIngredient(new Coconut(2019,11,random.nextInt(15)+1));
        }
        //输出所有信息
        teaShop.getAll();
        //卖货
        /*没有此配料*/
        teaShop.sell("MilkTea","coffee");
        /*有配料*/
        for(int i = 0;i<30;i++){
            teaShop.sell("MilkTea","Bubble");
        }
        for(int i = 0;i<30;i++){
            teaShop.sell("MilkTea","Coconut");
        }
        //输出所有信息
        teaShop.getAll();
    }
}
