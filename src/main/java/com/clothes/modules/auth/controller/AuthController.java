package com.clothes.modules.auth.controller;

import cn.hutool.json.JSONObject;
import com.clothes.common.exception.JcException;
import com.clothes.common.utils.HttpRequest;
import com.clothes.common.utils.ResponseUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/8/13 18:01
 * @description：
 * @modified By：
 * @version:
 */
@RestController
@RequestMapping("/wx/user")
public class AuthController {

    /**
     * 获取用户userInfo
     */
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    public ResponseUtil getUserInfo(String appid, String secret, String js_code, String grantType){

        Map map = new HashMap();

        // 登录凭证不能为空
        if (js_code == null || js_code.length() == 0) {
            throw new JcException("code不能为空");
        }

        // 小程序唯一标识 (在微信小程序管理后台获取)
        String wxspAppid = appid;
        // 小程序的 app secret (在微信小程序管理后台获取)
        String wxspSecret = secret;
        //////////////// 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid
        //////////////// ////////////////
        // 请求参数
        String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + js_code + "&grant_type=" + grantType;
        // 发送请求
        System.out.println("params = " + params);
        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
        System.out.println("sr = " + sr);
        // 解析相应内容（转换成json对象）
        JSONObject json = new JSONObject(sr);
        System.out.println("json = " + json);
        // 获取会话密钥（session_key）
        String session_key = json.get("session_key").toString();
        // 用户的唯一标识（openid）
        String openid = (String) json.get("openid");
        //////////////// 2、对encryptedData加密数据进行AES解密 ////////////////
        map.put("session_key", session_key);
        map.put("openid", openid);
        String client_credential = "client_credential";
        String params1 = "&grant_type=" + client_credential +"&appid=" + wxspAppid + "&secret=" + wxspSecret  ;
        String getSr = HttpRequest.sendGet("https://api.weixin.qq.com/cgi-bin/token",params1);
        JSONObject getSrJson = new JSONObject(getSr);
        String access_token = (String)getSrJson.get("access_token");
        map.put("access_token",access_token);
        return ResponseUtil.success(map);
    }
}
