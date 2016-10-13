package vn.hoangptit.learningframework.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vn.hoangptit.learningframework.configs.SendMail;
import vn.hoangptit.learningframework.model.EmailModel;

@Controller
@RequestMapping(value = "email")
public class SendMailController {

    @RequestMapping(value = "sendMail", method = RequestMethod.POST)
    public String sendMail(@ModelAttribute(value = "mail") EmailModel mail, ModelMap modelMap) {
        System.out.println(mail.getTo());
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mail.xml");

        SendMail mm = (SendMail) context.getBean("htmlMail");
        mm.sendMail("duyhoangptit@gmail.com", mail.getTo(), mail.getSubject(), mail.getMsg());
        modelMap.addAttribute("message", "Send mail success");
        return "redirect:/home/homePage.html";
    }


}
