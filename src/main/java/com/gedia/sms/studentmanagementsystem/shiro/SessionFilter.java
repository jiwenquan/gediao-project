package com.gedia.sms.studentmanagementsystem.shiro;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.servlet.OncePerRequestFilter;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * sesson过滤器
 *
 * @author jiwenquan
 * @create 2018/7/2 10:20
 */
public class SessionFilter extends OncePerRequestFilter {
    /**
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws ServletException, IOException {
        Subject subject = SecurityUtils.getSubject();
        String url = ((ShiroHttpServletRequest)servletRequest).getRequestURI();
        if (!StringUtils.contains(url, "login") && (null == subject || null == subject.getPrincipal())) {
            WebUtils.toHttp(servletResponse).sendError(402);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}