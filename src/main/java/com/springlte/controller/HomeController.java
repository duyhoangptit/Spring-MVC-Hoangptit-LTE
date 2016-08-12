package com.springlte.controller;

import com.springlte.dao.UserDAO;
import com.springlte.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "home")
public class HomeController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public String adminPage(ModelMap modelMap) {
        modelMap.addAttribute("title", "Spring Security Password Encoder");
        modelMap.addAttribute("message", "This page is for ROLE_ADMIN only!");
        return "index";
    }

    /**
     * Begin login page
     * Form login
     */
    @RequestMapping(value = {"/login", "/"}, method = RequestMethod.GET)
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
    public String index(ModelMap modelMap, HttpSession session, Principal principal) {
        //
        String username = "";
        try {
            username = principal.getName();
        }catch (Exception e){
            modelMap.put("title", "Login | LTE");
            return "login";
        }
//        User user = userDAO.findByUsername(username);
        User user = new User();
        user.setUsername(username);
        user.setFullName("Tạ Duy Hoàng");
        user.setImage("user_hoang.jpg");
        session.setAttribute("isLogin", user);
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

    /**
     * Login
     * for 403 access denied page
     */
    //for 403 access denied page
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accesssDenied(ModelMap modelMap) {
        //check if user is login
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            modelMap.addAttribute("username", userDetail.getUsername());
        }
        return "404";
    }


}
