package task3;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysDemo2 {
    public static void main(String[] args) {
        int[] ages = {34, 12, 42, 23};
        Arrays.sort(ages);
        System.out.println(Arrays.toString(ages));
        Integer[] ages1 = {34, 12, 42, 23};
        Arrays.sort(ages1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 指定比较规则。
                //if(o1 > o2){
                //   return 1;
                //}else if(o1 < o2){
                //return -1;
                //}
                //return 0;
                // return o1 - o2; // 默认升序
                return o2 - o1; //  降序
            }
        });
        System.out.println(Arrays.toString(ages1));

        System.out.println("-------------------------");
        Student[] students = new Student[3];
        students[0] = new Student("吴磊", 23, 175.5);
        students[1] = new Student("谢鑫", 18, 185.5);
        students[2] = new Student("王亮", 20, 195.5);
        System.out.println(Arrays.toString(students));

        // Arrays.sort(students);  // 直接运行奔溃
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                // 自己指定比较规则
                // return o1.getAge() - o2.getAge(); // 按照年龄升序排序！
                // return o2.getAge() - o1.getAge(); // 按照年龄降序排序！！
                // return Double.compare(o1.getHeight(), o2.getHeight()); // 比较浮点型可以这样写 升序
                return Double.compare(o2.getHeight(), o1.getHeight()); // 比较浮点型可以这样写  降序
            }
        });
        System.out.println(Arrays.toString(students));
    }
}
