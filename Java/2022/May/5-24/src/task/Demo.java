package task;

import java.util.HashMap;
import java.util.Map;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-24 07:05
 */

public class Demo {
    public static void main(String[] args) {

    }

    public static int majorityElement(int[] nums) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            int count=map.getOrDefault(nums[i],0)+1;
            map.put(nums[i],count);
        }
        for(int j=0;j<nums.length;j++){
            if((map.get(nums[i])>=Math.ceil(nums.length/2))){
                return nums[i];
            }
        }

    }
}
