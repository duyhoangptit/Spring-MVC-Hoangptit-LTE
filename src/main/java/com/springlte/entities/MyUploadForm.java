package com.springlte.entities;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * author Hoangptit
 * Date 5/28/2016
 */
public class MyUploadForm {

    private String description;

    // Upload files.
    private CommonsMultipartFile[] fileDatas;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CommonsMultipartFile[] getFileDatas() {
        return fileDatas;
    }

    public void setFileDatas(CommonsMultipartFile[] fileDatas) {
        this.fileDatas = fileDatas;
    }
}
