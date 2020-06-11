<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../header.html" %>

<a>追加する商品を入力してください</a>
<form action="insert" method="post">
  商品名<input type="text" name="name">
  価格<input type="text" name="price">
  <input type="submit" value="add!">
</form>

<%@include file="../footer.html" %>
