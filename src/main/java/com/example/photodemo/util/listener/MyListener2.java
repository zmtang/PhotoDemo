package com.example.photodemo.util.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * 监听request对象的创建以及销毁
 * @author zmt
 * @date 2019-05-15 11:41
 */
@WebListener
public class MyListener2 implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.err.println(" 监听器 实现 ServletRequestListener 接口的 requestInitialized ");
        Object count = sre.getServletContext().getAttribute("count");
        Integer cInteger = 0;
        if (count != null) {
            cInteger = Integer.valueOf(count.toString());
        }
        System.out.println("历史访问次数：：" + count);
        cInteger++;
        sre.getServletContext().setAttribute("count", cInteger);
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.err.println("监听器 实现 ServletRequestListener 接口的 requestDestroyed ");
        System.out.println("当前访问次数：" + sre.getServletContext().getAttribute("count"));
    }
}
