package com.imjohn.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @ClassName FileController
 * @Author ImJohn
 * @Date 2021/4/16 上午 9:07
 **/
@Controller
@RequestMapping("/api/file")
@Slf4j
public class FileController {
    @Value("${filepath}")
    private String filepath;
    @Value("${loadpath}")
    private String loadpath;
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        File targetFile = new File(filepath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        try (FileOutputStream out = new FileOutputStream(filepath +"/" + file.getOriginalFilename());){
            out.write(file.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("文件上传失败!");
            return "uploading failure";
        }

        log.info("文件上传成功!");
        return "uploading success";
    }
    @RequestMapping("/download")
    public void downLoad(HttpServletResponse response) throws UnsupportedEncodingException {
        String filename="下载测试.pdf";
        File file = new File(loadpath + "/" + filename);
        if(file.exists()){
            response.setContentType("application/octet-stream");
            response.setHeader("content-type", "application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(filename,"utf8"));
            byte[] buffer = new byte[1024];
            //输出流
            OutputStream os = null;
            try(FileInputStream fis= new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis);) {
                os = response.getOutputStream();
                int i = bis.read(buffer);
                while(i != -1){
                    os.write(buffer);
                    i = bis.read(buffer);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            log.info("文件下载成功!");
        }
    }
}
