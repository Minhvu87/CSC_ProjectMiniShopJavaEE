package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Cart;

/**
 * Servlet implementation class CartEditController
 */
@WebServlet("/cart/edit.html")
public class CartEditController extends HttpServlet {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try (PrintWriter pw = response.getWriter()) {
			int key = Integer.parseInt(request.getParameter("id"));
			short qty = Short.parseShort(request.getParameter("qty"));
			Map<Integer, Cart> carts = getCarts(request, response);
			if (carts.containsKey(key)) {
				carts.get(key).setQuantity(qty);
			}
			pw.write("1");
		}
	}
}
