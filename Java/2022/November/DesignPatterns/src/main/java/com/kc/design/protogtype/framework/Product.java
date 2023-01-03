package com.kc.design.protogtype.framework;

/**
 * @author 929KC
 * @date 2022/11/7 8:32
 * @description:
 */
public interface Product  extends Cloneable{
    /**
     *
     * @author 929KC
     * @date 2022/11/7 2022/11/7
     * @param s
     */
    void use(String s);
    /**
     *
     * @author 929KC
     * @date 2022/11/7 2022/11/7
     * @return Product
     * 复制实例
     */

    Product createClone();
}
