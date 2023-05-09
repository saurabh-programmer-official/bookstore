<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>JlcBookStore</title>
<link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"/>
<link href="mycss/bookstore.css" rel="stylesheet">
</head>
<body>
<form:form action="/addMyRating" modelAttribute="UserRating">
<table>
<thead>
<tr>
<th>User ID</th>
<td><form:input path="userId" readOnly="true"/></td>
<tr>
<th>Book Id</th>
<td><form:input path="bookId"/></td>
</tr>
<tr>
<th>Rating</th>
<td><form:input path="rating"/></td>
</tr>
<tr>
<th>Review</th>
<td><form:textarea path="review"/></td>
</tr>
<tr>
<th colspan="2" align="center">
<input class="btn btn-primary" type="submit" value="Add Rating Info"/>
</th>
</tr>
</thead>
<tbody></tbody>
</table>

</form:form>
</body>
</html>