package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Cart;
import domain.Product;
import dao.ProductRepository;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/cart.html")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductRepository repository = new ProductRepository();

	private static Map<Integer, Cart> getCarts(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("cart");
		Map<Integer, Cart> carts = null;
		if (obj != null) {
			carts = (Map<Integer, Cart>) obj;
		} else {
			carts = new HashMap();
			session.setAttribute("cart", carts);
		}
		return carts;

	}

	private void saveCarts(Map<Integer, Cart> carts, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.setAttribute("cart", carts);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartController() {
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
		request.setAttribute("list", getCarts(request, response).values());
		request.getRequestDispatcher("/views/cart/cart_index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Map<Integer, Cart> carts = getCarts(request,response);
			int id = Integer.parseInt(request.getParameter("id"));
		    short qty = Short.parseShort(request.getParameter("qty"));
		    if(carts.containsKey(id)) {
			   carts.get(id).increaseQuantity(qty);
		    }else {
			    Product obj = repository.getProduct(id);
			    Cart cart = new Cart(
					   obj.getId(),
					   obj.getPrice(),
					   qty,
					   obj.getImageUrl(),
					   obj.getTitle());
			    carts.put(id,cart);
		}
		saveCarts(carts, request, response);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		doGet(request,response);
	}

}
