package sort;

import java.util.Arrays;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-21 16:45
 */

public class Text {
    public static void main(String[] args) {
        Student [] arr=new Student[3];
        arr[0]=new Student("叶秋涵",11,100);
        arr[1]=new Student("子秋",15,99);
        arr[2]=new Student("老衲爱尼姑",13,39);
        System.out.println("按年龄排序");
        AgeComparator ageComparator=new AgeComparator();
        Arrays.sort(arr,ageComparator);
        System.out.println(Arrays.toString(arr));
        System.out.println("按分数排序");
        ScoreComparator scores=new ScoreComparator();
        Arrays.sort(arr,scores);
        System.out.println(Arrays.toString(arr));
        System.out.println("按字典序排序");
        NameComparator name=new NameComparator();
        Arrays.sort(arr,name);
        System.out.println(Arrays.toString(arr));
    }
}
