package com.bit.java.time;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-06-05 20:44
 */

public class LogTimerTask extends TimerTask {
    @Override
    public void run() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str=sdf.format(new Date());
        System.out.println(str+"完成了一次数据备份");
    }
}
