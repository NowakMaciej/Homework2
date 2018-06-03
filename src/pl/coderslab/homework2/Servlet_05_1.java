package pl.coderslab.homework2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/Servlet_05_1")
public class Servlet_05_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("<form action=\"\" method=\"post\">")
		  .append("<label>Nazwa:<input type=\"text\" name=\"name\"></label>")
		  .append("<label>Ilosc:<input type=\"number\" name=\"quantity\"></label>")
		  .append("<label>Cena:<input type=\"text\" name=\"price\"></label>")
		  .append("<input type=\"submit\" name=\"Wyslij\">")
		  .append("</form>");
		String address = "<div><a href=\"/Homework2/Servlet_05_2\">Przejdz do podsumowania</a></div>";
		response.getWriter().append(sb).append(address);
	}
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Servlet_05_Product> productList = new ArrayList<>();
		String productName = request.getParameter("name");
		double productPrice = Double.parseDouble(request.getParameter("price"));
		int productQuantity = Integer.parseInt(request.getParameter("quantity"));
		if(session.getAttribute("basket") == null) {
			productList.add(new Servlet_05_Product(productName, productPrice, productQuantity));
			session.setAttribute("basket", productList);
		} else {
			productList = (List<Servlet_05_Product>)session.getAttribute("basket");
			productList.add(new Servlet_05_Product(productName, productPrice, productQuantity));
			session.setAttribute("basket", productList);
		}
		StringBuilder msg = new StringBuilder();
		msg.append("<form action=\"\" method=\"post\">")
		   .append("<label>Nazwa:<input type=\"text\" name=\"name\"></label>")
		   .append("<label>Ilosc:<input type=\"number\" name=\"quantity\"></label>")
		   .append("<label>Cena:<input type=\"text\" name=\"price\"></label>")
		   .append("<input type=\"submit\" name=\"Wyslij\">")
		   .append("</form>")
		   .append("Dodano nowy produkt").append("\n");
		String address = "<div><a href=\"/Homework2/Servlet_05_2\">Przejdz do podsumowania</a></div>";
		response.getWriter().append(msg).append(address);
	}
}
