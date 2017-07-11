package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;

/**
 * Servlet implementation class login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		session.invalidate();

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/G101login.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path; // 分岐先のファイル名
		HttpSession session = request.getSession();
		// ユーザーID、パスワードの取り出し

		String s_id = request.getParameter("s_id");

		String pass = request.getParameter("pass");
		UserDAO userDAO = new UserDAO();
		//UserBean user = new UserBean();

		User login = new User();

		//String login = userDAO.getLogin(s_id, pass);
		login = userDAO.login(s_id, pass);

		if (login != null) {
			// 会員情報をセッションに格納
			//session.setAttribute("s_id", login);
			//session.setAttribute("s_name", userDAO.getSname(s_id));

			//EntryDAO entry = new EntryDAO();
			//ArrayList<EntryBean> entryList = new ArrayList<EntryBean>();
			//entryList = entry.getData(s_id);

			//session.setAttribute("entry", entryList);

			path = "WEB-INF/jsp/G102gazou.jsp";

		} else {
			System.out.println("ログイン失敗");
			request.setAttribute("errorMassage", "学生IDまたはパスワードが違います。");
			path = "WEB-INF/jsp/G101login.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

}
