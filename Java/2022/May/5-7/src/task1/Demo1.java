package task1;

import java.util.Arrays;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-07 09:27
 */

public class Demo1 {
    public static void main(String[] args) {
        int [] arr=new int[]{1,2,3};
       transform(arr);
        System.out.println(Arrays.toString(arr));

    }
    public static void transform (int [] arr){
        for(int i=0;i<arr.length;i++){
            arr[i]=arr[i]*2;
        }
    }

}
