package com.kc.design.prototype;

import com.kc.design.protogtype.MessageBox;
import com.kc.design.protogtype.UnderlinePen;
import com.kc.design.protogtype.framework.Manager;
import com.kc.design.protogtype.framework.Product;
import org.junit.Test;

/**
 * @author 929KC
 * @date 2022/11/7 8:52
 * @description:
 */
public class PrototypeTest {
    @Test
    public void testPrototype(){
        Manager manager = new Manager();
        UnderlinePen upen = new UnderlinePen('~');
        MessageBox mbox = new MessageBox('*');
        MessageBox sbox = new MessageBox('/');
        manager.register("strong message",upen);
        manager.register("warning box",mbox);
        manager.register("slash box",sbox);

        Product p1 = manager.create("strong message");
        p1.use("Hello Wolrd");
        Product p2 = manager.create("warning box");
        p2.use("Hello Wolrd");
        Product p3 = manager.create("slash box");
        p3.use("Hello Wolrd");
    }
}