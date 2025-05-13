package com.crisisconnect.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter(asyncSupported = true, urlPatterns = "/*")

public class AuthenticationFilter implements Filter {

	private static final String LANDINGPAGE = "/landingpage";
	private static final String LOGIN = "/login";
	private static final String REGISTER = "/register";
	private static final String HOME = "/home";
	private static final String ROOT = "/";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// Initialization logic, if required
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// Cast the request and response to HttpServletRequest and HttpServletResponse
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		// Get the requested URI
		String uri = req.getRequestURI();

//		if (uri.endsWith(".png") || uri.endsWith(".jpg") || uri.endsWith(".css") 
//				|| uri.endsWith(HOME) || uri.endsWith(ROOT)|| 
//				uri.endsWith("dashboard")|| uri.endsWith("update")) {
//			chain.doFilter(request, response);
//			return;
//		}
//		
		HttpSession session = ((HttpServletRequest) request).getSession(false);
		// Get the session and check if user is logged in
		boolean isLoggedIn = (session != null && session.getAttribute("username") != null);
		
		// if user is not logged in and attempts to go to login/register/root/landing pages allow
		// disallow every other pages for if not logged in
		if (!isLoggedIn) {
			if (uri.endsWith(LOGIN) || uri.endsWith(REGISTER) || uri.endsWith(ROOT) || uri.endsWith(LANDINGPAGE)) {
				chain.doFilter(request, response);
			} else {
				res.sendRedirect(req.getContextPath() + LOGIN);
			}
			return;
		} else {
			// if user is logged in and attempts to go to login/register/root/landing pages redirect to home
			if (uri.endsWith(LOGIN) || uri.endsWith(REGISTER) || uri.endsWith(ROOT) ||  uri.endsWith(LANDINGPAGE)) {
				res.sendRedirect(req.getContextPath() + HOME);
				return;
			}
		}	
		
		// assumes all request are from logged in user as they are previously handled
		
		//restrict admin and user to role based page
		if(uri.contains("/admin")) {
			if(!session.getAttribute("usertype").equals("admin")) {
				res.sendRedirect(req.getContextPath() + HOME);
				return;
			}
		}
		
		if(uri.contains("/user")) {
			if(!session.getAttribute("usertype").equals("user")) {
				res.sendRedirect(req.getContextPath() + HOME);
				return;
			}
		}
		
		// All checks passed — continue request
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// Cleanup logic, if required
	}

}
