package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.UsuarioDao;
import modelo.UsuarioVO;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String firstName= request.getParameter("FirstName");
		String lastName= request.getParameter("LastName");
		String pass=request.getParameter("pass");
		String username= request.getParameter("email");
		//Modificar metodo variables y parametros del metodo confirm
		
		UsuarioVO u =new UsuarioVO();
		
		u.setFirstName(firstName);
		u.setLastName(lastName);
		u.setUsername(username);
		u.setPassword(pass);
		
		
		int status;
		try {
			status = UsuarioDao.save(u);
		
		if(status>0) {
		out.print("<p> Record saved succeful!!</p>");
		out.print("You user name is: " +u.getUsername());
			request.getRequestDispatcher("index.jsp").include(request, response);
		 }
		
		}catch(SQLException e) {
			System.out.println(e);
			out.print("Sorry! ubable to save record");
		}
		
		
	}

}
