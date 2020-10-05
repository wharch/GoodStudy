package com.goodstudy.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {
    private String character;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       this.character = filterConfig.getInitParameter("character");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(this.character);
        servletResponse.setCharacterEncoding(this.character);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
    }
}
