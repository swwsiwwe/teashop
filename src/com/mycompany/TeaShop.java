package com.mycompany;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class TeaShop implements Shop{
    private static Calendar now;
    private ArrayList<Bubble> bubbles;
    private ArrayList<Coconut> coconuts;
    static private Map<String,ArrayList<? extends Ingredient>> ingredientNames;
    //扩展性还不是太好，后续需要改进，在构造方法传入String数组，动态创建相应的List
    TeaShop(){
        ingredientNames = new HashMap<>();
        bubbles = new ArrayList<>();
        coconuts = new ArrayList<>();
        ingredientNames.put("Bubble",bubbles);
        ingredientNames.put("Coconut",coconuts);
    }
    @Override
    public void addIngredient(Ingredient i) {
        if(i instanceof Bubble)
            bubbles.add((Bubble)i);
        if(i instanceof Coconut)
            coconuts.add((Coconut)i);
    }
    @Override
    public void sell(String milkName, String ingredientName) {
        try{
            Ingredient ingredient = getIngredient(ingredientName);
            if(ingredient==null){
                System.out.println("没有配料"+ingredientName);
            }else
                System.out.println(new MilkTea(milkName,ingredient));
        }catch (SoldOutException se){
            System.out.println(se);
            //throw new RuntimeException(se);
        }
    }
    /*在有人购买的时候才会进行检测过期*/
    private Ingredient getIngredient(String name)throws SoldOutException {
        ArrayList<Ingredient> list = (ArrayList<Ingredient>) ingredientNames.get(name);
        if(list==null){
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).outDate()) {
                list.remove(i);
                i--;
            }
        }
        if (!list.isEmpty()) {
            Ingredient tp = list.get(0);
            list.remove(0);
            return tp;
        }else{
            throw new SoldOutException(name);
        }
    }
    public void getAll() {
        System.out.println("Bubble * " + bubbles.size());
        for (Bubble bubble : bubbles) {
            System.out.println(bubble);
        }
        System.out.println("Coconut * " + coconuts.size());
        for (Coconut coconut : coconuts) {
            System.out.println(coconut);
        }
    }
}
