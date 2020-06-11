<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../header.html" %>

<form action="total-out.jsp" method="post">
  <input type="text" name="price">
  円x
  <input type="text" name="count">
  個=
  <input type="submit" value="calc!">
</form>

<%@include file="../footer.html" %>
