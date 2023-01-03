import java.util.HashMap;
import java.util.Map;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-08 07:34
 */

public class Demo1 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 1, 1};
        int k = 1;
        boolean flag = containsNearbyDuplicate1(arr, k);
        System.out.println(flag);
        boolean flag2 = containsNearbyDuplicate(arr, k);
        System.out.println(flag);
    }

    public static boolean containsNearbyDuplicate1(int[] nums, int k) {
        int abs = 0;
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    index1 = i;
                    index2 = j;
                    abs = Math.abs(i - j);
                    if (abs <= k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num) && i - map.get(num) <= k) {
                return true;
            }
            map.put(num,i);
        }

        return false;
    }


}
