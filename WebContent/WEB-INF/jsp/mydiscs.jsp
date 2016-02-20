<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
   <%@include file='/static/css/table.css' %>
   <%@include file='/static/css/menu.css' %>
</style>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
     <body>
<nav class="two">
  <ul>
    <li><a href="/DiscService/discs"><i class="fa fa-home fa-fw"></i>Добавить диск</a></li>
    <li><a href="/DiscService/freediscs">Свободные диски</a></li>
    <li><a href="/DiscService/freediscs/mytakendiscs">Я взял в аренду</a></li>
    <li><a href="/DiscService/discsfromme">Мои диски в аренде</a></li>
    <li><a href="/DiscService/mydiscs">Мои диски</a></li>
    <li><a href="j_spring_security_logout">Выйти из системы</a></li>
  </ul>
</nav>
   
        
    
<h3>Список моих дисков:</h3>
<table class="table_blur">
<tr>
    <th><spring:message code="label.discname"/></th>
    <th><spring:message code="label.discyear"/></th>
    <th><spring:message code="label.genre"/></th>
    <th><spring:message code="label.discowner"/></th>
    <th></th>
</tr>
<c:forEach items="${discsList}" var="disc">
    <tr>
    	<td>${disc.discName }</td>
        <td>${disc.discyear}</td>
        <td>${disc.genre}</td>
        <td>${disc.discOwner}</td>
        <td><a href="mydiscs/delete/${disc.discId}"><spring:message code="label.remove"/></a></td>
    </tr>
</c:forEach>
</table>


</body>
</html>