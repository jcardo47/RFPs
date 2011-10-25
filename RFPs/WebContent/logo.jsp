<%@page import="com.rfp.to.UserTO"%>
<center>
<!--  <div style="background-image: url('images/logo.png'); width: 468px; height: 60px;"/> -->
<img src="images/logo.png">
</center>
<%
	if (session.getAttribute("username") != null)
	{
		%>
			<div align="right"><a href="logout.jsp" >logout</a>
			<br>			
			<%
				UserTO user = (UserTO)session.getAttribute("username");
				String p = "";
				if (user.isAdmin())
				{
				  	p = "adminHome.jsp";
				}
				else
				{
					p = "UserHome.jsp";
				}							 	
			 %>
			<a href="<%= p %>">Página Principal</a>
			</div>
		<%			
	}	
 %>
