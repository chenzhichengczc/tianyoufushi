package com.jckc_backer.modules.client.mapper;

import com.jckc_backer.modules.client.entity.vo.ClientVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/5/22 14:53
 * @description：
 * @modified By：
 * @version:
 */

public interface ClientMapper {

  /*  public Integer insertClientInformation(ClientInformationEntity clientInformationEntity);

    public void insertClientCompany(ClientCompanyEntity clientCompanyEntity);

    public void insertClient(ClientEntity clientEntity);*/

    public void insertClient(ClientVO clientVO);

    public void updateClient(ClientVO clientVO);

    public List<ClientVO> selectPage();

    public void delete(@Param("id") Integer id);
}
