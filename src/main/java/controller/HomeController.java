package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductRepository;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/home.html")
public class HomeController extends GenericServlet {
	private static final long serialVersionUID = 1L;
	private int size = 8;
	ProductRepository repository = new ProductRepository();

	private int getPage(int total) {
		return (int) Math.ceil(total / (float) size);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int p = 1;
		if (req.getParameter("p") != null) {
			p = Integer.parseInt(req.getParameter("p"));
		}
		try {
			req.setAttribute("n", getPage(repository.count()));
			req.setAttribute("list", repository.getProducts(p, size));
			req.getRequestDispatcher("/views/home/home_index.jsp").forward(req, res);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
