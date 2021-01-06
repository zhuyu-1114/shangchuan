package com.yuntu.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class LoginInterceptor implements HandlerInterceptor {
    //不过滤的页面的集合
    //通过依赖注入了值
    private List<String> exceptUrls;
    public void setExceptUrls(List<String> exceptUrls) {
        this.exceptUrls = exceptUrls;
    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        Object object = session.getAttribute("user");
        //直接写判断

       /* String uri = httpServletRequest.getRequestURI();
        if (uri.indexOf("/doLogin")>=0||uri.indexOf("/login")>=0){
            return true;
        }*/

        //1.先获取到请求的URL
        //2.通过xml文件中的参数，判断哪些不许要过滤
        //contains:判断集合中是否有这个值
        String uri = httpServletRequest.getRequestURI();
        if(uri.indexOf("static")!=-1){
            return true;
        }
        //拿到最后面的页面请求信息
        String uriStr = uri.substring(uri.lastIndexOf("/"));
        if(exceptUrls.contains(uriStr)){
            return true;
        }
        if (object!=null){
            //正常放行
            return true;
        }
        //如果没有登陆
        httpServletResponse.sendRedirect("/2020_12_14Project/user/login");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
