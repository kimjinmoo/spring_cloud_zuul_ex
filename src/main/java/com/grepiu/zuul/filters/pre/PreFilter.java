package com.grepiu.zuul.filters.pre;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 *
 * Sample Filter
 *
 */
public class PreFilter extends ZuulFilter {

  private static Logger log = LoggerFactory.getLogger(PreFilter.class);

  @Override
  public String filterType() {
    return FilterConstants.PRE_TYPE;
  }

  @Override
  public int filterOrder() {
    return 1;
  }



  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() throws ZuulException {
    RequestContext ctx = RequestContext.getCurrentContext();
    HttpServletRequest request = ctx.getRequest();

    log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
    log.debug(" prefilter");
    return null;
  }
}
