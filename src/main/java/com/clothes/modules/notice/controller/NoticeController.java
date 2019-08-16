package com.clothes.modules.notice.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.clothes.common.utils.ResponseUtil;
import com.clothes.modules.notice.entity.NoticeEntity;
import com.clothes.modules.notice.service.NoticeService;
import com.mysql.jdbc.util.ResultSetUtil;
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
@RequestMapping("/wx/api")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    /**
     * 公告列表
     * @return
     */
    @RequestMapping(value = "/notice/list", method = RequestMethod.GET)
    public ResponseUtil getNoticeList(){

        EntityWrapper<NoticeEntity> entityEntityWrapper = new EntityWrapper<>();

        List<NoticeEntity> noticeEntities = noticeService.noticeList(entityEntityWrapper);
        return ResponseUtil.success(noticeEntities);
    }
}
