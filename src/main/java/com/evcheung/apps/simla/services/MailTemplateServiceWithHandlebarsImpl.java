package com.evcheung.apps.simla.services;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MailTemplateServiceWithHandlebarsImpl implements MailTemplateService {
    public String apply() {
        TemplateLoader loader = new ClassPathTemplateLoader();
        Handlebars handlebars = new Handlebars(loader);

        Template template = null;
        try {
            template = handlebars.compile("templates/mail.html");
        } catch (IOException e) {
            return null;
        }

        MailParameter parameter = new MailParameter();
        parameter.setUsername("Evan");
        try {
            return template.apply(parameter);
        } catch (IOException e) {
            return null;
        }
    }
}
