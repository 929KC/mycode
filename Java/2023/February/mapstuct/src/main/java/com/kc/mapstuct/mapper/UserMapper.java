package com.kc.mapstuct.mapper;

import com.kc.mapstuct.model.UserEntity;
import com.kc.mapstuct.model.UserPo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
	UserMapper INSTANCT = Mappers.getMapper(UserMapper.class);
	UserEntity po2entity(UserPo userPo);
}

