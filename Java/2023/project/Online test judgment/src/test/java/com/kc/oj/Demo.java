package com.kc.oj;
import java.util.Date;

import com.kc.oj.model.entity.User;
import org.junit.jupiter.api.Test;

public class Demo {

    @Test
    void testDemo() {
        User user = new User();
        user.setId(0L);
        user.setUserAccount("");
        user.setUserPassword("");
        user.setUnionId("");
        user.setMpOpenId("");
        user.setUserName("");
        user.setUserAvatar("");
        user.setUserProfile("");
        user.setUserRole("");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setIsDelete(0);
        Long id = user.getId();
        String userAccount = user.getUserAccount();
        String userPassword = user.getUserPassword();
        String unionId = user.getUnionId();
        String mpOpenId = user.getMpOpenId();
        String userName = user.getUserName();
        String userAvatar = user.getUserAvatar();
        String userProfile = user.getUserProfile();
        String userRole = user.getUserRole();
        Date createTime = user.getCreateTime();
        Date updateTime = user.getUpdateTime();
        Integer isDelete = user.getIsDelete();

    }
}
