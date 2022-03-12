package com.onisun.demo4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author Neo
 * @version 1.0
 */
@Controller
public class UploadController {

    @RequestMapping("/upload")
    public String upload(String desc, @RequestParam("file") MultipartFile multipartFile) throws IOException {
        System.out.println("desc : " + desc);
        System.out.println("getOriginalFilename : " + multipartFile.getOriginalFilename());
        multipartFile.transferTo(new File("h:\\upFile\\" + multipartFile.getOriginalFilename()));
        return "success";
    }
}
