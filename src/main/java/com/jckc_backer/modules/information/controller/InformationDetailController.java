package com.jckc_backer.modules.information.controller;

import com.jckc_backer.modules.information.service.InformationDetailService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：Mr.Chan
 * * @date ：Created in 2019/3/12 15:20
 * * @description：资讯详情信息controller
 * @modified By：
 * @version:
 */
@RestController
@RequestMapping("/informationDetail")
@Api(description = "资讯详请核心表")
public class InformationDetailController {

    @Autowired
    private InformationDetailService informationDetailService;



}
