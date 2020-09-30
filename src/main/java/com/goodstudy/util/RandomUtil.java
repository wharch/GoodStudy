package com.goodstudy.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

public class RandomUtil {
     // 随机生成订单号
      public static String randomOrdeId(){
          int r1=(int)(Math.random()*(10));//产生2个0-9的随机数
          int r2=(int)(Math.random()*(10));
          long now = System.currentTimeMillis();//一个13位的时间戳
          String paymentID =String.valueOf(r1)+String.valueOf(r2)+String.valueOf(now);// 订单ID
          return paymentID;
      }
     // 随机生成教师用户名账号
      public static String randomTUsername(){
          Calendar c=Calendar.getInstance();
          String time=new SimpleDateFormat("yyyy-MM-ddHHmmss").format(c.getTime()).toString();
          StringBuffer s=new StringBuffer(time.substring(14, 16));
          Long sys=System.currentTimeMillis();
          s.append(sys.toString().substring(11, 13));
          Double tm=Math.random()*10000+1;
          s.append(tm.toString().substring(tm.toString().length()-4, tm.toString().length()));
          return s.toString();
      }
     // 随机生成视频名
      public static String randomVedioAndImg(){
          return  UUID.randomUUID().toString().replaceAll("-","").toUpperCase();
      }

}
