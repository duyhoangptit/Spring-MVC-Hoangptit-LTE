package com.springlte.controller;

import com.springlte.until.ConfigUntil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * author Hoangptit
 * Date 8/21/2016
 */
@Controller
@RequestMapping(value = "upload")
public class UploadController {

    /**
     * Upload one file
     */
    @RequestMapping(value = "singleSave", method = RequestMethod.POST)
    @ResponseBody
    public String singleSave(@RequestParam("file") MultipartFile file,HttpServletRequest request) {
        // 2 cách lấy data
        String fileName = null;
        if (!file.isEmpty()) {
            try {
                fileName = file.getOriginalFilename();
                byte[] bytes = file.getBytes();
                BufferedOutputStream buffStream =
                        new BufferedOutputStream(new FileOutputStream(new File(ConfigUntil.PATH_URL + fileName)));
                buffStream.write(bytes);
                buffStream.close();
                return "You have successfully uploaded " + fileName;
            } catch (Exception e) {
                return "You failed to upload " + fileName + ": " + e.getMessage();
            }
        } else {
            return "Unable to upload. File is empty.";
        }
    }

    /**
     * Upload many file
     */
    @RequestMapping(value = "multipleSave", method = RequestMethod.POST)
    @ResponseBody
    public String multipleSave(@RequestParam("file") MultipartFile[] files, HttpServletRequest request) {
        // result data request
        String fileName = null;
        String msg = "";
        if (files != null && files.length > 0) {
            for (int i = 0; i < files.length; i++) {
                try {
                    fileName = files[i].getOriginalFilename();
                    byte[] bytes = files[i].getBytes();
                    BufferedOutputStream buffStream =
                            new BufferedOutputStream(new FileOutputStream(new File(ConfigUntil.PATH_URL + fileName)));
                    System.out.println(ConfigUntil.PATH_URL + fileName);
                    buffStream.write(bytes);
                    buffStream.close();
                    msg += "You have successfully uploaded " + fileName + "<br/>";
                } catch (Exception e) {
                    return "You failed to upload " + fileName + ": " + e.getMessage() + "<br/>";
                }
            }
            return msg;
        } else {
            return "Unable to upload. File is empty.";
        }
    }

}
