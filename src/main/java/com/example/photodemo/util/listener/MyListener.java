package com.example.photodemo.util.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.*;
import java.util.Date;

/**
 * 自定义监听器
 * 监听servletContext对象的创建以及销毁
 * @author zmt
 * @date 2019-05-15 11:10
 */
@WebListener
public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContext 初始化");
        System.err.println("实现 ServletContextListener 接口的 contextInitialized ");
        /**
         * 模拟 在线用户统计和应用访问量
         */
        System.out.println("contextInitialized" + "," + new Date());
        File file = new File("/static/doc/count.txt");
        if (file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");
                BufferedReader bReader = new BufferedReader(inputStreamReader);
                String count = bReader.readLine();
                System.out.println("历史访问次数：" + count);
                sce.getServletContext().setAttribute("count", count);
                bReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext 销毁");
        System.err.println("实现 ServletContextListener 接口的 contextDestroyed ");

        System.out.println("contextDestroyed" + "," + new Date());
        Object count = sce.getServletContext().getAttribute("count");
        File file = new File("/static/doc/count.txt");
        if (file.exists()) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "utf-8");
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                bufferedWriter.write(count.toString());
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
