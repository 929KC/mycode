package com.offer.array;

public class Exchange {

    public static void reOrderArray(int [] array) {
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                int temp = array[i];
                int j = i;
                while (j > k) {
                    array[j] = array[j - 1];
                    j--;
                }
                array[k++] = temp;
            }
        }
    }
}
