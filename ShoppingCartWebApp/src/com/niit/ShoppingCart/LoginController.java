package com.niit.ShoppingCart;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("doGet");
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		
		LoginDAO loginDAO = new LoginDAO();
		RequestDispatcher dispatcher; 
	if(loginDAO.isValiduser(userid,password) == true){
			dispatcher=request.getRequestDispatcher("Home.html");
			dispatcher.forward(request,response);
		}
		else{
			dispatcher = request.getRequestDispatcher("/Login.html");
			PrintWriter writer = response.getWriter();
			
			
			//dispatche.forward(request,response);
			//dispatche.include(request, response);
			writer.append("Please try again");
			dispatcher.include(request, response);
			
			
		}
		
		
	}

}
