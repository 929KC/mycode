package task3;

import java.util.Arrays;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-02 10:01
 */

public class Demo8 {
    public static void main(String[] args) {
        int [] arr=new int[]{1,2,3,4,5,6,7,8,9,10};
        int [] arr2=new int[]{1,2,3,4,5,6,7,8,9,10};
        int [] arr3=new int[]{1,2,3,4,5,6,7,8,9,1};
        System.out.println(Arrays.equals(arr, arr2));
        System.out.println(Arrays.equals(arr, arr3));
    }
}
