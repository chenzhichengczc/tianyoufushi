package com.jckc_backer.modules.client.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jckc_backer.common.utils.ResponseUtil;
import com.jckc_backer.modules.client.entity.vo.ClientVO;
import com.jckc_backer.modules.client.service.ClientService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/5/22 10:25
 * @description：
 * @modified By：
 * @version:
 */
@RestController
@RequestMapping("/client")
@Api(description = "客户")
public class ClientController {

    @Autowired
    private ClientService clientService;

   /* @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public ResponseUtil insert(ClientEntity clientEntity, ClientInformationEntity clientInformationEntity, ClientCompanyEntity clientCompanyEntity){
        clientService.insert(clientEntity,clientInformationEntity,clientCompanyEntity);
        return ResponseUtil.success();
    }
*/
   @RequestMapping(value = "/insert",method = RequestMethod.POST)
   public ResponseUtil insert(ClientVO clientVO){
       clientService.insertClient(clientVO);
       return ResponseUtil.success();
   }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public ResponseUtil update(ClientVO clientVO){
        clientService.updateClient(clientVO);
        return ResponseUtil.success();
    }

    @RequestMapping(value = "/selectPage",method = RequestMethod.GET)
    public ResponseUtil update(Integer pageNo,Integer pageSize){
        PageHelper.startPage(pageNo, pageSize);
        List<ClientVO> list = clientService.selectPage();
        PageInfo<ClientVO> pageInfo = new PageInfo<>(list);
        return ResponseUtil.success(pageInfo);
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public ResponseUtil delete(@PathVariable Integer id){
        clientService.delete(id);
        return ResponseUtil.success();
    }
}
