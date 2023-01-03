package com.bit.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-07-01 07:34
 */

public class Solution {
    public static void main(String[] args) {
        int [] nums=new int[]{1,1,1};
        int ret = findRepeatNumber(nums);
        System.out.println(ret);
    }

    public static int findRepeatNumber(int[] nums) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.get(nums[i]) == null? 1 : map.get(nums[i])+1);
        }
        for(int i=0;i<nums.length;i++){
            int ret=map.get(nums[i]);
            if(ret>1){
                return ret;
            }
        }
        return -1;
    }
}
