package com.kc.web.model;

public class Triangle {
    private int a=0;
    private int b=0;
    private int c=0;

    public Triangle() {
    }

    public double getArea(){
        double t = (a+b+c)/2;
        return Math.sqrt(t*(t-a)*(t-b)*(t-c));
    }
    public boolean issanjiao(){
        if(a+b<c||b+c<a||a+c<b||a<=0||b<=0||c<=0){
            return false;
        }else return true;
    }
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
}
