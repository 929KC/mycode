package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-03 14:26
 */

public class Demo {
    public static void main(String[] args) {
        List<List<Integer>> ret = generate(5);
       for(int i=0;i<5;i++){
           for(int j=0;j<=i;j++){
               System.out.print(ret.get(i).get(j)+" ");
           }
           System.out.println();
       }

    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }
}
