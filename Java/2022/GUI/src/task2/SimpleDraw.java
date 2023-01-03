package task2;

import java.awt.*;
import java.awt.event.*;
import java.util.Timer;

public class SimpleDraw {
    //������
    private final int TABLE_WIDTH = 300;
    //����߶�
    private final int TABLE_HEIGHT = 400;

    //���ĵĸ߶ȺͿ��
    private final int RACKET_WIDTH = 60;
    private final int RACKET_HEIGHT = 20;

    //С��Ĵ�С
    private final int BALL_SIZE = 16;

    //����С�����������ٶ�
    private int ySpeed = 10;
    //С����������ٶ�
    private int xSpeed = 5;

    //����С��ĳ�ʼ����
    private int ballX = 120;
    private int ballY = 20;

    //�������ĵĳ�ʼ���꣬x����ᷢ���仯��y���겻�ᷢ���仯
    private int rackeX = 120;
    private final int RACKET_Y = 340;

    //������ʱ��
    private Timer timer;

    //������Ϸ�����ı��
    private boolean isLose = false;

    //����һ������
    private MyCanvas tableArea = new MyCanvas();

    //�������ڶ���
    private Frame frame = new Frame("������Ϸ");

    public  void init(){
    //����������������Ѵ�С
        tableArea.setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT));
    //��������ӵ�frame
        frame.add(tableArea);
        //������̼�����
        KeyListener keyListener = new KeyAdapter(){
            @Override
            public void  keyPressed(KeyEvent e){
                int keyCode=e.getKeyCode();
                if(keyCode==KeyEvent.VK_LEFT){//û����߽磬���Լ��������ƶ�
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
        //Ϊ���ں�tableArea�ֱ���Ӽ����¼�
        frame.addKeyListener(keyListener);
        tableArea.addKeyListener(keyListener);

        //����ActionListener����������С��ı仯���
        ActionListener timerTask = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //С���������ұ߿�
                if (ballX<=0 || ballX>=TABLE_WIDTH-BALL_SIZE){
                    xSpeed=-xSpeed;
                }
                //С��ĸ߶ȳ��������ĵ�λ�ã��Һ��������ķ�Χ�ڣ�����Ϸ����
                if (ballY > RACKET_Y && (ballX<rackeX || ballX>rackeX+RACKET_WIDTH)){
                    //������ʱ��
                    timer.stop();
                    //����Ϸ�����ı������Ϊtrue
                    isLose = true;
                    //�ػ����
                    tableArea.repaint();

                }
                //���С����������ķ�Χ�ڣ��ҵ�������λ�û��ߵ��ﶥ��λ�ã���С�򷴵�
                if (ballY<=0 || (ballY>=RACKET_Y-BALL_SIZE && ballX>=rackeX && ballX<=rackeX+RACKET_WIDTH)){
                    ySpeed=-ySpeed;
                }

                //����С�������
                ballX+=xSpeed;
                ballY+=ySpeed;

                //�ػ�����
                tableArea.repaint();
            }
        };

        //���ö�ʱ������ʱ�������timerTask
        timer = new Timer(100,timerTask);
        timer.start();

        //����frame��Ѵ�С��������

        frame.pack();
        frame.setVisible(true);

    }
    public static void main(String[] args) {

    }

    private class MyCanvas extends Canvas {


    }

}

