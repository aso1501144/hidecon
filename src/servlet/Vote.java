package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.WorksDAO;

/**
 * Servlet implementation class Vote
 */
@WebServlet("/Vote")
public class Vote extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vote() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.setAttribute("path",request.getParameter("path"));
		String id = request.getParameter("id");
		request.setAttribute("id",id);


		WorksDAO worksDAO = new WorksDAO();

		request.setAttribute("work",worksDAO.getWork(id));
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/G103touhyou.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String works_id = request.getParameter("works_id");
		WorksDAO worksDAO = new WorksDAO();
		worksDAO.Vote(works_id);

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/think.jsp");
		rd.forward(request, response);
	}

}
