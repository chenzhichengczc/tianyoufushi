package com.clothes.modules.banner.controller;

import com.clothes.common.utils.ResponseUtil;
import com.clothes.modules.banner.service.BannerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseUtil getListForType(String... type){

        String t = null;

        for (int i =0; i<type.length;i++){
            t = type[i];

            switch (t){
                case "topLogo":
                    bannerService.getBannerEntityList(t);
                    break;
                case "home":
                    bannerService.getBannerEntityList(t);
                    break;
                case "hot":
                    bannerService.getBannerEntityList(t);
                    break;
                case "duihuan":
                    bannerService.getBannerEntityList(t);
                    break;
                case "goods":
                    bannerService.getBannerEntityList(t);
                    break;
                default:
                    break;
            }
        }
        return ResponseUtil.success( bannerService.getBannerEntityList(t));
    }
}
