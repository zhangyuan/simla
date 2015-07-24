package com.evcheung.apps.simla.controllers;

import com.evcheung.apps.simla.services.MailService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:spring-servlet.xml")
public class UsersControllerTest {
    @Autowired
    private WebApplicationContext wac;

    @InjectMocks
    @Autowired
    UsersController controller;

    @Mock

    private MailService mailService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        initMocks(this);

    }

    @Test
    public void should_send_mail_when_creating_user() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        MockHttpServletRequestBuilder request = post("/users");
        request.param("username", "foo");

        mockMvc.perform(request)
                .andReturn();

        verify(mailService).apply();
    }
}
