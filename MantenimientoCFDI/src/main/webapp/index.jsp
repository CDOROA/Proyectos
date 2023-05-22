<html>
<body>
	<%
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/UsuarioServlet?vista=index");
		dispatcher.forward(request, response);
	%>
</body>
</html>
