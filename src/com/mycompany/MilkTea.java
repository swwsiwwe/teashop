package com.mycompany;

public class MilkTea {
    private String name;
    private Ingredient ingredient;
    MilkTea(String name,Ingredient ingredient){
        this.name=name;
        this.ingredient=ingredient;
    }
    @Override
    public String toString() {
        return ingredient.getName()+name;
    }
}
