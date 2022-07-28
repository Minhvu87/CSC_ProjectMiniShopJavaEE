package upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class Bai5_UploadMultipleServlet
 */
@WebServlet("/upload/multi.html")
@MultipartConfig
public class UploadMultipleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadMultipleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/upload_image/multi.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletContext().getRealPath("/upload/");
		List<String> list = new LinkedList<String>();

		for (Part part : request.getParts()) {

			// Thuc hien upload vao thu muc /upload va tra ve ten file
			String fileName = upload(path, part);
			list.add(fileName);
		}

		// Dung request de gui du lieu ra cho trang JSP
		request.setAttribute("list", list);
		doGet(request, response);
	}

	private static String upload(String path, Part part) throws IOException {
		String fileName = part.getSubmittedFileName();
		try (InputStream is = part.getInputStream()) {
			try (OutputStream os = new FileOutputStream(new File(path + fileName))) {
				int len = 0;
				byte[] bytes = new byte[1024];
				while ((len = is.read(bytes, 0, 1024)) > 0) {
					os.write(bytes, 0, len);
				}
			}
		}
		return fileName;
	}

}
