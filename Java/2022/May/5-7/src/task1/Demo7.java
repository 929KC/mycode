package task1;

import java.util.Arrays;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-07 10:10
 */

public class Demo7 {
    public static void main(String[] args) {
        int [] arr=new int[]{10,9,8,7,6,5,4,3,2,1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    private static void bubbleSort(int[] arr) {
        for(int i=0;i<arr.length-1;i++){
            boolean flag = false;
            for(int j=0;j<arr.length-1- i;j++){
                if(arr[j]>arr[j+1]){
                    int tmp=arr[j];
                   arr[j]=arr[j+1];
                   arr[j+1]=tmp;
                }
            }
            if(flag){
                return;
            }
        }
    }
}
