package org.nagarro.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nagarro.hibernate.entity.Users;
import org.nagarro.hibernate.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "Login Servlet", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username, password;
		username = request.getParameter("username");
		password = request.getParameter("password");
		
		LoginService loginService = new LoginService();
		Users user = loginService.authenticate(username, password);
		if(user!=null) {
			HttpSession session = request.getSession(true);			
			session.setAttribute("LoggedInUser",user.getId());
			response.sendRedirect("ImageUtility.jsp");
		
		}else {
			response.sendRedirect("login.jsp");
			return;
		}
	
	}

}
