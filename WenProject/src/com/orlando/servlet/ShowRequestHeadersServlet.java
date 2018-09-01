package com.orlando.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowRequestHeadersServlet
 */
@WebServlet("/ShowRequestHeadersServlet")
public class ShowRequestHeadersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowRequestHeadersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!Doctype HTML>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Showing Request Headers</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>All Request Headers:</h1>");
		
		out.println("<p><b>Request Method : </b>" + request.getMethod() + "</p>");
		out.println("<p><b>Request URI : </b>" + request.getRequestURI() + "</p>");
		out.println("<p><b>Request URL : </b>" + request.getRequestURL() + "</p>");
		out.println("<p><b>Request Protocol : </b>" + request.getProtocol() + "</p>");
		
		Enumeration<String> headerNames = request.getHeaderNames();
		
		while(headerNames.hasMoreElements()){
			String headerName = headerNames.nextElement();
			out.println("<p><b>" + headerName + ": </b>" + request.getHeader(headerName) + "</b>");
		}
		out.println("</body>");
		out.println("<html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
