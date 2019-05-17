package com.example.photodemo.util.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Date;

/**
 * 监听session对象的创建以及销毁
 *
 * 利用httpSessionListener来实现在线人数的统计：
 *
 * @author zmt
 * @date 2019-05-15 14:01
 */
@WebListener
public class MyListener3 implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("sessionCreated" + "," + new Date());
        Object lineCount = se.getSession().getServletContext().getAttribute("lineCount");
        Integer count = 0;
        if (lineCount == null) {
            lineCount = "0";
        }
        count = Integer.valueOf(lineCount.toString());
        count++;
        System.out.println("新上线一人，历史在线人数：" + lineCount + "个,当前在线人数有： " + count + " 个");
        se.getSession().getServletContext().setAttribute("lineCount", count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("sessionDestroyed" + "," + new Date());
        Object lineCount = se.getSession().getServletContext().getAttribute("lineCount");
        Integer count = Integer.valueOf(lineCount.toString());
        count--;
        System.out.println("一人下线，历史在线人数：" + lineCount + "个，当前在线人数: " + count + " 个");
        se.getSession().getServletContext().setAttribute("lineCount", count);
    }
}
