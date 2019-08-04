package com.kayak.practice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ServerApplication.class)
public class BaseServiceTest {

    protected Logger log = LoggerFactory.getLogger(BaseServiceTest.class);

    //@BeforeClass –> @Before –> @Test –> @After –> @AfterClass

    @Test
    public void defaultTest(){
        log.info("defaultTest");
    }
}
