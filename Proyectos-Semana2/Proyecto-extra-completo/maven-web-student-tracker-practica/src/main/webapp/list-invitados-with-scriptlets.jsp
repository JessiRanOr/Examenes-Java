<%@ page import="java.util.*, com.luv2code.web.jdbc.*" %>
<!DOCTYPE html>
<html>

<head>
	<title>Invitado Tracker App</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<%
// get the students from the request object (sent by servlet)
	List<Invitado> theInvitados = 
			(List<Invitado>) request.getAttribute("INVITADO_LIST");
%>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>FooBar University</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<table>
			
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Email</th>
				</tr>
				
				<%
								for (Invitado tempInvitado : theInvitados) {
								%>
				
					<tr>
						<td> <%= tempInvitado.getNombre() %> </td>
						<td> <%= tempInvitado.getApellido() %> </td>
						<td> <%= tempInvitado.getEmail() %> </td>
					</tr>
				
				<% } %>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>








