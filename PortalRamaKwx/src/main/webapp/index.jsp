<html>
<body>
    <%
          RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/ServletInicio");
		  dispatcher.forward(request, response);
	%>
</body>
</html>
