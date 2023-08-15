package org.example.bit;

public @interface MyDemo {
    String value();
    String name();
    boolean flag() default true;
    String [] str();
}
