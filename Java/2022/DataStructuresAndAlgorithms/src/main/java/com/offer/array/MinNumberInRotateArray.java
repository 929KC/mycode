package com.offer.array;

public class MinNumberInRotateArray {
    public static void main(String[] args) {
        int [] arr = new int []{1,3,5};
        int res = minNumberInRotateArray(arr);
        System.out.println(res);
    }

    public static int minNumberInRotateArray(int [] array) {
        if (array==null||array.length==0) {
            return 0;
        }
        int left = 0;
        int right = array.length-1;
        int mid = 0;
        while (left<right) {

            if (right-left==1) {
                mid = right;
                break;
            }
            mid = ((right-left)>>1);
            if (array[left]==array[mid]&&array[mid]==array[right]) {
                int res = array[left];
                for (int i=left+1;i<right;i++) {
                    if (array[i]<res) {
                        res = array[i];
                    }
                }
                return res;
            }

            if (array[mid]>=array[left]) {
                left = mid;
            }else{
                right = mid;
            }
        }
        return array[mid];
    }

}
