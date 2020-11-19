<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <h1 style="color:red;text-align:center">all Employee details</h1>
    <body > 
        <head>
    <%-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link href="${contextPath}/resource/bootstrap.min.css" rel="stylesheet"> --%>
    </head>
   
    <c:choose>
     
    <c:when test="${!empty resultMsg}">
    <table  bgcolor="saffron" border="1" align="center">
  <tr>
    <th>SrNo</th>
    <th>empNo</th>
    <th>eName</th>
    <th>addrs</th>
    <th>salary</th>
    <th>grosSalary</th>
    <th>netSalary</th>
    <th>operation</th>
  </tr>
  <c:forEach var="dto" items="${resultMsg}">
  <tr>
  <td>${dto.srNo }</td>
  <td>${dto.empNo }</td>
  <td>${dto.eName }</td>
  <td>${dto.addrs }</td>
  <td>${dto.salary }</td>
  <td>${dto.grosSalary }</td>
  <td>${dto.netSalary }</td>
  <td><a href="edit_emp.htm?eno=${dto.empNo}"><img src="images/edit.jpg" width="40" height="40"/></a>
  &nbsp;&nbsp;<a href="delete_emp.htm?eno=${dto.empNo}"><img  src="images/delete.jpg" width="40" height="40"/></a></td>
   </tr>
  </c:forEach>
</table>
</body>
 
 </c:when>
 <c:otherwise><h1 style="color:red;text-align:center">page not found</h1>
 </c:otherwise>
    </c:choose>
   <br><br>
    <c:if test="${resultMsg} ne null && ${!empty resultMsg }">
     <marquee direction="right"><h1 style=color:red;text-align:center> ${resultMsg}</h1></marquee>
      </c:if>
     <tr>
   <td><h1 style="text-align:center"><a href="welcome.htm"><img  src="images/home1.jpg" width="100" height="100"></a></td>&nbsp;&nbsp;
   <a href="add.htm"><img  src="images/add1.jpg" width="100" height="100"> </a>
   &nbsp;&nbsp;
   <a href="print.htm"><img  src="images/print.jpg" width="100" height="100"></a>
   </td></h1>
   </tr>
  
    
    
