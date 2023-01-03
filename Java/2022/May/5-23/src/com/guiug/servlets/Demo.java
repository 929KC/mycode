package com.guiug.servlets;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-23 07:46
 */

public class Demo {
    public static void main(String[] args) {
        int [] nums={1,3,5,6};
        int index=searchInsert(nums, 5);
        System.out.println(index);
    }

    public static int searchInsert(int[] nums, int target) {
        int right=0;
        int left=nums.length-1;
        while(left<=right){
            int  mid=(left+right)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                right=mid-1;

            }else{
                left=mid+1;
            }
        }
        return left;
    }
}
