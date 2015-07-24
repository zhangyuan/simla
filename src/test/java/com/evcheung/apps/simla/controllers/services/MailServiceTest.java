package com.evcheung.apps.simla.controllers.services;

import com.evcheung.apps.simla.services.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:spring-servlet.xml")
public class MailServiceTest {
    @Autowired
    MailService service = new MailService();

    @Test
    public void testName() throws Exception {
        service.apply();
    }
}
