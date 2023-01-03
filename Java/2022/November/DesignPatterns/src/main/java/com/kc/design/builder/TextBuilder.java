package com.kc.design.builder;

import java.util.Collection;

/**
 * @author 929KC
 * @date 2022/11/8 8:51
 * @description:
 */
public class TextBuilder extends Builder{
    private StringBuffer buffer = new StringBuffer();
    @Override
    public void makeTitle(String title) {
        buffer.append("====================\n");
        System.out.println("["+title+"]\n");
        System.out.println("\n");
    }

    @Override
    public void makeString(String str) {
        buffer.append('□'+str+"\n");
        buffer.append("\n");
    }

    @Override
    public void makeItems(String[] items) {
        for (int i =0;i<items.length;i++) {
            buffer.append(" *"+items[i]+"\n");
        }
        buffer.append("\n");
    }

    @Override
    public void close() {
        buffer.append("====================\n");
    }
    public String getResult(){
        return buffer.toString();
    }
}
