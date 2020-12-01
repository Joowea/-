package 异常多线程01异常Exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main110501Exception {

    public static void main(String[] args) /*throws ParseException*/ {//方法一

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

        Date date = null;

        try {//方法二

            date = sdf.parse("2020-11-05");

        } catch (ParseException e) {

            e.printStackTrace();
            System.out.println("111");
        }

        //int[] nums = new int[1024*1024*1024]; //OutOfMemoryError内存溢出error 只能修改代码

        System.out.println(date);


    }
}