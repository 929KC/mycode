package task1;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-07 10:10
 */

public class Demo6 {
    public static void main(String[] args) {
       int [] arr=new int[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println(myToString(arr));
    }
    private static String myToString(int[] arr) {
        String ret="[";
        for(int i=0;i<arr.length;i++){
            ret+=arr[i];
            if(i!=arr.length-1){
                ret+=",";
            }
        }
        return ret+"]";
    }
}
