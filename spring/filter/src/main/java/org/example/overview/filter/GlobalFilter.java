package org.example.overview.filter;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Log4j2
public class GlobalFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String param = filterConfig.getInitParameter("param");
        log.info("Global Filter init... with "  + param);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        log.info("Global Filter doFilter...");

        HttpServletRequest req = (HttpServletRequest) request;
        log.info("Request URL: " + req.getRequestURI());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("Global Filter destroy...");
    }

}
