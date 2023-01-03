package com.kc.design.adapter;

import com.kc.design.adapter.objectadapter.Print;
import com.kc.design.adapter.objectadapter.PrintBanner;
import org.junit.Test;

public class AdapterTest {
    @Test
    public void testAdapter() {
        Print p = new PrintBanner("Hello");
        p.printWeek();
        p.printStrong();
    }
}
