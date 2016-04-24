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

import org.hibernate.annotations.Index;
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
        String newUserURL = request.getContextPath() + "/views/createNewUser.xhtml";

        boolean loggedIn = session != null && session.getAttribute("user") != null;
        boolean loginRequest = request.getRequestURI().equals(loginURL);
        boolean newUserRequest = request.getRequestURI().equals(newUserURL);

        if (loggedIn || loginRequest || newUserRequest) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            response.sendRedirect(loginURL);
        }

//        if( loggedIn || loginRequest) {
//            filterChain.doFilter(servletRequest,servletResponse);
//        } else {
//            response.sendRedirect(request.getContextPath() + "/views/home.xhtml");
//        }

//        if (!loggedIn || loginRequest) {
//            response.sendRedirect(request.getContextPath() + "/views/home.xhtml"); // No logged-in user found, so redirect to login page.
//        } else {
//            filterChain.doFilter(servletRequest, servletResponse); // Logged-in user found, so just continue request.
//        }
    }

    @Override
    public void destroy() {

    }
}
