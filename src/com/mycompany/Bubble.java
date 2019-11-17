package com.mycompany;

import java.util.Calendar;

public class Bubble extends Ingredient {
    public Bubble(int year,int month,int day){
        super("Bubble",year,month,day,7);
    }
    @Override
    public boolean outDate() {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DATE));
        calendar1.add(Calendar.DATE,days+1);
        return !calendar1.after(Calendar.getInstance());
    }
}
