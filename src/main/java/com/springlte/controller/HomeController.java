package com.springlte.controller;

import com.springlte.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "home")
public class HomeController {

    /**
     * Begin login page
     * Form login
     */
    @RequestMapping(value = {"/login","/"}, method = RequestMethod.GET)
    public String login(ModelMap modelMap) {
        modelMap.put("title", "Login | LTE");
        modelMap.put("user", new User());
        return "login";
    }

    /**
     * Register page
     * Form create User
     */
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register(ModelMap modelMap) {
        modelMap.put("title", "Register | LTE");
        return "register";
    }

    /**
     * Home page
     * Form index page
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(ModelMap modelMap, HttpSession session) {
        session.setAttribute("page", "index");
        modelMap.put("title", "Home | LTE");
        return "index";
    }

    /**
     * Home page
     * Popup and Notify
     */
    @RequestMapping(value = "popup", method = RequestMethod.GET)
    public String popup(ModelMap modelMap, HttpSession session) {
        modelMap.put("title", "SweetAlert for Bootstrap");
        session.setAttribute("page", "popup_notify");
        return "popup_notify";
    }

    /**
     * Home page
     * Lazy load
     */
    @RequestMapping(value = "lazyLoad", method = RequestMethod.GET)
    public String lazyLoad(ModelMap modelMap, HttpSession session) {
        modelMap.put("title", "Lazy load data");
        session.setAttribute("page", "lazy_load");
        return "lazy_load";
    }

    /**
     * Data Table page
     * Form dataTable page
     */
    @RequestMapping(value = "dataTable", method = RequestMethod.GET)
    public String dataTable(ModelMap modelMap, HttpSession session) {
        session.setAttribute("page", "datatable");
        modelMap.put("title", "Data Table | LTE");
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            User user = new User("hoang" + i, "pass" + i, true);
            users.add(user);
        }
        modelMap.put("userData", users);
        return "datatable";
    }

    /**
     * Data Table page
     * Result Data Table
     */
    @RequestMapping(value = "findData", method = RequestMethod.GET)
    @ResponseBody
    public List<User> findData() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            User user = new User("hoang" + i, "pass" + i, true);
            users.add(user);
        }
        return users;
    }
}
