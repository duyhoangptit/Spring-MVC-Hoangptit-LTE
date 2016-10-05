package vn.hoangptit.learningframework.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vn.hoangptit.learningframework.configs.SendMail;

public class SendMailController {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mail.xml");

        SendMail mm = (SendMail) context.getBean("htmlMail");
        String html = "<p>Hi!</p><a href=\"google.com\">Link text</a>";
		// Send Mail
        mm.sendMail("duyhoangptit@gmail.com",
                "hoang15081994@gmail.com",
                "test html email",
                html);

    }
}
