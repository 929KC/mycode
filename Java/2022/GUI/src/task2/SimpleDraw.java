package task2;

import java.awt.*;
import java.awt.event.*;
import java.util.Timer;

public class SimpleDraw {
    //桌面宽度
    private final int TABLE_WIDTH = 300;
    //桌面高度
    private final int TABLE_HEIGHT = 400;

    //球拍的高度和宽度
    private final int RACKET_WIDTH = 60;
    private final int RACKET_HEIGHT = 20;

    //小球的大小
    private final int BALL_SIZE = 16;

    //定义小球纵向运行速度
    private int ySpeed = 10;
    //小球横向运行速度
    private int xSpeed = 5;

    //定义小球的初始坐标
    private int ballX = 120;
    private int ballY = 20;

    //定义球拍的初始坐标，x坐标会发生变化，y坐标不会发生变化
    private int rackeX = 120;
    private final int RACKET_Y = 340;

    //声明定时器
    private Timer timer;

    //定义游戏结束的标记
    private boolean isLose = false;

    //声明一个桌面
    private MyCanvas tableArea = new MyCanvas();

    //创建窗口对象
    private Frame frame = new Frame("弹球游戏");

    public  void init(){
    //设置桌面的区域的最佳大小
        tableArea.setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT));
    //将桌面添加到frame
        frame.add(tableArea);
        //定义键盘监听器
        KeyListener keyListener = new KeyAdapter(){
            @Override
            public void  keyPressed(KeyEvent e){
                int keyCode=e.getKeyCode();
                if(keyCode==KeyEvent.VK_LEFT){//没有左边界，可以继续向左移动
                   if(rackeX>0){
                     rackeX-=10;
                   }
                }

                if(keyCode==KeyEvent.VK_RIGHT){
                    if(rackeX<TABLE_WIDTH-RACKET_WIDTH){
                        rackeX+=10;
                    }
                }
            }
        };
        //为窗口和tableArea分别添加键盘事件
        frame.addKeyListener(keyListener);
        tableArea.addKeyListener(keyListener);

        //定义ActionListener，用来监听小球的变化情况
        ActionListener timerTask = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //小球碰到左右边框
                if (ballX<=0 || ballX>=TABLE_WIDTH-BALL_SIZE){
                    xSpeed=-xSpeed;
                }
                //小球的高度超出了球拍的位置，且横向不在球拍范围内，则游戏结束
                if (ballY > RACKET_Y && (ballX<rackeX || ballX>rackeX+RACKET_WIDTH)){
                    //结束定时器
                    timer.stop();
                    //把游戏结束的标记设置为true
                    isLose = true;
                    //重绘界面
                    tableArea.repaint();

                }
                //如果小球横向在球拍范围内，且到达球拍位置或者到达顶端位置，则小球反弹
                if (ballY<=0 || (ballY>=RACKET_Y-BALL_SIZE && ballX>=rackeX && ballX<=rackeX+RACKET_WIDTH)){
                    ySpeed=-ySpeed;
                }

                //更新小球的坐标
                ballX+=xSpeed;
                ballY+=ySpeed;

                //重绘桌面
                tableArea.repaint();
            }
        };

        //设置定时器，定时任务就是timerTask
        timer = new Timer(100,timerTask);
        timer.start();

        //设置frame最佳大小，并可视

        frame.pack();
        frame.setVisible(true);

    }
    public static void main(String[] args) {

    }

    private class MyCanvas extends Canvas {


    }

}

