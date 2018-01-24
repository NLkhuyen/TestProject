<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Feedback List</title>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <h3>Feed Back List</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>Id</th>
          <th>Comment</th>
          <th>修正</th>
       </tr>
       <c:forEach items="${feedBackList}" var="feedBack" >
          <tr>
             <td>${feedBack.ID}</td>
             <td>${feedBack.feedBack}</td>
             <td>
                <a href="editFeedBack?id=${feedBack.ID}">Edit</a>
             </td>
             <td>
                <a href="deleteFeedBack?id=${feedBack.ID}">Delete</a>
             </td>
          </tr>
       </c:forEach>
    </table>
 
    <a href="createNewFeedbackProduct" >Create FeedBack</a>
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>