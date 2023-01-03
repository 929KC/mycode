package com.kc.shoping.mapper;

import com.kc.shoping.model.Notice;

import java.util.List;

/**
 * @author 929KC
 * @date 2022/12/13 16:01
 * @description:
 */
public interface NoticeMapper {
    List<Notice> queryNotice();
    void deleteNotice(int id);
    void addNotice(String title, String content);
}
