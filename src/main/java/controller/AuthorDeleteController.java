package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AuthorRepository;



/**
 * Servlet implementation class AuthorDeleteController
 */
@WebServlet("/admin/author/del.html")
public class AuthorDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    AuthorRepository repository = new AuthorRepository();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthorDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    int id = Integer.parseInt(req.getParameter("id"));
	    repository.delete(id);
	    resp.sendRedirect(req.getContextPath() + "/admin/author/list.html");
    }
    

}
