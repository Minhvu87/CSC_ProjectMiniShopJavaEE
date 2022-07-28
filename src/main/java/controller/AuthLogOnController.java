package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberRepository;
import domain.Member;




/**
 * Servlet implementation class AuthLogOncontroller
 */
@WebServlet("/auth/logon.html")
public class AuthLogOnController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    MemberRepository repository = new MemberRepository();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthLogOnController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/views/logon/logon.jsp").forward(request,response);
	}
	private static void savedCookie(HttpServletRequest request, HttpServletResponse response) {
		for(Cookie cookie : request.getCookies()) {
			if(cookie.getName().equals("JSESSIONID")) {
				cookie.setMaxAge(30 * 24 * 3600);
				cookie.setPath(request.getContextPath());
				response.addCookie(cookie);
			}
		}
	}
	private static void savedSession(Member obj, HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.setAttribute("member", obj);
		if(request.getParameter("remember")!=null) {
			savedCookie(request,response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			 Member ret = repository.logOn(request.getParameter("usr"), request.getParameter("pwd"));
			 if(ret != null) {
				 savedSession(ret, request, response);
				 response.sendRedirect(request.getContextPath() + "/home.html");
				 
			 }else {
				 request.setAttribute("msg", "Log On Failed");
				 doGet(request, response);
			 }
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
