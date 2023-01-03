package com.kc.collection;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Apple implements Comparable<Apple>{
    private String name;
    private String color;
    private double price;
    private int weight;

   /**
    * 自定义比较规则
    * @author 929KC
    * @date 2022/11/8 2022/11/8
    * @param o
    * @return int
    */

    @Override
    public int compareTo(Apple o) {
        // 按照重量进行比较的
        return this.weight - o.weight ; // List集存储相同大小的元素会保留
    }
}
