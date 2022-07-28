package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AuthorRepository;

/**
 * Servlet implementation class AuthorSearchController
 */
@WebServlet("/admin/author/search.html")
public class AuthorSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    AuthorRepository repository = new AuthorRepository(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthorSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("list", repository.search(request.getParameter("q")));
		request.getRequestDispatcher("/views/author/author_search.jsp").forward(request, response);
		
	}

}
