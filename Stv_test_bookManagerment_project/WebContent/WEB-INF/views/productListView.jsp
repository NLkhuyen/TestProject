<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Product List</title>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <h3>Product List</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>Id</th>
          <th>Name</th>
          <th>Publisher</th>
          <th>Number Of Pages</th>
          <th>修正</th>
       </tr>
       <c:forEach items="${productList}" var="product" >
          <tr>
             <td>${product.id}</td>
             <td>${product.bookName}</td>
             <td>${product.publisherName}</td>
             <td>${product.numberOfPage}</td>
             <td>
                <a href="editProduct?id=${product.id}">Edit</a>
             </td>
             <td>
                <a href="deleteProduct?id=${product.id}">Delete</a>
             </td>
             <td>
                <a href="createFeedbackProduct?id=${product.id}">Feed back</a>
             </td>
          </tr>
       </c:forEach>
    </table>
 
    <a href="createProduct" >Create Product</a>
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>