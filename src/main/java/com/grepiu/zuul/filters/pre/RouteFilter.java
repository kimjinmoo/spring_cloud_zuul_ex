package com.grepiu.zuul.filters.pre;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

public class RouteFilter extends ZuulFilter {

  private final Logger log = LoggerFactory.getLogger(getClass());

  @Override
  public String filterType() {
    return FilterConstants.ROUTE_TYPE;
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
    log.debug("Route Filter");
    return null;
  }
}
