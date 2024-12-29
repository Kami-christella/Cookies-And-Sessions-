package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/login")
public class LoginServlet extends HttpServlet{

	public void doPost(HttpServletRequest req,
			HttpServletResponse res) throws IOException {
		List<String> studentList = new ArrayList<String>();
		
		HttpSession session = req.getSession(false);
		Date previousDate = new Date(session.getLastAccessedTime());
		Date currentDate = new Date();
		Long different = currentDate.getTime() - previousDate.getTime();
		Long second = (different/1000)%60;
		if(second > 5 ) {
			res.sendRedirect("Login.html");
		}else {
			studentList.addAll((Collection<? extends String>) session.getAttribute("studentList"));
			
			res.sendRedirect("HomePage.html");
		}
		
	}
	
	
	
	public void doGet(HttpServletRequest req,
			HttpServletResponse res) throws IOException {
		doPost(req,res);
	}
}
