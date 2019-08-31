<%@taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
    System.out.println("session expires outside for refresh");
	if(session.getAttribute("username")==null){
	    System.out.println("session expires inside for refresh");
		System.out.println("Invalid session");
		response.sendRedirect(request.getContextPath()+"/login_signin.jsp");
	}
%>


