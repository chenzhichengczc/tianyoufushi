package com.clothes.modules.content.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.clothes.common.utils.ResponseUtil;
import com.clothes.modules.content.entity.ContentEntity;
import com.clothes.modules.content.service.ContentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 
 *
 * @author fenghuang
 * @email 
 * @date 2019-08-16 11:18:11
 */
@RestController
@RequestMapping("/wx/api")
public class ContentController {
    @Autowired
    private ContentService contentService;

    /**
     * 列表
     */
    @RequestMapping(value = "/content/contentList", method = RequestMethod.GET)
    public ResponseUtil list(@RequestParam Map<String, Object> params){
        EntityWrapper<ContentEntity> entityEntityWrapper = new EntityWrapper<>();

        List<ContentEntity> contentEntities = contentService.contentList(entityEntityWrapper);
        return ResponseUtil.success(contentEntities);
    }




}
