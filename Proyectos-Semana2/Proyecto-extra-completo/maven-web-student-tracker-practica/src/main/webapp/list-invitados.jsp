<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Invitado Tracker App</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>FooBar University</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Student -->
			
			<input type="button" value="Add Invitado" 
				   onclick="window.location.href='add-invitado-form.jsp'; return false;"
				   class="add-invitado-button"
			/>
			
			<table>
			
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempInvitado" items="${INVITADO_LIST}">
					
					<!-- set up a link for each student -->
					<c:url var="tempLink" value="InvitadoControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="invitadoId" value="${tempInvitado.id}" />
					</c:url>

					<!--  set up a link to delete a student -->
					<c:url var="deleteLink" value="InvitadoControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="invitadoId" value="${tempInvitado.id}" />
					</c:url>
																		
					<tr>
						<td> ${tempInvitado.nombre} </td>
						<td> ${tempInvitado.apellido} </td>
						<td> ${tempInvitado.email} </td>
						<td> 
							<a href="${tempLink}">Update</a> 
							 | 
							<a href="${deleteLink}"
							onclick="if (!(confirm('¿Estas segura de eliminar a este invitado?'))) return false">
							Delete</a>	
						</td>
					</tr>
				
				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>








