package com.liuwill.testng;

import com.liuwill.demo.DemoBootApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Administrator on 2015/10/26.
 */
/*@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})*/
@SpringApplicationConfiguration(classes = DemoBootApplication.class)
@WebIntegrationTest("server.port:0")
@DirtiesContext
public class IntegrDemoControllerTest extends AbstractTestNGSpringContextTests {
    @Value("${local.server.port}")
    private int port;

    private URL base;
    private RestTemplate template;

    @BeforeClass(groups = "rest")
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
        template = new TestRestTemplate();
    }

    @Test(groups = "rest")
    public void getIndex() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
        //assertThat(response.getBody(), equalTo("Greetings from Spring Boot!"));
        System.out.println(response.getBody());
    }
}
