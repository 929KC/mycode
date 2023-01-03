package task;

import java.util.ArrayList;
import java.util.List;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-11 07:15
 */

public class YangHui {
    public static void main(String[] args) {
        List<List<Integer>> list = generate(5);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <=i; j++) {
                System.out.print(list.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list2 = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j ) {
                    list2.add(1);
                } else {
                    //i=3;
                    //j=1
                    list2.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
                }

            }
            list.add(list2);
        }
        return list;
    }

}
