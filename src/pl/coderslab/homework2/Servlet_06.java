package pl.coderslab.homework2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/Servlet_06")
public class Servlet_06 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();
		try {
			double num1 = Double.parseDouble(request.getParameter("num1"));
			double num2 = Double.parseDouble(request.getParameter("num2"));
			double num3 = Double.parseDouble(request.getParameter("num3"));
			double num4 = Double.parseDouble(request.getParameter("num4"));
			
			double sum = num1 + num2 + num3 + num4;
			double average = sum/4;
			double product = num1 * num2 * num3 * num4;
			
			sb.append("Liczby:").append("\n" + " - ")
			  .append(num1).append("\n" + " - ")
			  .append(num2).append("\n" + " - ")
			  .append(num3).append("\n" + " - ")
			  .append(num4).append("\n")
			  .append("Suma").append("\n" + " - ")
			  .append(sum).append("\n")
			  .append("Srednia").append("\n" + " - ")
			  .append(average).append("\n")
			  .append("Iloczyn").append("\n" + " - ")
			  .append(product).append("\n");
			  
		} catch (NumberFormatException ex) {
			sb.append("NumberFormatException");
		}
		response.getWriter().append(sb);
	}
}
