package org.example.bit;



public class EnumDemo4 {

    public static void printName(ColorType color){
        switch (color){
            //无需使用Color进行引用
            case RED:
                System.out.println("蓝色");
                break;
            case BLACK:
                System.out.println("红色");
                break;
            case GREEN:
                System.out.println("绿色");
                break;
        }
    }

    public static void main(String[] args){
        printName(ColorType.RED);
        printName(ColorType.BLACK);
        printName(ColorType.GREEN);
    }
}
