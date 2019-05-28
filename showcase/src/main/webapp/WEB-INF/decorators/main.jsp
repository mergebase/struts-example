<%@ page import="org.apache.struts2.result.StrutsResultSupport" %>
<%@ page import="org.apache.struts2.showcase.interceptor.LoginInterceptor" %>
<!DOCTYPE html>
<%@ page
        language="java"
        contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<%
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);

    // Calculate the view sources url
    String sourceUrl = request.getContextPath() + "/viewSource.action";
    com.opensymphony.xwork2.ActionInvocation inv = com.opensymphony.xwork2.ActionContext.getContext().getActionInvocation();
    org.apache.struts2.dispatcher.mapper.ActionMapping mapping = org.apache.struts2.ServletActionContext.getActionMapping();
    if (inv != null) {
        try {
            com.opensymphony.xwork2.util.location.Location loc = inv.getProxy().getConfig().getLocation();
            sourceUrl += "?config=" + (loc != null ? loc.getURI() + ":" + loc.getLineNumber() : "");
        } catch (Exception e) {
            sourceUrl += "?config=";
        }
        sourceUrl += "&className=" + inv.getProxy().getConfig().getClassName();

        if (inv.getResult() != null && inv.getResult() instanceof StrutsResultSupport) {
            sourceUrl += "&page=" + mapping.getNamespace() + "/" + ((StrutsResultSupport) inv.getResult()).getLastFinalLocation();
        }
    } else {
        sourceUrl += "?page=" + request.getServletPath();
    }
%>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<s:url var="current" includeParams="none" escapeAmp="false"/>

<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Struts2 Showcase for Apache Struts Project">
    <meta name="author" content="The Apache Software Foundation">
    <title><%= request.getAttribute("pageTitle") %></title>

    <link href="<s:url value='/styles/bootstrap.css' encode='false' includeParams='none'/>" rel="stylesheet"
          type="text/css" media="all">
    <link href="<s:url value='/styles/main.css' encode='false' includeParams='none'/>" rel="stylesheet" type="text/css"
          media="all"/>

    <script src="<s:url value='/js/jquery-2.1.4.min.js' encode='false' includeParams='none'/>"></script>
    <script src="<s:url value='/js/bootstrap.min.js' encode='false' includeParams='none'/>"></script>
    <script type="text/javascript">
        $(function () {
            var alerts = $('ul.alert').wrap('<div />');
            alerts.prepend('<a class="close" data-dismiss="alert" href="#">&times;</a>');
            alerts.alert();
        });
    </script>

    <!-- Prettify -->
    <link href="<s:url value='/styles/prettify.css' encode='false' includeParams='none'/>" rel="stylesheet">
    <script src="<s:url value='/js/prettify.js' encode='false' includeParams='none'/>"></script>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <decorator:head/>
</head>

<body id="page-home" onload="prettyPrint();">

<header id="header" class="header">
    <div class="mbTopBanner">&nbsp;</div>
</header>

<div id="pageTitle">
<h1><%= request.getAttribute("pageTitle") %></h1>
</div>

<table cellpadding="0" cellspacing="0" border="0">
<tr>
<td width="250px" style="vertical-align: top;">
<nav id='navbar' class="navbar" style="padding-left: 4.5em;">

    <div class="navBody">
<%
    if (LoginInterceptor.isLoggedIn(session)) {
%>
        <h2 style="color: #2d70b8;" <s:if test="#current.contains('index.action')"> class="current" </s:if>>
            <s:a action="index" namespace="/" includeParams="none">Home</s:a>
        </h2>

        <h2 style="padding-top: 1.9em; padding-bottom: 0.3em;">
            <s:a action="view" namespace="/" includeParams="none">Credit Reports</s:a>
        </h2>
        <ul>
            <li <s:if test="#current.contains('create.action')"> class="current" </s:if>>
                <s:a action="create" namespace="/"
                     includeParams="none">Add Credit Report</s:a>
            </li>
            <li <s:if test="#current.contains('view.action')"> class="current" </s:if>>
                <s:a action="view" namespace="/"
                     includeParams="none">View Credit Reports</s:a>
            </li>
        </ul>
<%
    }
%>
    </div>
</nav>
</td>
<td style="vertical-align: top; padding-right: 4.5em;">
<decorator:body/>
</td>
</tr>
</table>

<div id="footer" class="footer pull-left">
    <div>
        <a href="http://struts.apache.org">
            <img src="<s:url value='/img/struts-power.gif' encode='false' includeParams='none'/>"
                 alt="Powered by Struts"/>
        </a>
    </div>
    &nbsp;<br/>
    Copyright &copy; 2019
    <a href="https://mergebase.com">
        Mergebase
    </a>
    <br/>&nbsp;<br/>&nbsp;<br/>
    <p style="height: 2em;"></p>
</div>


</body>
</html>
