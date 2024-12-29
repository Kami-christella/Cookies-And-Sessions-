package controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/createAccount")
public class CreateAccount extends HttpServlet {

	public void doPost(HttpServletRequest req,
			HttpServletResponse res) throws IOException {
		String email = req.getParameter("email");
	    String userRole = req.getParameter("user");
	    String password = req.getParameter("psw");
	    
	    if(email != null && userRole != null &&
	    		password != null) {
	    	Cookie emailCookie = new Cookie("userEmail", email);
	    	emailCookie.setMaxAge(60*60*24);
	    	res.addCookie(emailCookie);
	    	
	    	Cookie roleCookie = new Cookie("userRole", userRole);
	    	roleCookie.setMaxAge(60*60*24);
	    	res.addCookie(roleCookie);
	    	
	    	Cookie passwordCookie = new Cookie("userPassword", userRole);
	    	passwordCookie.setMaxAge(60*60*24);
	    	res.addCookie(passwordCookie);
	    	res.sendRedirect("Login.html");
	    }
	}
}
