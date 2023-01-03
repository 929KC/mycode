package LeetCode2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-04 21:22
 */

public class Soluction3 {
    public static void main(String[] args) {
    int [] arr={1,2,3,4,5};
      Set set=new HashSet();
      for(int i=0;i<arr.length;i++){
          set.add(arr[i]);
      }
        for (Object o : set) {
            System.out.println(o);
        }
    }
}
