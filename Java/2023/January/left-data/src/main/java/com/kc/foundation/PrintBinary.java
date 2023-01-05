package com.kc.foundation;

/**
 * @author 929KC
 * @date 2023/1/5 20:51
 * @description:
 */
public class PrintBinary {

    public static void main(String[] args) {
        printBinary(12);
    }

    private static void printBinary(int num) {
      for (int i = 31;i>=0;i--) {
          System.out.print((num&(1<<i))==0?"0":"1");
      }
    }
}
