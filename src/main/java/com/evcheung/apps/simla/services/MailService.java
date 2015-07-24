package com.evcheung.apps.simla.services;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

@PropertySource("classpath:mail.properties")
@Component
public class MailService {
    private @Value("${hostname}") String hostname;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    @Value("${from}")
    private String from;

    @Value("${to}")
    private String to;

    @Value("${port}")
    private int port;

    public void apply() throws EmailException {
        Email email = new SimpleEmail();

        email.setHostName(hostname);
        email.setSmtpPort(port);
        email.setAuthenticator(new DefaultAuthenticator(username, password));
        email.setSSLOnConnect(true);
        email.setFrom(from);
        email.addTo(to);

        email.setSubject("Test Mail");
        email.setMsg("This is just a testing mail");

        email.send();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
