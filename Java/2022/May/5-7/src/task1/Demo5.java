package task1;

import java.util.Arrays;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-07 10:06
 */

public class Demo5 {
    public static void main(String[] args) {
    int [] arr=new int[]{1,2,3,4,5,6,7,8,9,10};
    int [] res=copyOf(arr);
    System.out.println(Arrays.toString(arr));
    }
    private static int [] copyOf(int[] arr) {
        int [] ret=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            ret[i]=arr[i];
        }
        return ret;
    }
}
