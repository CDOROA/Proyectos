<html>
<body>
	<%
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/EmpleadosServlet?vista=index");
		dispatcher.forward(request, response);
	%>
</body>
</html>