package ca.sheridancollege.controllers;

//Adhrika Pai - 991451940

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
 * Servlet implementation class AddController
 */
@WebServlet("/AddController")
public class AddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddController() {
        super();
        dao.populate();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("confirmation.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Restaurant rest = new Restaurant();
		try {
			String addRest = request.getParameter("AddRest");
			if(!(addRest==null)) {
				String restName = request.getParameter("restName");
				rest.setRestName(restName);
				
				List<Restaurant> restSearchName = dao.getByName(restName);
				request.setAttribute("restSearchName", restSearchName);
				if(restSearchName==null){
					String restType = request.getParameter("restType");
					rest.setRestType(restType);
					String restPrice = request.getParameter("restPrice");
					rest.setRestPrice(restPrice);
					String restRate = request.getParameter("restRate");
					rest.setRestRate(restRate);
					String restNote = request.getParameter("restNote");
					rest.setRestNote(restNote);
					
					dao.saveInventory(rest);
				}
			}
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
		List<Restaurant> restList = dao.getAllRest();
		request.setAttribute("restSearchList", restList);
		
		request.getRequestDispatcher("confirmation.jsp").forward(request, response);

	}

}
