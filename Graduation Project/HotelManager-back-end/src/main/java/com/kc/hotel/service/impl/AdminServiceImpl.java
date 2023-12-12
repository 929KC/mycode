package com.kc.hotel.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kc.hotel.mapper.AdminMapper;
import com.kc.hotel.service.AdminService;
import com.kc.hotel.model.domain.Admin;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(rollbackFor = Exception.class)
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    
}

