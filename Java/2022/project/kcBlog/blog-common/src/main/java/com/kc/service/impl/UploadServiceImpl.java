package com.kc.service.impl;

import com.kc.service.UploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.ws.Response;

@Service
public class UploadServiceImpl implements UploadService {
    @Override
    public Response uploadImg(MultipartFile img) {
        return null;
    }
}
