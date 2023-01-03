package com.kc.design.protogtype;

import com.kc.design.protogtype.framework.Product;

/**
 * @author 929KC
 * @date 2022/11/7 8:49
 * @description:
 */
public class UnderlinePen implements Product {
    private char ulchar;

    public UnderlinePen(char ulchar) {
        this.ulchar = ulchar;
    }

    @Override
    public void use(String s) {
        int length = s.getBytes().length;
        for (int i =0;i<length;i++) {
            System.out.print(ulchar);
        }
        System.out.println("");
    }

    @Override
    public Product createClone() {
        Product p = null;
        try{
            p = (Product)clone();
        }catch  (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
