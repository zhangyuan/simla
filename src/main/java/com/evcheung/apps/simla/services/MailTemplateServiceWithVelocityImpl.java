package com.evcheung.apps.simla.services;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.stereotype.Component;

import java.io.StringWriter;

@Component
public class MailTemplateServiceWithVelocityImpl implements MailTemplateService {
    public String apply() {
        VelocityEngine ve = getVelocityEngine();
        Template template = ve.getTemplate("templates/mail.html.vm");

        VelocityContext context = new VelocityContext();

        context.put("username", "Evan");

        StringWriter writer = new StringWriter();

        template.merge(context, writer);

        return writer.toString();
    }

    private VelocityEngine getVelocityEngine() {
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());

        ve.init();
        return ve;
    }
}
