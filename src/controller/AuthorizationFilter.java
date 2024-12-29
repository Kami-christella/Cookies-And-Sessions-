package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns="/login")
public class AuthorizationFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest re, ServletResponse rs, FilterChain chain)
			throws IOException, ServletException {
		
		List<String> studentList = new ArrayList<String>();
		studentList.add("Sandra");
		studentList.add("Kevin");
		studentList.add("Mucyo");
		
		HttpServletRequest req = (HttpServletRequest)re;
		HttpServletResponse res = (HttpServletResponse)rs;
		
		PrintWriter out = res.getWriter();
		
		String email = req.getParameter("uname");
		String password = req.getParameter("psw");
		
		Cookie[] cookies = req.getCookies();
		
		Boolean authenticated = Boolean.FALSE;
		if(email != null && password != null) {
			
			
			if(cookies != null) {
				for(Cookie oneCookie: cookies) {
					if(oneCookie.getValue().equalsIgnoreCase(email)) {
						authenticated = Boolean.TRUE;
					}
				}
				
				// to check if the user is authenticated
				if(authenticated) {
					HttpSession session = req.getSession(true);
					session.setAttribute("studentList", studentList);
					System.out.println("This is the day "+ session.getCreationTime());
					chain.doFilter(req, res);
				}else {
					res.setContentType("text/html");
					out.println("<h>Invalid User Name or Password </h>");
					req.getRequestDispatcher("Login.html").include(req, res);
				}
				
			}else {
				res.sendRedirect("register.html");
			}
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
}
