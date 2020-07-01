package com.grepiu.zuul.filters.pre;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

public class ErrorFilter extends ZuulFilter {

  private final Logger log = LoggerFactory.getLogger(getClass());

  @Override
  public String filterType() {
    return FilterConstants.ERROR_TYPE;
  }

  @Override
  public int filterOrder() {
    return 999;
  }

  @Override
  public boolean shouldFilter() {
    log.debug("error filter");
    return RequestContext.getCurrentContext().getThrowable() != null;
  }

  @Override
  public Object run() throws ZuulException {
    Throwable throwable = RequestContext.getCurrentContext().getThrowable();
    log.info("error Filter : {}", throwable);
    return null;
  }
}
