<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
   <%@include file='/static/css/login.css' %>
</style>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

 <head>
   <title>Spring Security Login page</title>
 </head>
 
 <body>
  
  <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
      <font class="forget">
        Your login attempt was not successful due to <br/><br/>
        <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
      </font>
    </c:if>
  <form name='form' id='loginForm' action='j_spring_security_check' method='POST'>
      <table >
	    <tr class="field">
                <td class="labels">User Name:</td>
	      <td ><input type='text' name='j_username' value=''></td>
	    </tr>
	    <tr class="field">
	      <td class="labels">Password:</td>
	      <td ><input type='password' name='j_password'/></td>
	    </tr>
	    
	    <tr>
	      <td colspan='2' >
	        <input name="submit" class="submit" type="submit" value="Login"/></td>
	    </tr>
	  </table>
  </form>
  
 </body>
</html>