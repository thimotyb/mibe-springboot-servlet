package it.unipv.mibe.course;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myservlet")
public class MyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		System.out.println("Hello the servlet was called with SpringBoot.");
		String name = request.getParameter("name");
	    response.setContentType("text/plain");
	    response.getWriter().write("Hello " + name + "!");
		
	}	
}
