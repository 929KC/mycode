package task1;

import javax.swing.*;
import java.awt.*;
public class BasicComponentDemo {
    //定义一个窗口
    Frame frame = new Frame("测试基本组件");
    //定义一个按钮
    Button ok=new Button("确认");
    //定义一个复选框组
    CheckboxGroup cbg=new CheckboxGroup();
    //定义一个单选框
    Checkbox male=new Checkbox("男",cbg,true);
    Checkbox female=new Checkbox("女",cbg,false);
    //定义一个复选框，初始处于未被选中状态
    Checkbox married = new Checkbox("是否已婚？", false);
    //定义一个下拉选择框
    Choice colorChoser=new Choice();
    //定义一个列表选择框
    List colorList = new List(6, true);
    //定义一个5行，20列的多行文本域
    TextArea ta=new TextArea(5,20);
    //定义一个50列的单行文本域
    TextField tf=new TextField(50);
    public void init(){
    //往下拉框中添加内容
        colorChoser.add("红色");
        colorChoser.add("绿色");
        colorChoser.add("蓝色");
        //往列表选择框中加内容
        colorList.add("红色");
        colorList.add("绿色");
        colorList.add("蓝色");
        //创建面板
        Panel p=new Panel();
        p.add(tf);
        p.add(ok);
        //将面板加到窗口的底部
        frame.add(p,BorderLayout.SOUTH);
        //创建一个面板,装载下拉框，单选框，复选框
        Panel p2=new Panel();
        p2.add(colorChoser);
        p2.add(male);
        p2.add(female);
        p2.add(married);
        //创建一个垂直排列的Box容器,装载多行文本和p 2
        Box topLeft = Box.createVerticalBox();
        topLeft.add(ta);
        topLeft.add(p2);
        //创建一个水平排列的Box,装载topleft和列表选项框
        Box top= Box.createHorizontalBox();
        top.add(topLeft);
        top.add(colorList);
        //将top添加到frame的中间区域
        frame.add(top);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new  BasicComponentDemo().init();

    }

}
