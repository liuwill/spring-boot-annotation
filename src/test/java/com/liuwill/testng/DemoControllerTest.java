package com.liuwill.testng;

import com.liuwill.demo.DemoBootApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Administrator on 2015/10/26.
 */
@SpringApplicationConfiguration(classes = DemoBootApplication.class)
//@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
@DirtiesContext
public class DemoControllerTest extends AbstractTestNGSpringContextTests{

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;

    @BeforeClass(groups = "rest")
    public void setUp() throws Exception {
        //mvc = MockMvcBuilders.standaloneSetup(new DemoController()).build();
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test(groups = "rest")
    public void getIndex() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/demo").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andDo(print());
            //.andExpect(content().string(equalTo("Greetings from Spring Boot!")));
    }
}
