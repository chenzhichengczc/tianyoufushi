package com.clothes.modules.content.service.impl;

import com.clothes.modules.content.entity.ContentEntity;
import com.clothes.modules.content.mapper.ContentMapper;
import com.clothes.modules.content.service.ContentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import javax.annotation.Resource;


@Service
public class ContentServiceImpl extends ServiceImpl<ContentMapper, ContentEntity> implements ContentService {
    @Resource
    private ContentMapper contentMapper;

    public List<ContentEntity> contentList(EntityWrapper<ContentEntity> entityEntityWrapper){
           return  contentMapper.selectList(entityEntityWrapper);
    }



}
