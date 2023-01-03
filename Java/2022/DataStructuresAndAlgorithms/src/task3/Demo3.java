package task3;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-02 08:57
 */

public class Demo3 {
    public static void main(String[] args) {
        int [] arr={1,2,3,4,5,6,7};
        int [] newArr=arr;
        System.out.println(arr);
        newArr[0]=10;
        System.out.println("arr:"+Arrays.toString(arr));
        System.out.println("newArr:"+Arrays.toString(newArr));

        arr[0]=1;
        newArr=Arrays.copyOf(arr,arr.length);
        System.out.println(newArr);
        System.out.println("newArr:"+Arrays.toString(newArr));
        System.out.println("arr:"+Arrays.toString(arr));

        arr[0]=99;
        System.out.println("newArr:"+Arrays.toString(newArr));
        System.out.println("arr:"+Arrays.toString(arr));

        //拷贝某个范围
        int [] newArr2= Arrays.copyOfRange(arr,2,4);
        System.out.println("newArr2"+Arrays.toString(newArr2));
    }
}
