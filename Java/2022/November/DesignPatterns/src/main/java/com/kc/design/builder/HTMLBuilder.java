package com.kc.design.builder;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * @author 929KC
 * @date 2022/11/8 8:51
 * @description:
 */
public class HTMLBuilder extends Builder{
    private String filename;
    private PrintWriter writer;

    @Override
    public void makeTitle(String title) {
        filename = title+".html";
        try {
            writer = new PrintWriter(new FileWriter(filename));
        }catch (Exception e){
            e.printStackTrace();
        }
        writer.println("<html><head><title>"+title+"</html></head></title>");
        writer.println("<h1>"+title+"</h1>");
    }

    @Override
    public void makeString(String str) {
        System.out.println("<p>"+str+"</p>");
    }


    @Override
    public void makeItems(String[] items) {
        System.out.println("<ul>");
        for (int i=0;i<items.length;i++) {
            System.out.println("<li>"+items[i]+"</li>");
        }
        System.out.println("</ul>");
    }

    @Override
    public void close() {
        System.out.println("</body></html>");
        writer.close();
    }

    public String getName() {
        return this.filename;
    }
}
