package com.bit.boot;

import com.bit.boot.bean.CatPet;
import com.bit.boot.bean.Student;
import com.bit.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;


/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-21 09:30
 */
//@Configuration(proxyBeanMethods = true)//代理对象单例,会向容器中寻找
//@Configuration(proxyBeanMethods = false)//非单例,不会向容器出寻找
@SpringBootApplication // 标注SpringBoot应用
public class MainApplication {
    public static void main(String[] args) {
        //获得IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        //获取容器中的组件名称
//        for (String name : run.getBeanDefinitionNames()) {
//            if (name.equals("cat")) {
//                CatPet c1 = (CatPet) run.getBean(name);
//                CatPet c2 = (CatPet) run.getBean(name);
//                System.out.println(c1);
//                System.out.println(c2);
//                System.out.println(c1 == c2);
//            }
//
//            if (name.equals("student")) {
//                System.out.println("======");
//                Student s1 = (Student) run.getBean("student");
//                Student s2 = (Student) run.getBean("student");
//                System.out.println(s1);
//                System.out.println(s2);
//
//                System.out.println(s2 == s1);
//            }
//        }
//        //被@Configuration标记的类也在容器中  com.bit.boot.config.MyConfig$$EnhancerBySpringCGLIB$$6f0ab8d@5e77f0f4
//        MyConfig bean = run.getBean(MyConfig.class);
//        System.out.println(bean);
//        System.out.println("======");
//        //代理对象调用方法
//        Student s3 = bean.getStudent();
//        Student s4 = bean.getStudent();
//        System.out.println(s3==s4);
        System.out.println(run.containsBean("student"));//判断容器中是否有该组件
        System.out.println(run.containsBean("cat"));
        String[] beanNamesForType = run.getBeanNamesForType(Student.class);
        String[] beanNamesForType2 = run.getBeanNamesForType(CatPet.class);
        for (String s : beanNamesForType2) {
            System.out.println(s);
        }
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
    }
}
