package com.kc.cloud_takeaway.controller;

import com.kc.cloud_takeaway.common.BaseResponse;
import com.kc.cloud_takeaway.common.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;


@Slf4j
@RestController
@RequestMapping("/common")
public class CommonController {
    @Value("${myimages.path}")
    private String basePath;

    @PostMapping("/upload")
    public BaseResponse<String> upLoad(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = UUID.randomUUID().toString() + suffix;
        //创建一个目录对象
        File dir = new File(basePath);
        //判断当前目录是否存在
        if(!dir.exists()){
            //目录不存在，需要创建
            dir.mkdirs();
        }
        try {
            file.transferTo(new File(basePath, fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultUtils.success(fileName);
    }

    @GetMapping("/download")
    public void upLoad(String name, HttpServletResponse response) throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream(basePath+name);
            response.setContentType("image/jpg");
            //返回给浏览器
            ServletOutputStream outputStream = response.getOutputStream();
            int len = 0;
            byte[] bytes = new byte[102400];
            while ((len = fileInputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
                outputStream.flush();
            }
            fileInputStream.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
