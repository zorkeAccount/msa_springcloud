package cn.caizhaoke.config;

import com.netflix.zuul.ZuulFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Component;

/**
 * @author zhaoke
 *         Created on 2018/2/23.
 */
//@Slf4j
@Component
public class LoggerFilter extends ZuulFilter {
    private static final Logger log = LoggerFactory.getLogger(LoggerFilter.class);

    @Autowired
    Tracer tracer;

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 900;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        tracer.addTag("operator","zorke");
        log.info(String.format("%s >>> %s", "traceIdString", tracer.getCurrentSpan().traceIdString()));

        return null;
    }
}
