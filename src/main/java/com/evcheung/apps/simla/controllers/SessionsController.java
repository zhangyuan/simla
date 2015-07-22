package com.evcheung.apps.simla.controllers;

import com.evcheung.apps.simla.services.CurrentUser;
import com.evcheung.apps.simla.models.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("sessions")
public class SessionsController {
    @Autowired
    CurrentUser currentUser;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String create(HttpServletRequest request, @RequestParam(value = "username", required = false) String username){
        SessionUser sessionUser = new SessionUser();
        sessionUser.setUsername(username);

        currentUser.set(sessionUser);
        return "SignIn";
    }
}
