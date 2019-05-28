<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    request.setAttribute("pageTitle", "Please Login");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Login</title>
</head>
<body>
<div class="container-fluid">
    <s:actionerror />
    <s:form namespace="/" action="index.action" method="post">
        <s:hidden name="user_login_attempt" value="%{'1'}" />
        <s:textfield name="username" label="Username" />
        <s:password name="password" label="Password" />
        <s:submit value="Login" align="center">
            <s:param name="colspan" value="%{2}" />
            <s:param name="align" value="%{'center'}" />
        </s:submit>
    </s:form>
</div>

</body>
</html>