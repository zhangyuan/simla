package com.evcheung.apps.simla;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class DashboardController {
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String index(){
        return "It Works!";
    }
}
