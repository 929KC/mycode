package com.kc.shoping.mapper;

import com.kc.shoping.model.Message;
import com.kc.shoping.vo.MessageVo;

import java.util.List;

/**
 * @author: 929KC
 * @date 2022/12/13 8:26
 * @description:
 * @version: 0.0.1
 **/
public interface MessageMapper {
    List<Message> queryUserMessage();
    MessageVo queryMessageVo(int id);
    int deleteMessage(int id);
}
