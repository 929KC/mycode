package com.bit.generic;

public class Add {
    public static void main(String[] args) {
        System.out.println(add(12.0, 12));
    }
    public  static  int add(int a,int  b){
        return a+b;
    }

    public static  double add(double a,double b){
        return a+b;
    }

    public static float add(float a,float b){
        return a+b;
    }

    public static  <T extends Number> double add(T a ,T b){
        return a.doubleValue()+b.doubleValue();
    }

}
