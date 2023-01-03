package com.kc.design.factory.framework;

/**
 * 工厂:负责生产Product角色的抽象类
 */
public abstract class Factory {

    public final Product create(String owner) {
        //调用Product
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    /**
     * 生成实例方法
     *不用new关键字来生成实例,而是调用生成实例的专用方法来生成实例,这样可以防止父类与 其他具体类耦合
     * @param owner
     * @return
     */
    protected abstract Product createProduct(String owner);

    protected abstract void registerProduct(Product p);


}
