package shopping;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/prime",initParams = @WebInitParam(name = "discount",value = "40"))
public class Prime extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String product = req.getParameter("product");
		int shoe = Integer.parseInt(getServletContext().getInitParameter("shoe"));
		int shirt = Integer.parseInt(getServletContext().getInitParameter("shirt"));
		
		double percentage=Double.parseDouble(getServletConfig().getInitParameter("discount"));
		
		if (product.equals("shoe")) {
			resp.getWriter().print("<h1>Price of Shoe is " + (shoe-(shoe*(percentage/100))) + "</h1>");
		} else if (product.equals("shirt")) {
			resp.getWriter().print("<h1>Price of Shirt is " + (shirt-(shirt*(percentage/100))) + "</h1>");
		} else {
			resp.getWriter().print("<h1>Enter Proper Product Name</h1>");
		}
	}
}
