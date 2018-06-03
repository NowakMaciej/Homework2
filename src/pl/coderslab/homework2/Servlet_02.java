package pl.coderslab.homework2;

import java.io.IOException;
import java.lang.Math;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/Servlet_02")
public class Servlet_02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String binary = request.getParameter("value");
		String[] values = binary.split("");
		String msg="";
		int decimal=0;
		for (int i=0; i<values.length; i++) {
			if (values[i].equals("0") || values[i].equals("1")) {
				decimal += Integer.parseInt(values[i]) * (int)Math.pow(2, (values.length-1-i));
				msg = "Wartosc dziesietna: " + decimal;
			} else {
				msg = "Nieprawidlowy input";
				break;
			}
		}
		response.getWriter().append("<h2>").append("Wartosc binarna: " + binary + "\n").append("</h2>");
		response.getWriter().append("<h2>").append(msg).append("</h2>");
		}
}
