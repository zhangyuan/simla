package com.evcheung.apps.simla;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class DashboardController {
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String index(HttpServletRequest request) {
        SessionUser sessionUser = getSessionUser(request);
        if (sessionUser == null) {
            return "It Works!";
        } else {
            return sessionUser.getUsername();
        }
    }

    private SessionUser getSessionUser(HttpServletRequest request) {
        return (SessionUser)request.getSession().getAttribute("user");
    }
}
