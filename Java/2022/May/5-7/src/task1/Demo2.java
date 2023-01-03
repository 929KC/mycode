package task1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-07 09:32
 */

public class Demo2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int [] arr=new int[100];
        for(int i=0;i<arr.length;i++){
            arr[i]=i+1;
        }
        System.out.println(Arrays.toString(arr));
    }
}
