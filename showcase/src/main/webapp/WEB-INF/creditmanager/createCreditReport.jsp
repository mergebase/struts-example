<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%

    if ("POST".equalsIgnoreCase(request.getMethod())) {
        response.sendRedirect("./add.action?success=true");
    }

    request.setAttribute("pageTitle", "Add Credit Report");
%>
<div class="container">
    <s:form name="addCreditReport" action="add" method="POST">
        <s:textfield tabindex="5" label="Given Name(s)" name="creditReport.givenName"/>
        <s:textfield tabindex="5" label="Surname" name="creditReport.surname"/>
        <s:textfield tabindex="5" label="Address" name="creditReport.address"/>
        <s:textfield tabindex="5" label="Birth Year" name="creditReport.birthYear"/>
        <s:textfield tabindex="5" label="Birth Month" name="creditReport.birthMonth"/>
        <s:textfield tabindex="5" label="Birth Day" name="creditReport.birthDay"/>
        <s:textfield tabindex="5" label="Salary" name="creditReport.salary"/>
        <s:textfield tabindex="5" label="Social Insurance Number" name="creditReport.socialInsuranceNumber"/>
        <s:textfield tabindex="5" label="Credit Rating" name="creditReport.creditRating"/>
        <s:submit tabindex="5" value="Submit" cssClass="btn btn-primary"/>
    </s:form>
</div>