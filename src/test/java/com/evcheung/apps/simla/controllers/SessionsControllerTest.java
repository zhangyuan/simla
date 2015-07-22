package com.evcheung.apps.simla.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpSession;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:spring-servlet.xml")
public class SessionsControllerTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Test
    public void dashboard_should_return_username_after_signed_in() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        MockHttpServletRequestBuilder request = post("/sessions");
        request.param("username", "foo");

        HttpSession session = mockMvc.perform(request)
                .andReturn()
                .getRequest().getSession();

        request = get("/").session((MockHttpSession) session);
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("foo"));
    }
}
