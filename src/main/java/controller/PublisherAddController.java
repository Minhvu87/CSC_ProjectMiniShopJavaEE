package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Publisher;
import dao.PublisherRepository;

/**
 * Servlet implementation class PublisherAddController
 */
@WebServlet("/publisher/add.html")
public class PublisherAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PublisherRepository repository = new PublisherRepository();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PublisherAddController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/views/publisher/publisher_add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (!request.getParameter("name").equals("")) {
			try {
				if (repository.add(new Publisher(0, request.getParameter("name"))) > 0) {
					response.sendRedirect(request.getContextPath() + "/admin/publisher.html");
				} else {
					request.setAttribute("msg", "Inserted Failed");
					doGet(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
