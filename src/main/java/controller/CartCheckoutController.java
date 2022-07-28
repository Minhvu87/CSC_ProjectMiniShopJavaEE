package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Member;
import domain.Cart;
import domain.Invoice;
import domain.InvoiceDetail;
import dao.InvoiceRepository;

/**
 * Servlet implementation class CartCheckoutController
 */
@WebServlet("/cart/checkout.html")
public class CartCheckoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static long random() {
    	Random rand = new Random();
    	return Math.abs(rand.nextLong());
    }
    InvoiceRepository repository = new InvoiceRepository();
    private static Map<Integer, Cart> getCarts(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("cart");
		Map<Integer, Cart> carts = null;
		if(obj != null) {
			carts = (Map<Integer, Cart>)obj;
		}else {
			carts = new HashMap();
			session.setAttribute("cart", carts);
		}
    	return carts;
    	
    }
    private static Member getMember(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("member");
		if(obj != null) {
			return (Member)obj;
		}else {
			return null;
		}
    	
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartCheckoutController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("list", getCarts(request, response).values());
		request.getRequestDispatcher("/views/cart/cart_checkout.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Invoice obj = new Invoice(random(),null,
					request.getParameter("tel"),request.getParameter("address"),
					request.getParameter("email"));
			Member member = getMember(request, response);
			if(member != null) {
				obj.setMemberId(member.getId());
			}
			List<InvoiceDetail> details = new LinkedList<>();
			for(Cart cart : getCarts(request, response).values()) {
				details.add(new InvoiceDetail(obj.getId(),
						cart.getProductId(),cart.getQuantity(),cart.getPrice()));
			}
			obj.setDetails(details);
			if(repository.add(obj) > 0) {
				response.sendRedirect(request.getContextPath() +
						"/order/detail.html?id=" + obj.getId());
			}else {
				request.setAttribute("msg", "Ordered Failed");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
