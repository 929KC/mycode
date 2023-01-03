package com.kc.design.factory.idcard;

import com.kc.design.factory.framework.Product;

/**
 * 具体点产品
 */
public class IDCard extends Product {
    private  String owner;

    public IDCard(String owner) {
        System.out.println("制作"+owner+"的ID卡。");
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println("使用"+owner+"的ID卡。");
    }

    public String getOwner(){
        return owner;
    }

}
