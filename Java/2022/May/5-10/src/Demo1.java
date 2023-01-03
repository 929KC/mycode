import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-10 07:13
 */

public class Demo1 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        int[] ret = intersect(nums1, nums2);

    }

    public static int[] intersect(int[] nums1, int[] nums2) {
    //将较小的元素映射到哈希表中，并记录出现的次数
        if(nums1.length>nums1.length){
            return intersect(nums2,nums1);
        }
        Map<Integer, Integer> map=new HashMap<Integer, Integer>();
        for (int i : nums1) {
           int count=map.getOrDefault(i,0)+1;
           map.put(i,count);
        }
        int index=0;
        int [] intersect=new int[nums1.length];
        for (int i : nums2) {
            int count=map.getOrDefault(i,0);
           if(count>0){
               intersect[index++]=i;
               count--;
               if(count>0){
                   map.put(i,count);
               }else{
                   map.remove(i);
               }
           }

        }
    return Arrays.copyOfRange(intersect,0,index);

    }

}
