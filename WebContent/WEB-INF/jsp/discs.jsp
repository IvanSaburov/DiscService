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
   
        
        
<h2>Добавление нового диска</h2>

<form:form method="post" action="adddisc.html" commandName="disc">
 
    <table class="table_blur">
        <th>Введите данные диска:</th>
    <tr>
        <td><form:label path="discName"><spring:message code="label.discname"/></form:label></td>
        <td><form:input path="discName"/></td>
    </tr>
    <tr>
    	<td><form:label path="discyear"><spring:message code="label.discyear"/></form:label></td>
    	<td><form:input path="discyear"/></td>
    </tr>
     <tr>
        <td><form:label path="genre"><spring:message code="label.genre"/></form:label></td>
        <td><form:input path="genre"/></td>
    </tr>
     <tr>
        <td><form:label path="discOwner"><spring:message code="label.discowner"/></form:label></td>
        <td><form:input path="discOwner" value="${username}" readonly="true"/></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" id="submit" value="<spring:message code="label.add"/>"/>
        </td>
    </tr>
</table>
</form:form>
 
<h3>Список дисков в системе:</h3>
<c:if  test="${!empty discsList}">
<table class="table_blur">
<tr>
    <th><spring:message code="label.discname"/></th>
    <th><spring:message code="label.discyear"/></th>
    <th><spring:message code="label.genre"/></th>
    <th><spring:message code="label.discowner"/></th>
    
</tr>
<c:forEach items="${discsList}" var="disc">
    <tr>
    	<td>${disc.discName }</td>
        <td>${disc.discyear}</td>
        <td>${disc.genre}</td>
        <td>${disc.discOwner}</td>
        
    </tr>
</c:forEach>
</table>
</c:if>

</body>
</html>