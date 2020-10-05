package com.goodstudy.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;
@WebFilter(filterName = "characterFilter",urlPatterns = "/*",initParams = {
        @WebInitParam(name = "character",value = "utf-8")
})
public class CharacterFilter implements Filter {
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
