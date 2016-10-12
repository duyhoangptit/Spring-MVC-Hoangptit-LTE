package vn.hoangptit.learningframework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import vn.hoangptit.learningframework.dto.AccountDto;
import vn.hoangptit.learningframework.dto.CustomerDto;
import vn.hoangptit.learningframework.dto.FriendDto;
import vn.hoangptit.learningframework.service.AccountService;
import vn.hoangptit.learningframework.service.CustomerService;
import vn.hoangptit.learningframework.utils.ConfigUntil;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * author Hoangptit
 * Date 10/9/2016
 */
@Controller
@RequestMapping(value = "profile")
public class ProfileUserController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "updateProfile", method = RequestMethod.POST)
    public String updateProfile(ModelMap modelMap, @RequestParam("file") MultipartFile file, HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String fullName = request.getParameter("fullName");
        String avatar = request.getParameter("avatar");
        // kiểm tra nếu password null thì gán password cũ, còn nếu avatar rỗng thì cũng gán lại path cũ
        // cập nhật avatar
        String fileName = null;
        if (!file.isEmpty()) {
            try {
                fileName = file.getOriginalFilename();
                byte[] bytes = file.getBytes();
                BufferedOutputStream buffStream =
                        new BufferedOutputStream(new FileOutputStream(new File(ConfigUntil.PATH_URL + fileName)));
                buffStream.write(bytes);
                buffStream.close();
            } catch (Exception e) {
                return "You failed to upload " + fileName + ": " + e.getMessage();
            }
        }
        // update account
        AccountDto account = new AccountDto();
        account.setUsername(username);
        account.setPassword(password);

        // update customer
        CustomerDto customer = new CustomerDto();
        customer.setAvatar(avatar);
        customer.setFullName(fullName);
        customer.setEmail(email);

        account.setCustomer(customer);

        customerService.updateAccount(account);
        return "";
    }

    @RequestMapping(value = "addFriend", method = RequestMethod.POST)
    public String addFriends(@RequestParam("file") MultipartFile file, ModelMap modelMap,
                             @ModelAttribute(value = "friend") FriendDto friend) {
        String fileName = null;
        if (!file.isEmpty()) {
            try {
                fileName = file.getOriginalFilename();
                byte[] bytes = file.getBytes();
                BufferedOutputStream buffStream =
                        new BufferedOutputStream(new FileOutputStream(new File(ConfigUntil.PATH_URL + fileName)));
                buffStream.write(bytes);
                buffStream.close();
            } catch (Exception e) {
                return "You failed to upload " + fileName + ": " + e.getMessage();
            }
        }

        friend.setAvatar(fileName);
        customerService.addFriend(friend);
        return "redirect:/home/friend.html";
    }
}
