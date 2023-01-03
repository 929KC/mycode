package com.kc.design.template;

import org.junit.Test;

public class AbstractDisplayTest {

    @Test
    public void testDisplay() {
        AbstractDisplay d1 = new CharDisplay('H');
        AbstractDisplay d2 = new StringDisplay("Hello World");
        d1.display();
        d2.display();
    }
}
