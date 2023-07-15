package org.example.list;

public class BitArithmetic {


    public static int verdictIsZeroOrOne(int value,int index){
        //0000 0001
        return (value>>index)&1;
    }
    public static int updateBitToOne(int value,int index){
        //0000 0001
        //0000 0010
        //0000 0011
        return value|(1<<index);
    }
    public static int updateBitToZero(int value,int index){
        //0000 0001
        //0000 0001
        //1111 1110
        //0000 0000
        return value & (~(1 << index));
    }
    public static int getBitRightOne(int value){
        //0000 0001
        //1111 1110
        //0000 0000
        return value & -value;
    }
    public static int removeBitLeftOne(int value){
        //0000 0001
        //0000 0001
        //1111 1110
        //0000 0000
        return value & (value-1);
    }
    public static void main(String[] args) {
        System.out.println(verdictIsZeroOrOne(1,0));
        System.out.println(verdictIsZeroOrOne(1,1));
        System.out.println(verdictIsZeroOrOne(2,1));
        System.out.println(updateBitToOne(1, 1));
        System.out.println(updateBitToZero(1, 0));
        System.out.println(getBitRightOne(1));
        System.out.println(removeBitLeftOne(1));
    }
}
