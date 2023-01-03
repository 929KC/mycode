package sort;

import java.util.Arrays;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-13 13:43
 */

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 2, 3};
        System.out.println(Arrays.toString(sortEvenOdd(nums)));

    }

    private static int[] sortEvenOdd(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 2; j < nums.length; j++) {
                if (j % 2 == 0) {
                    if (nums[j] < nums[j - 2]) {
                        int tmp = nums[j];
                        nums[j] = nums[j - 2];
                        nums[j - 2] = tmp;
                    }
                } else {
                    if (nums[j] > nums[j - 2]) {
                        int tmp = nums[j];
                        nums[j] = nums[j - 2];
                        nums[j - 2] = tmp;
                    }
                }
            }
        }
        return nums;
    }

}
