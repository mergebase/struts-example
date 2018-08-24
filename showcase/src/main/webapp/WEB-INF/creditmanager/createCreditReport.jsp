reatereate<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: delan
  Date: 20/08/18
  Time: 11:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
       <s:form  name="addCreditReport" action="add">
           <s:textfield label="report ID" name="creditReport.reportId"/>
           <s:textfield label="Given Name(s)" name="creditReport.givenName"/>
           <s:textfield label="Surname" name="creditReport.surname"/>
           <s:textfield label="Address" name="creditReport.address"/>
           <s:textfield label="Birth Year" name="creditReport.birthYear"/>
           <s:textfield label="Birth Month" name="creditReport.birthMonth"/>
           <s:textfield label="Birth Day" name="creditReport.birthDay"/>
           <s:textfield label="Salary" name="creditReport.salary"/>
           <s:textfield label="Social Insurance Number" name="creditReport.socialInsuranceNumber"/>
       </s:form>

    </div>
    <s:iterator value="creditAndLoans">

    </s:iterator>


</div>
</body>
</html>
