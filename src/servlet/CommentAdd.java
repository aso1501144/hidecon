package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDAO;

/**
 * Servlet implementation class CommentAdd
 */
@WebServlet("/CommentAdd")
public class CommentAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String works_id = request.getParameter("works_id");
		String user_id = request.getParameter("user_id");

		request.setAttribute("works_id", works_id);
		request.setAttribute("user_id", user_id);

		CommentDAO commentDAO = new CommentDAO();
		request.setAttribute("comment", commentDAO.getcomments(works_id));

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/G105comment.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String user_id = request.getParameter("user_id");
		String works_id = request.getParameter("works_id");
		String comment = request.getParameter("comment");

		CommentDAO commentDAO = new CommentDAO();
		commentDAO.insertcomment(user_id, works_id, comment);

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/G103touhyou.jsp");
		rd.forward(request, response);
	}

}
