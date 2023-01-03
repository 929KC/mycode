package com.kc.design.factory;

import com.kc.design.factory.framework.Factory;
import com.kc.design.factory.framework.Product;
import com.kc.design.factory.idcard.IDCardFactory;
import org.junit.Test;

public class FactoryTest {

    @Test
    public void testFactory(){
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("林黛玉");
        Product card2 = factory.create("史湘云");
        Product card3 = factory.create("叶秋涵");
        card1.use();
        card2.use();
        card3.use();
    }

}
