<html>
<body>
    <%
          RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/PaginaPrincipal?vista=index");
		  dispatcher.forward(request, response);
	%>
</body>
</html>
