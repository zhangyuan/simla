package com.evcheung.apps.simla.services;

import com.evcheung.apps.simla.models.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class CurrentUser {
    private @Autowired
    HttpServletRequest request;

    public SessionUser get(){
        return (SessionUser)request.getSession().getAttribute("user");
    }

    public void set(SessionUser sessionUser){
        request.getSession().setAttribute("user", sessionUser);
    }
}
