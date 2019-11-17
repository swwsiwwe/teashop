package com.mycompany;

public class SoldOutException extends Exception {
    private String name;
    SoldOutException(String name){
        this.name = name;
    }
    @Override
    public String toString() {
        return name + "is sold out!";
    }
}
