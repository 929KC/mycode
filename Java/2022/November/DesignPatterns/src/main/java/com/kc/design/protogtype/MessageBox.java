package com.kc.design.protogtype;


import com.kc.design.protogtype.framework.Product;

/**
 * @author 929KC
 * @date 2022/11/7 8:43
 * @description:
 */
public class MessageBox implements Product {
    private char decochar ;

    public MessageBox(char decochar) {
        this.decochar = decochar;
    }


    @Override
    public void use(String s) {
        int length = s.getBytes().length;
        for (int i =0;i<length+4;i++) {
            System.out.print(decochar);
        }
        System.out.println("");
        System.out.println(decochar+" "+s+" "+decochar);
        for (int i =0;i<length+4;i++) {
            System.out.print(decochar);
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
