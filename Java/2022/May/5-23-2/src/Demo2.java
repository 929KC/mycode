import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-23 11:09
 */

public class Demo2 {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> generate(int rowIndex) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i < rowIndex; i++) {
            List<Integer> list2=new ArrayList<Integer>();
            for(int j=0;j<=i;j++){
                if(i==j||j==0){
                    list2.add(1);
                }else{
                    list2.add(list.get(i-1).get(j-1)+list.get(i-1).get(j+1));
                }
            }
            list.add(list2);
        }
    return list;
    }



}
