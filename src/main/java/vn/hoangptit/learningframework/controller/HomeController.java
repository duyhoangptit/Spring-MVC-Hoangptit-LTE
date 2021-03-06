package vn.hoangptit.learningframework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import vn.hoangptit.learningframework.dao.AccountDAO;
import vn.hoangptit.learningframework.entities.Account;
import vn.hoangptit.learningframework.service.AccountService;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

/**
 * @author Hoangptit
 * @date 25/7/2016
 */

@Controller
@RequestMapping(value = "home")
public class HomeController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public String adminPage(ModelMap modelMap) {
        // Cấu hình đường dẫn admin
        modelMap.addAttribute("title", "Spring Security Page Admin");
        modelMap.addAttribute("message", "This page is for ROLE_ADMIN only!");
        return "admin";
    }


    @RequestMapping(value = {"login", "/"}, method = RequestMethod.GET)
    public String login(ModelMap modelMap) {
        modelMap.put("title", "Login | LTE");
        modelMap.put("user", new Account());
        return "login";
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register(ModelMap modelMap) {
        modelMap.put("title", "Register | LTE");
        return "register";
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(ModelMap modelMap, HttpSession session) {
        session.setAttribute("page", "index");
        modelMap.put("title", "Home | LTE");
        return "index";
    }

    @RequestMapping(value = "homePage", method = RequestMethod.GET)
    public String checkLogin(ModelMap modelMap,HttpSession session, Principal principal){
        String username = "";
        try {
            username = principal.getName();
        } catch (Exception e) {
            modelMap.put("title", "Login | LTE");
            return "login";
        }
        Account account = accountService.findByUsername(username);
        session.setAttribute("isLogin", account);
        return "index";
    }

    @RequestMapping(value = "popup", method = RequestMethod.GET)
    public String popup(ModelMap modelMap, HttpSession session) {
        modelMap.put("title", "SweetAlert for Bootstrap");
        session.setAttribute("page", "popup_notify");
        return "popup_notify";
    }

    @RequestMapping(value = "lazyLoad", method = RequestMethod.GET)
    public String lazyLoad(ModelMap modelMap, HttpSession session) {
        modelMap.put("title", "Lazy load data");
        session.setAttribute("page", "lazy_load");
        return "lazy_load";
    }

    @RequestMapping(value = "uploadFile", method = RequestMethod.GET)
    public String uploadFile(ModelMap modelMap, HttpSession session) {
        modelMap.put("title", "Upload Drag And Drop");
        session.setAttribute("page", "uploadFile");
        return "uploadFile";
    }

    @RequestMapping(value = "dataTable", method = RequestMethod.GET)
    public String dataTable(ModelMap modelMap, HttpSession session) {
        session.setAttribute("page", "datatable");
        modelMap.put("title", "Data Table | LTE");
        List<Account> accounts = accountService.findAll();
        modelMap.put("accounts", accounts);
        return "datatable";
    }

    @RequestMapping(value = "403", method = RequestMethod.GET)
    public String accesssDenied(ModelMap modelMap) {
        //check if user is login
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            modelMap.addAttribute("username", userDetail.getUsername());
        }
        return "404";
    }

    @RequestMapping(value = "findData", method = RequestMethod.GET)
    @ResponseBody
    public List<Account> findData() {
        List<Account> accounts = accountService.findAll();
        return accounts;
    }




}
