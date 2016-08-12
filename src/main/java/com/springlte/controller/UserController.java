package com.springlte.controller;

import com.springlte.dao.RoleDAO;
import com.springlte.dao.UserDAO;
import com.springlte.entities.Role;
import com.springlte.entities.User;
import com.springlte.until.ConfigUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * author Hoangptit
 * Date 7/20/2016
 */
@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private RoleDAO roleDAO;

    /**
     * Log out user
     * Remove session and cookie
     */

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpSession session, ModelMap modelMap) {
        session.removeAttribute("isLogin");
        session.removeAttribute("msg");
        return "redirect:/home/login.html";
    }

    /**
     * Profile User Page
     * User Detail
     */

    @RequestMapping(value = "profileUser", method = RequestMethod.GET)
    public String profileUser(HttpSession session, ModelMap modelMap) {
        User user = (User) session.getAttribute("isLogin");
        modelMap.addAttribute("user", user);
        session.setAttribute("page", "profile");
        return "profile_user";
    }

    /**
     * deleteUser
     * Delete User Where userId
     */

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


    /**
     * Begin login page
     * Form login
     */
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


    @RequestMapping(method = RequestMethod.POST)
    public String doRegister(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "user-register";
        }
        userDAO.saveUserAdmin(user);
        return "redirect:/register.html?success=true";
    }

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

    /**
     * save targetURL in session
     */
    private void setRememberMeTargetUrlToSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.setAttribute("targetUrl", "/admin/update");
        }
    }


    /**
     * get targetURL from session
     */
    private String getRememberMeTargetUrlFromSession(HttpServletRequest request) {
        String targetUrl = "";
        HttpSession session = request.getSession(false);
        if (session != null) {
            targetUrl = session.getAttribute("targetUrl") == null ? ""
                    : session.getAttribute("targetUrl").toString();
        }
        return targetUrl;
    }

    /**
     * Check Username Register Ajax blur
     */
    @RequestMapping(value = "checkUsername", method = RequestMethod.GET)
    @ResponseBody
    public String checkUsername(HttpServletRequest request) {
        String username = request.getParameter("username");
        User user = userDAO.findByUsername(username);
        if (user != null) {
            System.out.print(user.getPassword());
            return "error";
        }
        return "success";
    }


    /**
     * Register User Ajax
     */
    @RequestMapping(value = "registerUser", method = RequestMethod.POST)
    @ResponseBody
    public String register(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user = new User(username, encoder.encode(password), fullname, "", true);
        userDAO.saveUserAdmin(user);
        return "success";
    }


}
