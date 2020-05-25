package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Author;
import service.AuthorService;

/**
 * Servlet implementation class AuthorServlet
 */
@WebServlet(name="AuthorServlet", urlPatterns = {"/AuthorServlet"})
public class AuthorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	processRequest(request, response);
	}
	
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		try(PrintWriter pw = response.getWriter()){
			pw.println("<!DOCTYPE html>");
			pw.println("<html>");
			pw.println("<head>");
			pw.println("<meta charset=\"UTF-8\">");
			pw.println("<title>Servlet Author</title>");
			pw.println("</head>");
			pw.println("<body>");
			pw.println("<h1>hello Author Servlet </h1>");
			
			pw.println("<table>");
			pw.println("<tr>");
			pw.printf("<th>%s<th>","ID");
			pw.printf("<th>%s<th>","first name");
			pw.printf("<th>%s<th>","last name");
			pw.println("</tr>");
			
			AuthorService authorService = new AuthorService();
			List<Author> list = authorService.getAllAuthors();
			list.forEach(author-> {
				pw.printf("<tr><td>%d</td><td>%s</td><td>%s</td></tr>", author.getauthorID(),author.getfirstName(),author.getlastName());
			});
			
			
			
			
			
			
			
			
			pw.println("</body>");
			pw.println("</html>");
	
		}
		
	}

}
