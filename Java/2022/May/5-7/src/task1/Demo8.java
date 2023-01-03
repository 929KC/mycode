package task1;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-07 10:28
 */

public class Demo8 {
    public static void main(String[] args) {
        int [] arr=new int[]{10,9,8,7,6,5,4,3,2,1};
        int [] arr2=new int[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println(judgement(arr));
        System.out.println(judgement(arr2));
    }

    private static boolean judgement(int[] arr) {
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]>arr[i]){
                    return true;
                }
            }
        }
        return false;
    }
}
