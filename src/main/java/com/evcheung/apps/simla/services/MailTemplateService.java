package com.evcheung.apps.simla.services;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MailTemplateService {
    public String apply() throws IOException {
        TemplateLoader loader = new ClassPathTemplateLoader();
        Handlebars handlebars = new Handlebars(loader);

        Template template = handlebars.compile("templates/mail.html");

        return template.apply("Handlebars.java");
    }
}
