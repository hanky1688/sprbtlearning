package com.hanky.study.web.controller;

import com.hanky.study.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


@Slf4j
@RestController
public class LearnController {

    // private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    //@ResponseBody
    //@RequestMapping("/login")
    public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response) {
        //日志级别从低到高分为TRACE < DEBUG < INFO < WARN < ERROR < FATAL，如果设置为WARN，则低于WARN的信息都不会输出。
        log.trace("日志输出 trace");
        log.debug("日志输出 debug");
        log.info("日志输出 info");
        log.warn("日志输出 warn");
        log.error("日志输出 error");
        Map<String, Object> map = new HashMap<String, Object>();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        if (StringUtils.isNotEmpty(userName) && StringUtils.isNotEmpty(password) ){
            User user = new User(userName, password);
            request.getSession().setAttribute("user", user);
            map.put("result", "1");
        } else {
            map.put("result", "0");
        }
        return map;
    }
}
