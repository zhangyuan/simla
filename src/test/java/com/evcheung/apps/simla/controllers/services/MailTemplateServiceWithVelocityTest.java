package com.evcheung.apps.simla.controllers.services;

import com.evcheung.apps.simla.services.MailTemplateService;
import com.evcheung.apps.simla.services.MailTemplateServiceWithVelocityImpl;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;


public class MailTemplateServiceWithVelocityTest {
    MailTemplateService service = new MailTemplateServiceWithVelocityImpl();

    @Test
    public void should_render_html() throws IOException {
        String render = service.apply();
        assertEquals("<h1>Evan</h1>", render);
    }

}
