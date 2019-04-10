package com.example.photodemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PhotoDemoApplicationTests {

    private static String url ="http://localhost:8888/dev/getByName?name=赵民堂";
    // httpclient
    RestTemplate rest=new RestTemplate();

    @Test
    public void contextLoads() {
        String result=rest.getForEntity(url,String.class).getBody();
        System.out.println(result);

    }

}
