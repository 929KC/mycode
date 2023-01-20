package com.kc.service.impl;

import com.google.gson.Gson;
import com.kc.domain.ResponseResult;
import com.kc.enums.AppHttpCodeEnum;
import com.kc.exception.SystemException;
import com.kc.service.UploadService;
import com.kc.utils.PathUtils;
import com.qiniu.common.QiniuException;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
@ConfigurationProperties(prefix = "oss")
@Service
@Data
public class UploadServiceImpl implements UploadService {
    private String accessKey;
    private String secretKey;
    private String bucket;

    @Override
    public ResponseResult uploadImg(MultipartFile img) {
        String originalFilename = img.getOriginalFilename();
        if (!originalFilename.endsWith(".jpg")) {
            throw new SystemException(AppHttpCodeEnum.FILE_NOT_ERROR);
        }
        String filePath = PathUtils.generateFilePath(originalFilename);
        String url = uploadOss(img,filePath);
        return ResponseResult.okResult(url);
    }

    private String uploadOss(MultipartFile imgFile, String filePath) {
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.autoRegion());
        cfg.resumableUploadAPIVersion = Configuration.ResumableUploadAPIVersion.V2;// 指定分片上传版本
//...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
//默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = filePath;
        try {
            InputStream inputStream = imgFile.getInputStream();
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);
            try {
                com.qiniu.http.Response response = uploadManager.put(inputStream, key, upToken, null, null);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                System.out.println(putRet.key);
                System.out.println(putRet.hash);
                return "http://roob1vuvq.hn-bkt.clouddn.com/"+key;
            } catch (QiniuException ex) {
                com.qiniu.http.Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        } catch (Exception ex) {
            //ignore
        }
        return "www";
    }
}
