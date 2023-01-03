package com.bit.java.time;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-05 20:44
 */

public class Text {
    public static void main(String[] args) throws Exception {
        Timer time = new Timer();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date str=sdf.parse("2022--6-5 20:48:45");
        time.schedule(new LogTimerTask(),str,1000);
        //第一个参数为任务,第二个参数为当前系统时间,第三个参数为任务间隔执行的时间

    }
}
