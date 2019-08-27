package com.clothes.modules.auth.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.clothes.common.utils.GetOpenIdUtils;
import com.clothes.modules.address.entity.AddressEntity;
import com.clothes.modules.auth.entity.UserEntity;
import com.clothes.modules.auth.mapper.UserMapper;
import com.clothes.modules.auth.service.UserService;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/7/2 17:31
 * @description：
 * @modified By：
 * @version:
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    @Autowired
    private GetOpenIdUtils getOpenIdUtils;

    @Override
    public Integer checkOpenId(EntityWrapper wrapper, String openId) {

        //根据openId判断数据库是否存在
        Integer openIdAccount = userMapper.getCount(openId);
        System.out.println("openIdAccount = " + openIdAccount);
        return openIdAccount;
    }

    @Override
    public void insertUser(UserEntity userEntity) {

        BASE64Encoder encoder = new BASE64Encoder();

        System.out.println("userEntity = " + userEntity.getNickName());
        try {
            //防止数据库不支持特殊符号,对微信名进行编码
            byte[] bytes = userEntity.getNickName().getBytes("UTF-8");
            String nameEncode = encoder.encode(bytes);
            System.out.println("nameEncode = " + nameEncode);
            userEntity.setNickName(nameEncode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        userMapper.insert(userEntity);
    }

    @Override
    public List<UserEntity> getUserDetail() {
        EntityWrapper<UserEntity> entityEntityWrapper = new EntityWrapper<>();
        List<UserEntity> userEntities = userMapper.selectList(entityEntityWrapper);
        return userEntities;
    }

    @Override
    public UserEntity getUserFind(String Openid) {
        UserEntity userEntity = userMapper.selectVip(Openid);
        return userEntity;
    }

    @Override
    public void updateUser(String openId) {
        userMapper.updateVip(openId);
    }
}
