package com.kc.design.protogtype.framework;

import java.util.HashMap;

/**
 * @author 929KC
 * @date 2022/11/7 8:33
 * @description:
 */
public class Manager {
    private HashMap showcase = new HashMap();

    public void  register(String name,Product proto) {
        showcase.put(name,proto);
    }

    public  Product create(String protoname) {
        Product p = (Product) showcase.get(protoname);
        return p.createClone();
    }

}
