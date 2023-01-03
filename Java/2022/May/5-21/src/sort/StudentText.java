package sort;

import java.util.Arrays;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-21 15:03
 */

public class StudentText {
    public static void main(String[] args) {
        Student [] arr=new Student[3];
        arr[0]=new Student("叶秋涵",11,100);
        arr[1]=new Student("叶子秋",15,99);
        arr[2]=new Student("老衲爱尼姑",13,39);
        if(arr[0].compareTo(arr[1])>0){
            System.out.println("s>s2");
        }else if(arr[0].compareTo(arr[1])<0){
            System.out.println("s<s2");
        }else{
            System.out.println("s==s2");
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
