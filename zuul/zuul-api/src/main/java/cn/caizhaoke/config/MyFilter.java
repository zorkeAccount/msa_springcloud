package cn.caizhaoke.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * zuul实现过滤功能，如做一些安全验证等！
 *
 * @author zhaoke
 *         Created on 2018/2/22.
 */
//@Slf4j
@Component
public class MyFilter  extends ZuulFilter {
    private static final Logger log = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public String filterType() {
        /*filterType：
            返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
            pre：路由之前
            routing：路由之时
            post： 路由之后
            error：发送错误调用*/
        return "pre";
    }

    @Override
    public int filterOrder() {
        //filterOrder：过滤的顺序
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
        return true;
    }

    @Override
    public Object run() {
        //run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。

        //也即token等http-headers可以在此统一处理！！！
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if (accessToken == null) {
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            } catch (Exception e) {

            }

            return null;
        }
        log.info("ok");
        return null;
    }

}

