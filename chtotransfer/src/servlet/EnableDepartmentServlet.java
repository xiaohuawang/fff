package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hccourse;
import model.Hcdept;
import DB.HccourseDB;
import DB.HcdeptDB;

/**
 * Servlet implementation class ReturnServlet
 */
@WebServlet("/EnableDepartmentServlet")
public class EnableDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnableDepartmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int cid = Integer.parseInt(request.getParameter("id"));
		Hcdept dept=HcdeptDB.getDeptByID(cid);
		//Hcdept dept = HccourseDB.getCourseByID(cid);
		dept.setEnable(1);
		HcdeptDB.update(dept);
		List<Hcdept> depts = HcdeptDB.getAllDepts();
		request.setAttribute("depts", depts); 
		getServletContext().getRequestDispatcher("/departments.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
