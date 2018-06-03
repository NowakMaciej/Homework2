package pl.coderslab.homework2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/Servlet_03")
public class Servlet_03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		StringBuilder sb = new StringBuilder();
		if (session.isNew()) {
			sb.append("<form action=\"/Homework2/Servlet_03\" method=\"post\">");
			for (int i=1; i<6; i++) {
				sb.append("<label>Input "+i+"</label><input type=\"text\" name=\"value"+i+"\"><br>");						
			}
			sb.append("<input type=\"submit\" value=\"Wyslij\"></form>");
		} else {
			sb.append("<form action=\"/Homework2/Servlet_03\" method=\"post\">");
			for (int i=1; i<6; i++) {
				sb.append("<label>Input "+i+"</label><input type=\"text\" name=\"value"+i+"\" value=\""+(String)session.getAttribute("key"+i)+"\"><br>");						
			}
			sb.append("<input type=\"submit\" value=\"Wyslij\"></form>");
		}
		response.getWriter().append(sb);
	}
	
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		for (int i=1; i<6; i++) {
			session.setAttribute("key"+i, request.getParameter("value"+i));
		}
	}
}
