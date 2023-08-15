package org.example.bit;

@MyTest
public class AnnotationTest {
    //MyTest
    //private String name;

    @MyTest
    @MyDemo(value = "Annotation",name="张三",str={"java","C++"})
    public static void test() {
        System.out.println("Hello World");
    }

    public static void main(String[] args) {
        test();
    }
}
