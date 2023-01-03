package task;

import java.util.Arrays;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-25 11:24
 */

public class Demo5 {
    public static void main(String[] args) {
        int [] nums1={1,1,2,2,};
        int [] nums2={2,2};
        int [] arr= intersection( nums1,  nums2);
        System.out.println(Arrays.toString(arr));
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        //1 1 2 2
        //2 2
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1=0;
        int index2=0;
        int index=0;
        int [] intersect=new int [Math.min(nums2.length,nums1.length)];

        while(index1<nums1.length&&index2<nums2.length){
            if(nums1[index1]>nums2[index2]){
                index2++;
            }else if(nums1[index1]<nums2[index2]){
                index1++;
            }else{
                intersect[index]=nums1[index1];
                index1++;
                index2++;
                index++;
            }
        }
        return Arrays.copyOfRange(intersect,0,index);
    }
}
