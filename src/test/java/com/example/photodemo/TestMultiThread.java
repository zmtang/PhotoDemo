package com.example.photodemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CountDownLatch;

/**
 * 高并发测试
 * 用消息队列测试
 * @author zmt
 * @date 2019-03-29 11:34
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TestMultiThread {

    private static String url ="http://localhost:8888/dev/getByName?name=赵民堂";
    // httpclient  便捷访问远程Http服务
    @Autowired
    private RestTemplate rest;  //  RestTemplate rest=new RestTemplate();

    // 模拟并发量  用户量
    private static int USER_NUM=10000;
    //  定义一个多线程发令枪
    private static CountDownLatch cdl=new CountDownLatch(USER_NUM);


    /**
     * 高并发测试
     */
    @Test
    public void testMultithread() throws InterruptedException{
        for (int i=0; i<USER_NUM; i++){
            new Thread(new task()).start();
            cdl.countDown();
        }
        // currentThread()  到底是什么？ 其实currentThread() 只是Thread 的一个静态方法。返回的正是执行当前代码指令的线程引用:
        Thread.currentThread().sleep(3000);
    }

    /**
     *  定义一个内部类 实现多线程 准备高并发测试
     */
    public class task implements Runnable{

        @Override
        public void run() {
            try {
                // 所有线程统一等待
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String result=rest.getForEntity(url,String.class).getBody();
            System.out.println(result);
        }
    }
}
