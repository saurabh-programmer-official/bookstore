<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>JlcBookStore</title>
<link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"/>
<link href="mycss/bookstore.css" rel="stylesheet">
</head>

<body>

<div class="container">
<form action="/placeOrder">
<table class="table table-hover table-striped table-bordered table-light myfont">
<thead class="bg-info">
<tr>
<th>BookId</th>
<th>BookName</th>
<th>Category</th>
<th>Author</th>
<th>Publication</th>
<th>Action</th>
<th> 
<a href="continueShopping" class="btn btn-danger"> Continue Shopping</a> 
</th> 
</tr>
</thead>
<tbody>
<c:forEach var="eachBook" items="${MyCartBooks}">
<tr>
<td>${eachBook.bookId}</td>
<td>${eachBook.bookName }</td>
<td>${eachBook.category}</td>
<td>${eachBook.author }</td>
<td>${eachBook.publication }</td>
<td>
<form:form method="post" action="/remove">
<input type="submit" class="btn btn-danger" value="Remove Item"/>
<input type="hidden" name="bookId" value="${eachBook.bookId}"/>
</form:form>
</td>
</tr>
</c:forEach>
</tbody>
</table>
<input type="submit" class="btn btn-primary" value="Place Order"/>
</form>
</div>
</body>

</html>
