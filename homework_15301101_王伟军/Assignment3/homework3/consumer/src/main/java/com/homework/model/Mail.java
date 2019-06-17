package com.homework.model;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author wangweijun
 */
public class Mail {

    Logger logger = LoggerFactory.getLogger(Mail.class);

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String email;

    @Override
    public String toString() {
        try {
            return "toemail="+URLEncoder.encode(email,"utf8")+"&title="+URLEncoder.encode(title,"utf8")+"&content="+URLEncoder.encode(content,"utf8");
        } catch (UnsupportedEncodingException e) {
            logger.error("",e);
            return "";
        }
    }

    private String content;
}
