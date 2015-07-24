package com.evcheung.apps.simla.controllers;

import com.evcheung.apps.simla.services.MailService;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("users")
public class UsersController {

    @Autowired
    private MailService mailService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String create(HttpServletRequest request, @RequestParam(value = "username", required = false) String username) throws EmailException {
        mailService.apply();
        return "created";
    }
}
