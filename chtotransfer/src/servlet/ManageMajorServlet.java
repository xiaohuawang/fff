package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Hcmojor;
import DB.HccourseDB;
import DB.HcmojorDB;

/**
 * Servlet implementation class ReturnServlet
 */
@WebServlet("/ManageMajorServlet")
public class ManageMajorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageMajorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String table = "";
		HttpSession session = request.getSession();
		//Shopuser user = (Shopuser) session.getAttribute("user");
		//List<Shoplineitem> lineItems = DBOrder.getAllLineItemsByUserID(user);
		List<Hcmojor> majors = HcmojorDB.getAllMajors();
		
		request.setAttribute("majors", majors); 
		getServletContext().getRequestDispatcher("/majors.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
