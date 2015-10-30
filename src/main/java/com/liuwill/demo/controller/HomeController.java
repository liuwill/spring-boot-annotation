package com.liuwill.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/10/27.
 */
@Controller
public class HomeController {

    /**
     * Static list of users to simulate Database
     */
    private static List<Map> userList = new ArrayList<Map>();

    //Initialize the list with some data for index screen
    static {
        Map singleUser = new HashMap();
        singleUser.put("firstname","Bill");
        singleUser.put("lastname","Gates");
        Map u1 = new HashMap();
        u1.put("firstname","Steve");
        u1.put("lastname","Jobs");
        Map u2 = new HashMap();
        u2.put("firstname", "Sergey");
        u2.put("lastname", "Brin");
        userList.add(singleUser);
        userList.add(u1);
        userList.add(u2);
    }

    /**
     * Saves the static list of users in model and renders it
     * via freemarker template.
     *
     * @param model
     * @return The index view (FTL)
     */
    @RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
    public String index(@ModelAttribute("model") ModelMap model) {

        model.addAttribute("userList", userList);
        return "index";
    }
}
