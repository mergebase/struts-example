<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
    request.setAttribute("pageTitle", "View Credit Reports");
%>
<div class="container">
<table class="table table-striped table-hover table-condensed">
    <tr>
        <th>Report ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Date of Report</th>
        <th>Address</th>
        <th>Birth Date</th>
        <th>Social Insurance Number</th>
        <th>Salary</th>
        <th>Credit Rating</th>
    </tr>
    <s:iterator value="availableItems">
        <tr>
            <td><s:property value="reportId"/></td>
            <td><s:property value="givenName"/></td>
            <td><s:property value="surname"/></td>
            <td><s:property value="dateOfReport"/></td>
            <td><s:property value="address"/></td>
            <td><s:property value="birthYear"/>/<s:property value="birthMonth"/>/<s:property value="birthDay"/></td>
            <td><s:property value="socialInsuranceNumber"/></td>
            <td><s:property value="salary"/></td>
            <td><s:property value="creditRating"/></td>
        </tr>
    </s:iterator>
</table>
</div>
