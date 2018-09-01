package com.orlando.servlet;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.orlando.dao.PersonDAO;
import com.orlando.daoimpl.PersonDAOImpl;
import com.orlando.model.City;
import com.orlando.model.Person;
import com.orlando.util.Dropdowns;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Entrando a doget");
		String btn = request.getParameter("btn");
		System.out.println("btn si era btn");
		int personId = Integer.parseInt(request.getParameter("personId"));
		System.out.println(personId);
		if (btn.equals("delete")) {
			System.out.println("Entro a delete");
			delete(personId);
		} else if (btn.equals("btn")) {
			System.out.println("Entro a btn");
			response.setContentType("application/json");
			Person person = new PersonDAOImpl().findById(personId);
			String personJson = new Gson().toJson(person);
			PrintWriter out = response.getWriter();
			out.println(personJson);
		} else {
			System.out.println("entro al final");
			update(personId, request, response);
		}
	}

	public void delete(int personId) {
		PersonDAO personDao = new PersonDAOImpl();
		Person person = personDao.findById(personId);
		personDao.deletePerson(person);
	}

	public void update(int personId, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PersonDAO personDao = new PersonDAOImpl();
		Person person = personDao.findById(personId);

		person.setName(request.getParameter("name"));
		person.setLastName(request.getParameter("lastName"));
		person.setEmail(request.getParameter("email"));
		person.setAge(Integer.parseInt(request.getParameter("age")));
		person.setState(request.getParameter("state"));
		person.setCity(request.getParameter("city"));
		person.setAddress(request.getParameter("Address"));
		person.setPassword(request.getParameter("password"));

		System.out.println(person);
		personDao.insert(person);

		response.sendRedirect("/WebProject/index.jsp");

		personDao.updatePerson(person);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
