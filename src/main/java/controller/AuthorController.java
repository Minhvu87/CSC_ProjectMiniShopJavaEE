package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Author;
import dao.AuthorRepository;

/**
 * Servlet implementation class AuthorController
 */
@WebServlet("/admin/author/list.html")
public class AuthorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    AuthorRepository repository = new AuthorRepository();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Author> list = repository.findAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/views/author/author_index.jsp").forward(request, response);
	}

}
