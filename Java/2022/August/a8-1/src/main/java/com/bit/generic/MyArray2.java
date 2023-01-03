package com.bit.generic;

public class MyArray2 <T>{
    T [] arr =(T []) new Object[10];

    public T getValue(int pos) {
        return arr[pos];
    }
    public  void setrVal(int pos,T val){
        this.arr[pos] = val;
    }


}
