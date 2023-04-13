package com.kc.cloudsearch.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kc.cloudsearch.model.entity.Picture;

/**
 * 图片服务
 *
 * @author
 * @from
 */
public interface PictureService  {
    Page<Picture> searchPicture(String searchText, long pageNum, long pageSize);

}
