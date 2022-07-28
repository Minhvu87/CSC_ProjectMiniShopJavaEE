package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Author;
import dao.AuthorRepository;

/**
 * Servlet implementation class AuthorAddController
 */
@WebServlet("/admin/author/add.html")
public class AuthorAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    AuthorRepository repository = new AuthorRepository();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthorAddController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/views/author/author_add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Author obj = new Author(null, request.getParameter("name"));
		repository.insert(obj);
		response.sendRedirect(request.getContextPath() + "/admin/author/list.html");
	}

}
