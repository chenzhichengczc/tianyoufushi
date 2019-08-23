package com.clothes.modules.banner.controller;

import com.clothes.common.utils.ResponseUtil;
import com.clothes.modules.banner.entity.BannerEntity;
import com.clothes.modules.banner.service.BannerService;
import io.swagger.annotations.Api;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2019/8/13 16:02
 * @description：
 * @modified By：
 * @version:
 */

@RestController
@Api(tags = "logo图")
@RequestMapping("/wx/api")
public class BannerController {

    @Autowired
    private BannerService bannerService;


    @RequestMapping(value = "/banner/list", method = RequestMethod.GET)
    public ResponseUtil getListForType(String type,@RequestParam(required = false) String key){
        
        List<BannerEntity> bannerEntityList = bannerService.getBannerEntityList(type,key);

        return ResponseUtil.success(bannerEntityList);
    }
}
