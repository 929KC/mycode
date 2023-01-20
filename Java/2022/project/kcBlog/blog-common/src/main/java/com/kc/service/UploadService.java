package com.kc.service;

import com.kc.domain.ResponseResult;
import org.springframework.web.multipart.MultipartFile;



public interface UploadService {
    ResponseResult uploadImg(MultipartFile img);
}
