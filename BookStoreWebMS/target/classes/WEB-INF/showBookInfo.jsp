<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>

</head>
<body>
<table>
<thead>
<tr>
<th>BookId</th>
<th>BookName</th>
<th>Author</th>
<th>Publication</th>
<th>Rating</th>
<th>Number of Searches</th>
<th>Inventory</th>
<th>Price</th>
<th>Offer</th>
</tr>
</thead>
<tbody>
<tr>
<td>${MyBookInfo.bookId }</td>
<td>${MyBookInfo.bookName }</td>
<td>${MyBookInfo.author }</td>
<td>${MyBookInfo.publication }</td>
<td>${MyBookInfo.rating }</td>
<td>${MyBookInfo.number_of_searches }</td>
<td>${MyBookInfo.inventory }</td>
<td>${MyBookInfo.price }</td>
<td>${MyBookInfo.offer }</td>
</tr>
</tbody>
</table>

</body>
</html>