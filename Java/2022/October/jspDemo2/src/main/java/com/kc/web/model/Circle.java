package com.kc.web.model;

public class Circle {
    private int radius;

    public Circle() {
        radius = 0;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int newRadius) {
        radius = newRadius;
    }

    public double circleArea() {
        return Math.PI * radius * radius;
    }

    public double circlLength() {
        return 2.0 * Math.PI * radius;
    }
}
