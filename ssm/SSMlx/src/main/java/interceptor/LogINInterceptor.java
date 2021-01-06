package interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class LogINInterceptor implements HandlerInterceptor {
    //不过滤的页面集合
    //通过依赖注入注入了值
    private List<String> exceptUrls;
    //exceptUrls的set方法
    public void setExceptUrls(List<String> exceptUrls) {
        this.exceptUrls = exceptUrls;
    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        Object obj = session.getAttribute("user");
        /*//直接写判断
        //1.先获取到请求的URL
        String uri = httpServletRequest.getRequestURI();
        String url = httpServletRequest.getRequestURL().toString();
        System.out.println("URI地址："+uri);
        System.out.println("ERL地址："+url);
        if(url.indexOf("/login")>=0 || url.indexOf("/doLogin")>=0){
            return true;
        }*/
        //2.通过xml文件中的参数，判断哪些不需要过滤
        String uri = httpServletRequest.getRequestURI();
        //拿到最后面的页面请求信息
        String uriStr = uri.substring(uri.lastIndexOf("/"));
        //contains：判断集合中是否有这个值
        if(exceptUrls.contains(uriStr)){
            return true;
        }
        if(obj!=null){
            //正常放行
            return true;
        }
        //如果没有登录
        httpServletResponse.sendRedirect("/SSMlx/user/login.html");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
