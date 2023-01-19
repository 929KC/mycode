package com.kc.controller;

import com.kc.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.ws.Response;

@RestController
public class UploadController {
    @Autowired
    private UploadService uploadService;
    @PostMapping("/upload")
    public Response uploadImg(MultipartFile img){
        return uploadService.uploadImg(img);
    }
}
