package vn.hoangptit.learningframework.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.File;

/**
 * author Hoangptit
 * Date 8/3/2016
 */
public class ConfigUntil {

    public final static String ROLE_USER = "ROLE_USER";
    public final static String ROLE_ADMIN = "ROLE_ADMIN";
    public final static String ROLE_EMPLOYEE = "ROLE_EMPLOYEE";
    public static final String PATH_URL = getPathUrl();

    public static String encode(String input) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String inputEncode = encoder.encode(input);

        return inputEncode;
    }

    public static String getPathUrl(){
        File currentDirectory = new File(new File(".").getAbsolutePath());
        String path[] = currentDirectory.getPath().split("\\.");
        String link_path =  path[0] + "\\src\\main\\webapp\\upload\\";
        return link_path;
    }

}
