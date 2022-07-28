package pagination;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @author minhvu
 *
 */
public class Pagination extends SimpleTagSupport {
	private int size;
	private String url;

	public void setSize(int size) {
		this.size = size;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext) getJspContext();
		int p = 1;
		if (pageContext.getRequest().getParameter("p") != null) {
			p = Integer.parseInt(pageContext.getRequest().getParameter("p"));
		}
		JspWriter jw = getJspContext().getOut();
		jw.write("<ul class=\"pagination\">)");
		for (int i = 1; i <= size; i++) {
			String href = String.format(url, i);
			if (p == i) {
				jw.write(String.format(
						"<li class=\"page-item active\"><a " + "class=\"page-link\" href=\"%s\">%d</a></li>", href, i));
			} else {
				jw.write(String.format("<li class=\"page-item\"><a " + "class=\"page-link\" href=\"%s\">%d</a></li>",
						href, i));
			}
		}
		jw.write("</ul>");
	}

}
