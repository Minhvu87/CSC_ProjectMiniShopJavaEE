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
 * Servlet implementation class AuthorEditController
 */
@WebServlet("/admin/author/edit.html")
public class AuthorEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    AuthorRepository repository = new AuthorRepository();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthorEditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("o", repository.findById(id));
		request.getRequestDispatcher("/views/author/author_edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		Author obj = new Author(id, request.getParameter("name"));
		repository.update(obj);
		response.sendRedirect(request.getContextPath()+"/admin/author/list.html");
	}

}
