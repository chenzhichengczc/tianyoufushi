package com.clothes.modules.amount.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.clothes.common.utils.ResponseUtil;
import com.clothes.modules.amount.entity.AmountEntity;
import com.clothes.modules.amount.service.AmountService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/8/13 16:02
 * @description：
 * @modified By：
 * @version:
 */

@RestController
@Api(tags = "公告")
@RequestMapping("/wx")
public class AmountController {

    @Autowired
    private AmountService amountService;

    /**
     * 公告列表
     * @return
     */
    @RequestMapping(value = "/user/amount", method = RequestMethod.GET)
    public ResponseUtil getAmountList(){

        EntityWrapper<AmountEntity> entityEntityWrapper = new EntityWrapper<>();

        List<AmountEntity> noticeEntities = amountService.amountList(entityEntityWrapper);
        return ResponseUtil.success(noticeEntities);
    }
}
