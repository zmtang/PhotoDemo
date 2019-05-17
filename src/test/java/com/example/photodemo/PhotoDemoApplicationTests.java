package com.example.photodemo;

import com.example.photodemo.controller.AspectController;
import com.example.photodemo.util.calculate.debx.DebxDirector;
import com.example.photodemo.util.calculate.debx.LiFuUtil;
import com.example.photodemo.util.calculate.debx.LiXiaUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PhotoDemoApplicationTests {

    private static String url ="http://localhost:8888/dev/aspect/getByName?param=赵民堂";
    // httpclient
    RestTemplate rest=new RestTemplate();

    private MockMvc mockMvc;

    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(new AspectController()).build();
    }

    /**
     * mockMvc
     */
    @Test
    public void contextLoadsByMockMvc() throws Exception {
        RequestBuilder req= get("/aspect/getByName").param("param","赵民堂");
         mockMvc.perform(req);

    }

    @Test
    public void contextLoads() {
        String result=rest.getForEntity(url,String.class).getBody();
        System.out.println(result);
    }

    @Test
    public void builderTest(){
        DebxDirector.constructorCom(new LiFuUtil());
        DebxDirector.constructorCom(new LiXiaUtil());
    }
}
