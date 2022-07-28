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
 * Servlet implementation class HomeDetailController
 */
@WebServlet("/home/detail.html")
public class HomeDetailController extends GenericServlet {
	private static final long serialVersionUID = 1L;
    ProductRepository repository = new ProductRepository();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("o", repository.getProduct(id));
			request.getRequestDispatcher("/views/home/home_detail.jsp").forward(request, response);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
