package vn.hoangptit.learningframework.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * author Hoangptit
 * Date 8/3/2016
 */
public class ConfigUntil {

    public final static String ROLE_USER = "ROLE_USER";
    public final static String ROLE_ADMIN = "ROLE_ADMIN";
    public final static String ROLE_EMPLOYEE = "ROLE_EMPLOYEE";
    public static final String PATH_URL = "G:/OneDrive/Spring/WorkspaceSpring/Spring-MVC-Hoangptit-LTE/src/main/webapp/upload/";

    public static String encode(String input) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String inputEncode = encoder.encode(input);

        return inputEncode;
    }

}
