package com.clothes.conifig;

import com.alibaba.fastjson.JSON;
import com.clothes.basic.ResponseBase;
import com.clothes.common.exception.JcException;
import com.clothes.common.exception.JcExceptionHandler;
import com.clothes.common.utils.ResponseUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/8/16 16:42
 * @description：自定义过滤器
 * @modified By：
 * @version:
 */
@Component
public class AuthenFilter implements Filter {

    @Resource
    private JwtConfig jwtConfig;

    private static final Logger logger = LoggerFactory.getLogger(JcExceptionHandler.class);

    ResponseUtil responseUtil;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        try {
            System.out.println("hello = ");
            //过滤不是post的请求
            System.out.println("request.getMethod().equalsIgnoreCase(\"post\") = " + request.getMethod().equalsIgnoreCase("post"));
            System.out.println("request.getMethod() = " + request.getMethod());
            if(!request.getMethod().equalsIgnoreCase("post")){
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }



            String token = request.getHeader("token");
            System.out.println("token = " + token);
            //请求头token为空返回
            if(StringUtils.isEmpty(token)){
                System.out.println("token 1= " + token);
                responseUtil = ResponseUtil.error(HttpStatus.BAD_REQUEST.value(), "无token");
                logger.info("无token");
                return;
            }
            System.out.println("jwtConfig = " + jwtConfig);
            //token验证

            boolean result = jwtConfig.verifyToken(token);
            System.out.println("result = " + result);
            if(!result){
                System.out.println("fad = ");
                responseUtil = ResponseUtil.error(HttpStatus.BAD_REQUEST.value(), "token已过期,请重新登陆");
                logger.info("token已过期,请重新登陆");
                return;
            }

            filterChain.doFilter(servletRequest, servletResponse);

        }catch (Exception e){

        }finally {
            System.out.println("responseUtil = " + responseUtil);
            if(responseUtil != null && !StringUtils.isEmpty((String)responseUtil.get("msg"))){
                response.setCharacterEncoding("utf-8");
                response.getWriter().write(JSON.toJSONString(responseUtil));
            }
        }

    }
}
