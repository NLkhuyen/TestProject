<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Feedback</title>
</head>
<body>

	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>

	<h3>Create Product</h3>

	<p style="color: red;">${errorString}</p>

	<form method="POST"
		action="${pageContext.request.contextPath}/createFeedbackProduct">
		<input type="hidden" name="id" value="${product.id}" />
		<table border="0">
		<tr>
				<td>ID</td>
				<td><input type = "text" name = "id" value = "${product.id}" disabled="disabled"/></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type = "text" name = "name" value = "${product.bookName}" disabled="disabled"/></td>
			</tr>
			<tr>
				<td>Feed Back</td>
				<td><textarea name="feedBackContent" value="${feedBack.feedBack}" }></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /> <a
					href="productList">Cancel</a></td>
			</tr>
		</table>
	</form>

	<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>