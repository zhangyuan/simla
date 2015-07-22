package com.evcheung.apps.simla.controllers;

import com.evcheung.apps.simla.services.CurrentUser;
import com.evcheung.apps.simla.models.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class DashboardController {
    @Autowired
    CurrentUser currentUser;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String index(HttpServletRequest request) {
        SessionUser sessionUser = currentUser.get();
        if (sessionUser == null) {
            return "It Works!";
        } else {
            return sessionUser.getUsername();
        }
    }

}
