package controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/logout")
public class LogoutServlet extends HttpServlet{

	public void doGet(HttpServletRequest req,
			HttpServletResponse res) throws IOException {
		
		Cookie emailCookie = new Cookie("userEmail", "");
    	emailCookie.setMaxAge(0);
    	res.addCookie(emailCookie);
    	
    	Cookie roleCookie = new Cookie("userRole", "");
    	roleCookie.setMaxAge(0);
    	res.addCookie(roleCookie);
    	
    	Cookie passwordCookie = new Cookie("userPassword", "");
    	passwordCookie.setMaxAge(0);
    	res.addCookie(passwordCookie);
  
    	res.sendRedirect("Login.html");
	}
}
