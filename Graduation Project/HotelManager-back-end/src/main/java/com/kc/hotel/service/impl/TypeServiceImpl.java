package com.kc.hotel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kc.hotel.mapper.TypeMapper;
import com.kc.hotel.model.domain.Type;
import com.kc.hotel.service.TypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(rollbackFor = Exception.class)
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements TypeService {

    
}

