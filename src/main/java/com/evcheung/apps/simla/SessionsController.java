package com.evcheung.apps.simla;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("sessions")
public class SessionsController {
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String create(HttpServletRequest request, @RequestParam(value = "username", required = false) String username){
        User user = new User();
        user.setUsername(username);
        request.getSession().setAttribute("user", user);
        return "SignIn";
    }
}
