package org.example.bit;



public enum Singleton {
    INSTANCE;
    public static Singleton getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Singleton singleto1 = Singleton.getInstance();
        Singleton singleto2 = Singleton.getInstance();
        System.out.println("两个实例是否相同:"+(singleto1==singleto2));
    }
}
