//import java.util.HashMap;
//import java.util.Map;
//
///**
// * truth:talk is cheap, show me the code
// *
// * @author KC萧寒
// * @description
// * @createDate: 2022-05-23 11:50
// */
//
//public class Demo1 {
//    public static void main(String[] args) {
//
//    }
//
//
//    public static int singleNumber(int[] nums) {
//        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
//        for(int i=0;i<nums.length;i++){
//            int count=map.getOrDefault(nums[i],0)+1;
//            map.put(nums[i],count);
//        }
//        for(int i=0;i<nums.length;i++){
//            if(map.get(i)==1){
//                return nums[i];
//            }
//        }
//    }
//}
