package vn.hoangptit.learningframework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.hoangptit.learningframework.dto.AccountDto;
import vn.hoangptit.learningframework.dto.CustomerDto;
import vn.hoangptit.learningframework.service.AccountService;
import vn.hoangptit.learningframework.utils.ConfigUntil;
import vn.hoangptit.learningframework.utils.Role;

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
    private AccountService accountService;

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public String logout(HttpSession session) {
        session.removeAttribute("isLogin");
        session.removeAttribute("msg");
        SecurityContextHolder.clearContext();// Remove data security
        return "redirect:/home/login.html";
    }

    @RequestMapping(value = "profileUser", method = RequestMethod.GET)
    public String profileUser(HttpSession session, ModelMap modelMap) {
        AccountDto account = (AccountDto) session.getAttribute("isLogin");
        modelMap.addAttribute("user", account);
        session.setAttribute("page", "profile");
        return "profile_user";
    }

    @RequestMapping(value = "deleteUser/username", method = RequestMethod.GET)
    public String deleteUser(@PathVariable(value = "username") String username, ModelMap modelMap) {
        // enable account
        return "redirect:/home/dataTable.html";
    }

    /**
     * Update User By username
     * @return update dataTable
     */
    @RequestMapping(value = "updateUser/{username}", method = RequestMethod.GET)
    public String updateUser(@PathVariable(value = "username") String username, HttpSession session, ModelMap modelMap) {
        // findByUsername
        AccountDto account = accountService.findByUsername(username);

        // update User
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

    @RequestMapping(value = "checkUsername", method = RequestMethod.GET)
    @ResponseBody
    public String checkUsername(HttpServletRequest request) {
        String username = request.getParameter("username");
        AccountDto account = accountService.findByUsername(username);
        if (account != null) {
            return "error";
        }
        return "success";
    }

    @RequestMapping(value = "registerUser", method = RequestMethod.POST)
    @ResponseBody
    public String register(HttpServletRequest request, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");

        AccountDto account = new AccountDto();
        account.setUsername(username);
        account.setPassword(password);
        CustomerDto customer = new CustomerDto();
        customer.setFullName(fullname);
        account.setCustomer(customer);
        try {
            account = accountService.saveUser(account, ConfigUntil.ROLE_USER);
            return "success";
        } catch (Exception e) {
            System.out.println(e);
            return "error";
        }
    }

    /**
     * This update page is for user login with password only
     * If user is login via remember me cookie, send login to ask for password again
     * To avoid stolen remember me cookie to updateinfo
     */
    @RequestMapping(value = "/admin/update**", method = RequestMethod.GET)
    public String updatePage(HttpServletRequest request, ModelMap modelMap) {
        if (isRememberMeAuthenticated()) {
            // send login for update
            setRememberMeTargetUrlToSession(request);
            modelMap.addAttribute("loginUpdate", true);
            return "login";
        }
        return "index";
    }


    /**
     * Check if user is login by remember me cookie, refer
     * org.springframework.security.authentication.AuthenticationTrustResolverImpl
     */
    private boolean isRememberMeAuthenticated() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return false;
        }

        return RememberMeAuthenticationToken.class.isAssignableFrom(authentication.getClass());

    }

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

    /*end remember user*/

}
