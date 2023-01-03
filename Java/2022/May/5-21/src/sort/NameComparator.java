package sort;

import java.util.Comparator;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-21 16:51
 */

public class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
       return o1.getName().compareTo(o2.getName());
    }
}
