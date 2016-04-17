package com.tomasz.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tomasz.Index;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author Tomek on 17.04.2016.
 */
@WebFilter("/views/*")
public class LoginFilter  implements Filter{

    @Autowired
    private Index index;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);

        String loginURL = request.getContextPath() + "/views/home.xhtml";

        boolean loggedIn = session == null || index.isLoginSuccess();
        boolean loginRequest = !loginURL.equals(request.getRequestURI());

        if (!loggedIn || loginRequest) {
            response.sendRedirect(request.getContextPath() + "/views/home.xhtml"); // No logged-in user found, so redirect to login page.
        } else {
            filterChain.doFilter(servletRequest, servletResponse); // Logged-in user found, so just continue request.
        }
    }

    @Override
    public void destroy() {

    }
}
