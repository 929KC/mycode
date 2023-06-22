package com.kc.cloud_takeaway.mapper;

import com.kc.cloud_takeaway.model.entity.OrderDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 929KC
* @description 针对表【order_detail(订单明细表)】的数据库操作Mapper
* @createDate 2023-06-22 14:19:28
* @Entity com.kc.cloud_takeaway.model.entity.OrderDetail
*/
@Mapper
public interface OrderDetailMapper extends BaseMapper<OrderDetail> {

}




