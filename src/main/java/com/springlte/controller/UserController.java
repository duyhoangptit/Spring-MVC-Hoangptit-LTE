package com.springlte.controller;

import com.springlte.dao.RoleDAO;
import com.springlte.dao.AccountDAO;
import com.springlte.entities.Account;
import com.springlte.until.ConfigUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * author Hoangptit
 * Date 7/20/2016
 */
@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private RoleDAO roleDAO;

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpSession session, ModelMap modelMap) {
        session.removeAttribute("isLogin");
        session.removeAttribute("msg");
        return "redirect:/home/login.html";
    }

    @RequestMapping(value = "profileUser", method = RequestMethod.GET)
    public String profileUser(HttpSession session, ModelMap modelMap) {
        Account account = (Account) session.getAttribute("isLogin");
        modelMap.addAttribute("user", account);
        session.setAttribute("page", "profile");
        return "profile_user";
    }

    @RequestMapping(value = "deleteUser/username", method = RequestMethod.GET)
    public String deleteUser(@PathVariable(value = "username") String username, ModelMap modelMap) {
        //deleteUserByUsername
        return "redirect:/home/dataTable.html";
    }

    /**
     * deleteUser
     * Delete User Where userId
     */

    @RequestMapping(value = "updateUser/{username}", method = RequestMethod.GET)
    public String updateUser(@PathVariable(value = "username") String username, HttpSession session, ModelMap modelMap) {
        // findByUsername
        return "redirect:/home/dataTable.html";
    }

    @RequestMapping(value = {"/login", "/"}, method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String erro,
                        @RequestParam(value = "logout", required = false) String logou, ModelMap modelMap) {
        String error = "";
        String logout = "";
        if (erro != null) {
            error = "Invalid username and password!";
        }
        if (logou != null) {
            logout = "You've been logged out successfully.";
        }
        modelMap.addAttribute("error", error);
        modelMap.addAttribute("logout", logout);
        return "login";
    }


//    @RequestMapping(method = RequestMethod.POST)
//    public String doRegister(@Valid @ModelAttribute("user") User user, BindingResult result) {
//        if (result.hasErrors()) {
//            return "user-register";
//        }
//        userDAO.saveUserAdmin(user);
//        return "redirect:/register.html?success=true";
//    }

    /**
     * Check if user is login by remember me cookie, refer
     * org.springframework.security.authentication.AuthenticationTrustResolverImpl
     */
//    private boolean isRememberMeAuthenticated() {
//        Authentication authentication =
//                SecurityContextHolder.getContext().getAuthentication();
//        if (authentication == null) {
//            return false;
//        }
//


//        return RememberMeAuthenticationToken.class.isAssignableFrom(authentication.getClass());

//    }

    private void setRememberMeTargetUrlToSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.setAttribute("targetUrl", "/admin/update");
        }
    }


    private String getRememberMeTargetUrlFromSession(HttpServletRequest request) {
        String targetUrl = "";
        HttpSession session = request.getSession(false);
        if (session != null) {
            targetUrl = session.getAttribute("targetUrl") == null ? ""
                    : session.getAttribute("targetUrl").toString();
        }
        return targetUrl;
    }

    @RequestMapping(value = "checkUsername", method = RequestMethod.GET)
    @ResponseBody
    public String checkUsername(HttpServletRequest request) {
        String username = request.getParameter("username");
        Account account = accountDAO.findByUsername(username);
        if (account != null) {
            System.out.println(account.getPassword());
            return "error";
        }
        return "success";
    }

    @RequestMapping(value = "registerUser", method = RequestMethod.POST)
    @ResponseBody
    public String register(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");

        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        account.setFullName(fullname);
        account.setImage("user_hoang.jpg");
        account.setEnabled(true);
        try {
            account = accountDAO.saveUser(account, ConfigUntil.ROLE_ADMIN);
            System.out.println(account.getPassword());
        }catch (Exception e){
            System.out.println(e);
        }
        return "success";
    }


}
