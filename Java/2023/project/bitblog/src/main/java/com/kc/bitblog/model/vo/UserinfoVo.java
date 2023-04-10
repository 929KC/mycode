package com.kc.bitblog.model.vo;

import com.kc.bitblog.model.domain.Userinfo;
import lombok.Data;


@Data
public class UserinfoVo extends Userinfo {
    //此人发表文章的文章总数
    private Integer artCount;
}
