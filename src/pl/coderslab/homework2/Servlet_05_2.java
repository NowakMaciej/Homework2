package pl.coderslab.homework2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/Servlet_05_2")
public class Servlet_05_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		StringBuilder sb = new StringBuilder();
		double sum = 0;
		if(session.isNew()) {
			sb.append("nie ma danych w sesji");
		} else {
			List<Servlet_05_Product> products = (List<Servlet_05_Product>)session.getAttribute("basket");
			for (int i=0; i<products.size(); i++) {
				sum += products.get(i).getQuantity() * products.get(i).getPrice();
				sb.append(products.get(i).toString());
			}
		}
		response.getWriter().append("Kupiono nastepujace produkty:").append("\n").append(sb).append("Suma: " + sum);
	}
}
