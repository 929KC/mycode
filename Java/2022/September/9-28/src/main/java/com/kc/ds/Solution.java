package com.kc.ds;

import java.util.HashMap;
import java.util.Map;

/**
 * 先找到奇数,并保存下来，然后将奇数之前的偶数整体向后移动,最后在将奇数插入
 *
 */
public class Solution {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        int [] arr = new int []{1,2,3,4,5,6};
            reOrderArray(arr);
    }
    public static  void reOrderArray(int[] array) {
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {//从左向右，每次遇到的，都是最前面的奇数，一定将来要被放在k下标处
                int temp = array[i];//现将当前奇数保存起来
                int j = i;
                while (j > k) {//将该奇数之前的内容(偶数序列)，整体后移一个位置
                    array[j] = array[j - 1];
                    j--;
                }
                array[k++] = temp;//将奇数保存在它将来改在的位置，因为我们是从左往右放的，没有跨越奇
            }
        }
    }
}