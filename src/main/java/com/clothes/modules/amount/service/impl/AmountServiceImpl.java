package com.clothes.modules.amount.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.clothes.modules.amount.mapper.AmountMapper;
import com.clothes.modules.amount.service.AmountService;
import com.clothes.modules.notice.entity.AmountEntity;

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
    private AmountMapper noticeMapper;

    /**
     * 獲取公告impl
     * @return
     */

    public List<AmountEntity> amountList(EntityWrapper<AmountEntity> entityEntityWrapper) {
        List<AmountEntity> noticeEntities = noticeMapper.selectList(entityEntityWrapper);
        return noticeEntities;
    }
}
