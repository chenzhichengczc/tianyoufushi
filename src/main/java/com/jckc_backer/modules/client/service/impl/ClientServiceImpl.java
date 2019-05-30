package com.jckc_backer.modules.client.service.impl;


import com.jckc_backer.common.utils.UUIDUtils;
import com.jckc_backer.modules.client.entity.vo.ClientVO;
import com.jckc_backer.modules.client.mapper.ClientMapper;
import com.jckc_backer.modules.client.service.ClientService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/5/22 14:56
 * @description：
 * @modified By：
 * @version:
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Resource
    private ClientMapper clientMapper;

    @Override
    public void insertClient(ClientVO clientVO) {
        String uuid = UUIDUtils.getUUID();
        if(clientVO.getCompanyCode() == null || "".equals(clientVO.getCompanyCode())){
            clientVO.setCompanyCode(uuid);
        }
        System.out.println("clientVO = " + clientVO);
        clientMapper.insertClient(clientVO);
    }

    @Override
    public void updateClient(ClientVO clientVO) {
        clientMapper.updateClient(clientVO);
    }

    @Override
    public List<ClientVO> selectPage() {
        List<ClientVO> clientList = clientMapper.selectPage();
        return clientList;
    }

    @Override
    public void delete(Integer id) {
        clientMapper.delete(id);
    }

   /* @Override
    public void insert(ClientEntity clientEntity, ClientInformationEntity clientInformationEntity, ClientCompanyEntity clientCompanyEntity) {
        if(clientEntity.getClientType() != null && (clientEntity.getClientType()).equals("0")){
            System.out.println("clientEntity = " + clientEntity);
            String linkCode = UUIDUtils.getUUID();
            clientInformationEntity.setLinkCode(linkCode);
            clientMapper.insertClientInformation(clientInformationEntity);
            System.out.println("linkId = " + clientInformationEntity.getLinkId());
            clientEntity.setClientId(clientInformationEntity.getLinkId());
            clientMapper.insertClient(clientEntity);
            if (clientCompanyEntity.getCompanyCode() == null) {
                clientCompanyEntity.setCompanyCode(linkCode);
                clientMapper.insertClientCompany(clientCompanyEntity);
            }
        }
    }*/
}
