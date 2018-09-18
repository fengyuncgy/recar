package cn.xzit.recar.util;

import cn.xzit.recar.constant.RecarConstant;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

    public static Timestamp nowTime(){
        return new Timestamp(System.currentTimeMillis());
    }

    public static String dateTime(Long time){
        SimpleDateFormat  sdf = new SimpleDateFormat(RecarConstant.datetime);
        return sdf.format(new Date(time));
    }
    public static String date(Long time){
        SimpleDateFormat  sdf = new SimpleDateFormat(RecarConstant.date);
        return sdf.format(new Date(time));
    }
}
