package com.kc.mapstuct;

import com.kc.mapstuct.mapper.UserMapper;
import com.kc.mapstuct.model.UserEntity;
import com.kc.mapstuct.model.UserPo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest(classes = MapstuctApplication.class)
class MapstuctApplicationTests {

    @Test
    void testEntityToDto() {
        System.out.println("-----------testNormal-----start------");
        UserPo userPo = UserPo.builder()
                .id(1L)
                .gmtCreate(new Date())
                .buyerId(666L)
                .userNick("测试mapstruct")
                .userVerified("ok")
                .age(18L)
                .build();
        System.out.println("1234" + userPo);
        UserEntity userEntity = UserMapper.INSTANCT.po2entity(userPo);
        System.out.println(userEntity);
        System.out.println("-----------testNormal-----ent------");

    }


}
