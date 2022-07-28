package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Publisher;
import dao.PublisherRepository;

/**
 * Servlet implementation class PublisherEditController
 */
@WebServlet("/publisher/edit.html")
public class PublisherEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PublisherRepository repository = new PublisherRepository();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PublisherEditController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("o", repository.getPublisher(id));
			request.getRequestDispatcher("/views/publisher/publisher_edit.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!request.getParameter("name").equals("")) {
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				if (repository.edit(new Publisher(id, request.getParameter("name"))) > 0) {
					response.sendRedirect(request.getContextPath() + "/admin/publisher.html");
				} else {
					request.setAttribute("msg", "Edit Failed");
					doGet(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("id") != null) {
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				repository.delete(id);
				response.sendRedirect(request.getContextPath() + "/publisher.html");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
