<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Edit Product</title>
   </head>
   <body>
 
      <jsp:include page="_header.jsp"></jsp:include>
      <jsp:include page="_menu.jsp"></jsp:include>
 
      <h3>Edit Product</h3>
 
      <p style="color: red;">${errorString}</p>
 
      <c:if test="${not empty product}">
         <form method="POST" action="${pageContext.request.contextPath}/editProduct">
            <input type="hidden" name="id" value="${product.id}" />
            <table border="0">
               <tr>
                  <td>ID</td>
                  <td style="color:red;">${product.id}</td>
               </tr>
               <tr>
                  <td>Name</td>
                  <td><input type="text" name="name" value="${product.bookName}" /></td>
               </tr>
               <tr>
                  <td>Publisher</td>
                  <td><input type="text" name="publisherName" value="${product.publisherName}" /></td>
               </tr>
               <tr>
                  <td>Number Of Pages</td>
                  <td><input type="text" name="numberOfPage" value="${product.numberOfPage}" /></td>
               </tr>
               <tr>
                  <td colspan = "2">
                      <input type="submit" value="Submit" />
                      <a href="${pageContext.request.contextPath}/productList">Cancel</a>
                  </td>
               </tr>
            </table>
         </form>
      </c:if>
 
      <jsp:include page="_footer.jsp"></jsp:include>
 
   </body>
</html>