package com.yyb.link.action;

import com.alipay.jarslink.api.Action;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yyb
 * @since 2018-04-13
 */
public class HelloAction implements Action<HttpServletRequest, String> {

    /**
     * 处理 业务逻辑 返回数据
     */
    @Override
    public String execute(HttpServletRequest request) {
        return "你好， 当前请求uri：" + request.getRequestURI();
    }

    /**
     * 定义 action 的名字
     */
    @Override
    public String getActionName() {
        return "hello";
    }

}
