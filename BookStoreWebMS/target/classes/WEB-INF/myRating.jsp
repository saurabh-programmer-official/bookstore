<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>JlcBookStore</title>
<link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"/>
<link href="mycss/bookstore.css" rel="stylesheet">
</head>
<body>
<table>
<thead>
<tr>
<th>BookId</th>
<th>Book Name</th>
<th>Average Rating</th>
<th></th>
</tr>
</thead>
<tbody>
<c:forEach var="myRating" items="${ }">
<tr>
<td>${myRating.bookId}</td>
<td>${myRating.bookName }</td>
<td>${myRating.avgRating }</td>
</tr>
</c:forEach>
</tbody>
</table>


</body>
</html>