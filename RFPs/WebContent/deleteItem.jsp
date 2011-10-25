<%@page import="com.rfp.wrapper.RFPWrapper"%>
<%
	long idItem = Long.parseLong(request.getParameter("itemId"));
	String rfpId = request.getParameter("rfpId");
	String rfpSectionId = request.getParameter("rfpSectionId");

	RFPWrapper wrapper = new RFPWrapper();
	wrapper.deleteItem(idItem);

	response.sendRedirect("addItem.jsp?rfpId=" + rfpId + "&rfpSectionId=" + rfpSectionId + "");
%>