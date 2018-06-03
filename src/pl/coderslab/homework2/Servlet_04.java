package pl.coderslab.homework2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/Servlet_04")
public class Servlet_04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg;
		Cookie[] cookies = request.getCookies();
		if (cookies == null) {
			Cookie cookie = new Cookie("visit", "1");
			cookie.setMaxAge(365*24*60*60);
			response.addCookie(cookie);
			msg = "Witamy na naszej stronie po raz pierwszy";
		} else {
			int counter = 0;
			for (Cookie c : cookies) {
				if (c.getName().equals("visit")) {
					counter = Integer.parseInt(c.getValue()) + 1;
					c.setMaxAge(365*24*60*60);
					c.setValue(String.valueOf(counter));
					response.addCookie(c);
				}
			}
			msg = "Witamy na naszej stronie! Odwiedziles nas " + counter + " razy";
		}
		response.getWriter().append(msg);
	}
}
