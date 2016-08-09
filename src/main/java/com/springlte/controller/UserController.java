package com.springlte.controller;

import com.springlte.dao.RoleDAO;
import com.springlte.dao.UserDAO;
import com.springlte.entities.Role;
import com.springlte.entities.User;
import com.springlte.until.ConfigUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

//    @Autowired
//    private UserDAO userDAO;
//    @Autowired
//    private RoleDAO roleDAO;

    /**
     * Check login form
     * Result redirect:/page/
     * */
    @RequestMapping(value = "checkLogin", method = RequestMethod.POST)
    public String checkLogin(@ModelAttribute(value = "user") User user, ModelMap modelMap,HttpSession session) {
        String url = "redirect:/home/login.html";
        String msg = "Username Or Password is Validate";
        user.setImage("user_hoang.jpg");
//        if (user.getUsername().equalsIgnoreCase("admin") && user.getPassword().equalsIgnoreCase("admin")) {
        if (true) {
            session.setAttribute("isLogin",user);
            url = "redirect:/home/index.html";
            System.out.println("login success");
        }
        session.setAttribute("msg","");
        session.setAttribute("page","index");
        return url;
    }

    /**
     * Log out user
     * Remove session and cookie
     * */

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpSession session, ModelMap modelMap){
        session.removeAttribute("isLogin");
        session.removeAttribute("msg");
        return "redirect:/home/login.html";
    }

    /**
     * Profile User Page
     * User Detail
     */

    @RequestMapping(value = "profileUser", method = RequestMethod.GET)
    public String profileUser(HttpSession session, ModelMap modelMap){
        User user = (User) session.getAttribute("isLogin");
        modelMap.addAttribute("user",user);
        session.setAttribute("page","profile");
        return "profile_user";
    }

    /**
     * deleteUser
     * Delete User Where userId
     */

    @RequestMapping(value = "deleteUser/username", method = RequestMethod.GET)
    public String deleteUser(@PathVariable(value = "username")String username, ModelMap modelMap){
        //deleteUserByUsername
        return "redirect:/home/dataTable.html";
    }

    /**
     * deleteUser
     * Delete User Where userId
     */

    @RequestMapping(value = "updateUser/{username}", method = RequestMethod.GET)
    public String updateUser(@PathVariable(value = "username")String username,HttpSession session, ModelMap modelMap){
        // findByUsername
        return "redirect:/home/dataTable.html";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(@ModelAttribute(value = "user")User user, HttpSession session, ModelMap modelMap){
        //Role User
//        Role roleUser = new Role();
//        roleUser.setName(ConfigUntil.ROLE_USER);
//        roleDAO.saveRole(roleUser);
//        //Role Admin
//        Role roleAdmin = new Role();
//        roleAdmin.setName(ConfigUntil.ROLE_ADMIN);
//        roleDAO.saveRole(roleAdmin);
//        //Role
//        Role roleEpl = new Role();
//        roleEpl.setName(ConfigUntil.ROLE_EMPLOYEE);
//        roleDAO.saveRole(roleEpl);
//
//        User userAdmin = new User();
//        userAdmin.setUsername("admin");
//        Set<Role> roles = new HashSet<>();
//        roles.add(roleUser);
//        roles.add(roleAdmin);
//        roles.add(roleEpl);
//        userAdmin.setRoles(roles);
//        userDAO.saveUser(userAdmin);
        return  "";
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
    private void setRememberMeTargetUrlToSession(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session!=null){
            session.setAttribute("targetUrl", "/admin/update");
        }
    }

    /**
     * get targetURL from session
     */
    private String getRememberMeTargetUrlFromSession(HttpServletRequest request){
        String targetUrl = "";
        HttpSession session = request.getSession(false);
        if(session!=null){
            targetUrl = session.getAttribute("targetUrl")==null?""
                    :session.getAttribute("targetUrl").toString();
        }
        return targetUrl;
    }



}
