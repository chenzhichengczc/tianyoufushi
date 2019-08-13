package com.clothes.modules.notice.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.clothes.modules.notice.entity.NoticeEntity;
import com.clothes.modules.notice.mapper.NoticeMapper;
import com.clothes.modules.notice.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, NoticeEntity> implements NoticeService {

    @Resource
    private NoticeMapper noticeMapper;

    /**
     * 獲取公告impl
     * @return
     */
    @Override
    public List<NoticeEntity> noticeList(EntityWrapper<NoticeEntity> entityEntityWrapper) {
        List<NoticeEntity> noticeEntities = noticeMapper.selectList(entityEntityWrapper);
        return noticeEntities;
    }
}
