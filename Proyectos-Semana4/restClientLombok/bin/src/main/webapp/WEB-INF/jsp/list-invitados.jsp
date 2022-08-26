<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Invitados</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Invitado Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Invitado -->
		
			<input type="button" value="Add Invitado"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our invitados -->
				<c:forEach var="tempInvitado" items="${invitados}">
				
					<!-- construct an "update" link with invitado id -->
					<c:url var="updateLink" value="/invitado/showFormForUpdate">
						<c:param name="invitadoId" value="${tempInvitado.id}" />
					</c:url>					

					<!-- construct an "delete" link with invitado id -->
					<c:url var="deleteLink" value="/invitado/delete">
						<c:param name="invitadoId" value="${tempInvitado.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempInvitado.nombre} </td>
						<td> ${tempInvitado.apellido} </td>
						<td> ${tempInvitado.email} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this invitado?'))) return false">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









