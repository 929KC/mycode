package com.kc.service;

import org.springframework.web.multipart.MultipartFile;

import javax.xml.ws.Response;

public interface UploadService {
    Response uploadImg(MultipartFile img);
}
