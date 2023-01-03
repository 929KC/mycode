package task1;

import java.util.Arrays;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-07 09:42
 */

public class Demo3 {
    public static void main(String[] args) {
        int [] nums=new int []{2,7,11,15};
        int target=9;
        int [] ret= twoSum(nums,target);
        System.out.println(Arrays.toString(ret));
    }

    private static int [] twoSum(int[] nums, int target) {
             int [] res=new int[2];
              for(int i=0;i<nums.length-1;i++){
                 for(int j=i+1;j<nums.length;j++){
                       if(nums[i]+nums[j]==target){
                           res[0]=i;
                           res[1]=j;
                       }
                 }
              }
              return res;
    }
}
