package com.onisun.demo4.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;

/**
 * 完成文件下载
 * @author Neo
 * @version 1.0
 */
@Controller
public class DownloadController {

    @RequestMapping("/downLoad")
    public ResponseEntity<byte[]> downLoad(HttpServletRequest request) throws Exception {
        //获取要下载的文件路径
        ServletContext servletContext = request.getServletContext();
        String realPath = servletContext.getRealPath("/script/jquery-1.9.1.min.js");
        //获取输入流对象
        FileInputStream fis = new FileInputStream(realPath);

        byte[] bytes = new byte[fis.available()];
        fis.read(bytes);
        fis.close();
        //将要下载的文件返回
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("content-Disposition","attachment;filename=jquery-1.9.1.min.js");
        return new ResponseEntity<byte[]>(bytes,httpHeaders, HttpStatus.OK);
    }
}
