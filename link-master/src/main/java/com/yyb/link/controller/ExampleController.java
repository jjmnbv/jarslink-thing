package com.yyb.link.controller;

import com.alipay.jarslink.api.impl.ModuleManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yyb
 * @since 2018-04-13
 */
@RestController
public class ExampleController {

    @Autowired
    ModuleManagerImpl moduleManager;

    /**
     * 处理请求
     */
    @RequestMapping(value = "/api/{module}/{action}", method = {RequestMethod.GET, RequestMethod.POST})
    public Object process(@PathVariable String module, @PathVariable String action, HttpServletRequest request) {
        // 这里直接传入 HttpServletRequest 让内部处理请求的相关数据
        return moduleManager.find(module).doAction(action, request);
    }


}
