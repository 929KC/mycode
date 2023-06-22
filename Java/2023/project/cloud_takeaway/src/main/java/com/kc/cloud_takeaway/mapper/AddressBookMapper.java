package com.kc.cloud_takeaway.mapper;

import com.kc.cloud_takeaway.model.entity.AddressBook;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 929KC
* @description 针对表【address_book(地址管理)】的数据库操作Mapper
* @createDate 2023-06-22 13:55:04
* @Entity com.kc.cloud_takeaway.model.entity.AddressBook
*/

@Mapper
public interface AddressBookMapper extends BaseMapper<AddressBook> {

}




