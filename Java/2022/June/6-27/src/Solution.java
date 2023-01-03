import java.util.Arrays;



/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-27 11:07
 */

public class Solution {

    public static void main(String[] args) {
        int [] nums = new int[]{3,2,2,3};
        int ret= removeElement(nums, 2);
        System.out.println(ret);
    }

    public static int removeElement(int[] nums, int val) {
        int[] array = new int[nums.length];
        int j = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] != val){
                array[j++] = nums[i];
            }
        }
       nums= Arrays.copyOf(array, j);
       //System.arraycopy(array, 0, nums, 0, j);
        return j;
    }
}
