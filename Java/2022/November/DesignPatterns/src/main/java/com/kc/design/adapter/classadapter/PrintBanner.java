package com.kc.design.adapter.classadapter;

/**
 * 适配器
 * 适配
 */
public class PrintBanner extends Banner implements Print {

    public PrintBanner(String string) {
        super(string);
    }

    @Override
    public void printWeek() {
         showWithParen();
    }

    @Override
    public void printStrong() {
       showWithAster();
    }
}
