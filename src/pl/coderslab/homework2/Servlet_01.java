package pl.coderslab.homework2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/Servlet_01", initParams=
									   {@WebInitParam(name="eurUsd", value="1.1676"),
										@WebInitParam(name="eurPln", value="4.3015"),
										@WebInitParam(name="usdPln", value="3.6973")})
public class Servlet_01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = (request.getParameter("value"));
		String exchange = (request.getParameter("exchange"));
		double exchangeRate;
		double result;
		try {
			double valuetoConvert = Double.parseDouble(value);
			if (exchange.equals("eur-usd")) {
				exchangeRate = Double.parseDouble(getInitParameter("eurUsd"));
				result = valuetoConvert * exchangeRate;
			} else if (exchange.equals("usd-eur")) {
				exchangeRate = Double.parseDouble(getInitParameter("eurUsd"));
				result = valuetoConvert / exchangeRate;
			} else if (exchange.equals("eur-pln")) {
				exchangeRate = Double.parseDouble(getInitParameter("eurPln"));
				result = valuetoConvert * exchangeRate;
			} else if (exchange.equals("pln-eur")) {
				exchangeRate = Double.parseDouble(getInitParameter("eurPln"));
				result = valuetoConvert / exchangeRate;
			} else if (exchange.equals("usd-pln")) {
				exchangeRate = Double.parseDouble(getInitParameter("usdPln"));
				result = valuetoConvert * exchangeRate;
			} else {
				exchangeRate = Double.parseDouble(getInitParameter("usdPln"));
				result = valuetoConvert / exchangeRate;
			}
			PrintWriter pw = response.getWriter();
			pw.println("Po przeliczeniu: " + result);
		} catch (NumberFormatException ex) {
			response.getWriter().append("<h1>").append("Zly format danych").append("</h1>");
		}

	}
}
