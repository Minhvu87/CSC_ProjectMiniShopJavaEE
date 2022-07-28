package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Member;
import dao.MemberRepository;

/**
 * Servlet implementation class AuthRegisterController
 */
@WebServlet("/auth/register.html")
public class AuthRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    MemberRepository repository = new MemberRepository();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthRegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/views/register/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			if(repository.add(new Member(0,
					request.getParameter("usr"),
					request.getParameter("pwd"),
					request.getParameter("email"),
					request.getParameter("fullName"),
					Byte.parseByte(request.getParameter("gender") ))) > 0) {
				response.sendRedirect(request.getContextPath() + "/auth/logon.html");
			}else {
				request.setAttribute("msg", "Register Failed");
				doGet(request, response);
			}
		}catch(NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
	}

}
