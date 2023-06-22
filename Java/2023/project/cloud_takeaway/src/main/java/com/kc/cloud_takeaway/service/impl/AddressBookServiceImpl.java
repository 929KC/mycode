package com.kc.cloud_takeaway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kc.cloud_takeaway.model.entity.AddressBook;
import com.kc.cloud_takeaway.service.AddressBookService;
import com.kc.cloud_takeaway.mapper.AddressBookMapper;
import org.springframework.stereotype.Service;

/**
* @author 929KC
* @description 针对表【address_book(地址管理)】的数据库操作Service实现
* @createDate 2023-06-22 13:55:04
*/
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook>
    implements AddressBookService{

}




