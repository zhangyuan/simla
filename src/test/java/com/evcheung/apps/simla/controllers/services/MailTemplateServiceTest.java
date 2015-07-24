package com.evcheung.apps.simla.controllers.services;

import com.evcheung.apps.simla.services.MailTemplateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:spring-servlet.xml")
public class MailTemplateServiceTest {
    @Autowired
    MailTemplateService service = new MailTemplateService();

    @Test
    public void should_render_html() throws IOException {
        String render = service.apply();
        assertEquals("<h1>Evan</h1>", render);
    }

}
