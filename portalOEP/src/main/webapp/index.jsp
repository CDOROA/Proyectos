<html>
<body>
    <%
          RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/PaginaPrincipal");
		  dispatcher.forward(request, response);
	%>
</body>
</html>
