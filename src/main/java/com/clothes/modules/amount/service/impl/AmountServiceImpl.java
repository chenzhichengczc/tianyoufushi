package com.clothes.modules.amount.service.impl;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.clothes.modules.amount.entity.AmountEntity;
import com.clothes.modules.amount.mapper.AmountMapper;
import com.clothes.modules.amount.service.AmountService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/8/13 16:26
 * @description：
 * @modified By：
 * @version:
 */
@Service
public class AmountServiceImpl extends ServiceImpl<AmountMapper, AmountEntity> implements AmountService {

    @Resource
    private AmountMapper amountMapper;

    /**
     * 獲取公告impl
     * @return
     */

    public List<AmountEntity> amountList(EntityWrapper<AmountEntity> entityEntityWrapper, String openId) {
        entityEntityWrapper.eq("open_id", openId);
        List<AmountEntity> noticeEntities = amountMapper.selectList(entityEntityWrapper);
        return noticeEntities;
    }
}
