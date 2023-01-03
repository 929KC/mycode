import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-09 07:44
 */

public class StudentText {
    public static void main(String[] args) {
        int [] arr=new int[]{3,2,4};
        int [] ret=twoSum(arr,6);
        System.out.println(Arrays.toString(ret));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
       throw new RuntimeException("no twoSum");
    }


}
