<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../header.html" %>

<%!
  int countA = 0;
%>

<%
  int countB = 0;
  countA++;
  countB++;
%>

<p>countA=<%= countA %></p>
<p>countB=<%= countB %></p>

<%@include file="../footer.html" %>
