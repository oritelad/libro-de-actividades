<html>
<head>
<title>Curso JSP (Java Server Pages)</title>
</head>
<body bgcolor=white>

<table border="0">
<tr>
<td align=center>
<img src="../images/java_logo.gif">
</td>
<td>
<h1>JSP: Atributo Import</h1>
</td>
</tr>
</table>

<H1>Atributo Import</H2>
<%-- Directiva page --%>
<%@ page import="java.util.*,web.ser.*" %>

<%-- Declaracion JSP --%>
<%!
private String randomID() 
{
  int num = (int)(Math.random()*10000000.0);
  return("id" + num);
}

private final String NO_VALUE = "<I>No Value</I>";
%>

<%-- Scriptlet JSP --%>
<%
Cookie[] cookies = request.getCookies();
String oldID = ServletUtilities.getCookieValue(cookies, "userID", NO_VALUE);
String newID;
if (oldID.equals(NO_VALUE)) { newID = randomID();} 
else                        {  newID = oldID;}
LongLivedCookie cookie = new LongLivedCookie("userID", newID);
response.addCookie(cookie);
%>

<%-- Expresion JSP--%>
Esta p�gina fue accedida el <b><%= new Date() %></b> con el <i>userID-cookie</i> <b><%= oldID %></b>.

</BODY>
</HTML>