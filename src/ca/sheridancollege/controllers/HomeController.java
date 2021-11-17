package ca.sheridancollege.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.sheridancollege.beans.Restaurant;
import ca.sheridancollege.dao.DAO;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
    	dao.populate();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("form.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("allRest") != null) {
			List<Restaurant> restList = dao.getAllRest();
			request.setAttribute("restSearchList", restList);
		}	
		else if(request.getParameter("allRate") != null) {
			List<Restaurant> restList = dao.getAllRate();
			request.setAttribute("restSearchList", restList);
		
		}
		else if(request.getParameter("searchRest") != null) {

			String searchSel = request.getParameter("searchSelected");
			String value = request.getParameter("search");
			
			if(searchSel!=null) {
				
				if(searchSel.equals("restPrice")) {
					List<Restaurant> restList = dao.getRestPrice(value);
					request.setAttribute("restSearchList", restList);
				}
				else if(searchSel.equals("restNote")) {
					List<Restaurant> restList = dao.getRestNote(value);
					request.setAttribute("restSearchList", restList);
				}
				
			}

		}
	
		request.getRequestDispatcher("form.jsp").forward(request, response);


	}
}
