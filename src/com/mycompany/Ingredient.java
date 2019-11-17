package com.mycompany;

import java.util.Calendar;

/*配料类*/
public abstract class Ingredient {
    protected String name;/*名字*/
    protected Calendar calendar;/*生产日期*/
    protected int days;/*保质期*/
    public abstract boolean outDate();
    public Ingredient(String name,int year,int month,int day,int days){
        this.name=name;
        this.calendar = Calendar.getInstance();
        this.calendar.set(year,month-1,day);
        this.days = days;
    }
    @Override
    public String toString() {
        return "配料名:"+name+","+"生产日期:"+"["
                + calendar.get(Calendar.YEAR) +","
                + (calendar.get(Calendar.MONTH)+1)+","
                + calendar.get(Calendar.DATE)
                + "]" + ","+"保质期:"+days+"天";
    }
    public String getName(){
        return name;
    }
}
