package org.example;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.init();
    }

    /**
     * 底盘
     */
    public static class Bottom {
        public void init() {
            Tire tire = new Tire();
            tire.init();
        }
    }

    /**
     * 车身
     */
    public static class Framework {
        public void init() {
            Bottom bottom = new Bottom();
            bottom.init();
        }
    }

    /**
     * 车
     */
    public static class Car {
        public static final String NAME="宝马";

        public void init() {
            Framework framework = new Framework();
            framework.init();
        }
    }

    /**
     * 轮胎
     */
    public static class Tire {
        public static final int SIZE = 100;

        public void init() {
            System.out.println("轮胎大小:" + SIZE);
        }
    }

}