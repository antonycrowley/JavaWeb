package com.orlando.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.orlando.dao.PersonDAO;
import com.orlando.daoimpl.PersonDAOImpl;
import com.orlando.model.Person;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));
		String address = request.getParameter("address");
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirm-password");
		
		Person person = new Person();
		
		if(password.equals(confirmPassword)){
			person.setName(name);
			person.setLastName(lastName);
			person.setEmail(email);
			person.setAge(age);
			person.setState(state);
			person.setCity(city);
			person.setAddress(address);
			person.setPassword(password);
			
			System.out.println(person);
			PersonDAO personDao = new PersonDAOImpl();
			personDao.insert(person);
		}else{
			System.out.println("Passwords doesnt match");
		}
		
		
		
		response.sendRedirect("/WebProject/index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
