package mobi.rayson.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-21
 *  Time: 上午11:00
 *  Description:
 **/
@Slf4j
public class PreRequestLogFilter extends ZuulFilter {

  @Override
  public String filterType() {
    return "pre";
  }

  @Override
  public int filterOrder() {
    return 1;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  //@Override
  //public Object run() {
  //    RequestContext requestContext = RequestContext.getCurrentContext();
  //    HttpServletRequest request = requestContext.getRequest();
  //    log.info("send {} to {}", request.getMethod(), request.getRequestURL().toString());
  //    return null;
  //}

  @Override
  public Object run() {
    HttpServletRequest req = RequestContext.getCurrentContext().getRequest();
    log.info("Request: >" + req.getScheme() + " " + req.getRemoteAddr() + ":" + req.getRemotePort());
    StringBuilder params = new StringBuilder("?");
    Enumeration<String> names = req.getParameterNames();
    if (req.getMethod().equals("GET")) {
      while (names.hasMoreElements()) {
        String name = names.nextElement();
        params.append(name);
        params.append("=");
        params.append(req.getParameter(name));
        params.append("&");
      }
    }

    if (params.length() > 0) {
      params.delete(params.length() - 1, params.length());
    }
    log.info("Request: > "
        + req.getMethod()
        + " "
        + req.getRequestURI()
        + params
        + " "
        + req.getProtocol());

    Enumeration<String> headers = req.getHeaderNames();

    while (headers.hasMoreElements()) {
      String name = headers.nextElement();
      String value = req.getHeader(name);
      log.info("Header: > " + name + ":" + value);
    }

    final RequestContext ctx = RequestContext.getCurrentContext();
    if (!ctx.isChunkedRequestBody()) {
      ServletInputStream inp;
      try {
        inp = ctx.getRequest().getInputStream();
        String body;
        if (inp != null) {
          body = IOUtils.toString(inp);
          log.info("Body: > " + body);
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return null;
  }
}
