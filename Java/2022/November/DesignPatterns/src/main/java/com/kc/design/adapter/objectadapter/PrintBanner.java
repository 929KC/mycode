package com.kc.design.adapter.objectadapter;


/**
 * 适配器
 */
public class PrintBanner extends  Print {
    private Banner banner;
    public PrintBanner(String string) {
        this.banner = new Banner(string);
    }

    @Override
    public void printWeek() {
         this.banner.showWithParen();
    }

    @Override
    public void printStrong() {
       this.banner.showWithAster();
    }
}
