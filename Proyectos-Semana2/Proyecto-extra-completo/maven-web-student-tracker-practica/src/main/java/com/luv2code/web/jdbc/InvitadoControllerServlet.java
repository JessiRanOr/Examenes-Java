package com.luv2code.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/InvitadoControllerServlet")
public class InvitadoControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private InvitadoDbUtil invitadoDbUtil;
	
	@Resource(name="jdbc/web_student_tracker")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		// create our student db util ... and pass in the conn pool / datasource
		try {
			invitadoDbUtil = new InvitadoDbUtil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			
			// if the command is missing, then default to listing students
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listInvitados(request, response);
				break;
				
			case "ADD":
				addInvitado(request, response);
				break;
				
			case "LOAD":
				loadInvitado(request, response);
				break;
				
			case "UPDATE":
				updateInvitado(request, response);
				break;
			
			case "DELETE":
				deleteInvitado(request, response);
				break;
				
			default:
				listInvitados(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	private void deleteInvitado(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read student id from form data
		String theInvitadoId = request.getParameter("invitadoId");
		
		// delete student from database
		invitadoDbUtil.deleteInvitado(theInvitadoId);
		
		// send them back to "list students" page
		listInvitados(request, response);
	}

	private void updateInvitado(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read student info from form data
		int id = Integer.parseInt(request.getParameter("invitadoId"));
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		
		// create a new student object
		Invitado theInvitado = new Invitado(id, nombre, apellido, email);
		
		// perform update on database
		invitadoDbUtil.updateInvitado(theInvitado);
		
		// send them back to the "list students" page
		listInvitados(request, response);
		
	}

	private void loadInvitado(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// read student id from form data
		String theInvitadoId = request.getParameter("invitadoId");
		
		// get student from database (db util)
		Invitado theInvitado = invitadoDbUtil.getInvitado(theInvitadoId);
		
		// place student in the request attribute
		request.setAttribute("THE_INVITADO", theInvitado);
		
		// send to jsp page: update-student-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-invitado-form.jsp");
		dispatcher.forward(request, response);		
	}

	private void addInvitado(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read student info from form data
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");		
		
		// create a new student object
		Invitado theInvitado = new Invitado(nombre, apellido, email);
		
		// add the student to the database
		invitadoDbUtil.addInvitado(theInvitado);
				
		// send back to main page (the student list)
		listInvitados(request, response);
	}

	private void listInvitados(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// get students from db util
		List<Invitado> invitados = invitadoDbUtil.getInvitados();
		
		// add students to the request
		request.setAttribute("INVITADO_LIST", invitados);
				
		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-invitados.jsp");
		dispatcher.forward(request, response);
	}

}













