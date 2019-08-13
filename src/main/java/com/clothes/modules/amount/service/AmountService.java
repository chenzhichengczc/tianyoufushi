package com.clothes.modules.amount.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.clothes.modules.notice.entity.AmountEntity;
import com.clothes.modules.notice.entity.NoticeEntity;

import java.util.List;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/8/13 16:25
 * @description：
 * @modified By：
 * @version:
 */
public interface AmountService {

    public List<AmountEntity> amountList(EntityWrapper<AmountEntity> entityEntityWrapper);
}
