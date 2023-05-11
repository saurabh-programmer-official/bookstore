<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>JlcBookStore</title>
<link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"/>
<link href="mycss/bookstore.css" rel="stylesheet">
</head>
<body>
<div class="card"> 
<c:import url="myheader.jsp"/> 
</div>
<div class="container">
<form:form action="/addMyRating" modelAttribute="UserRating">
<table class="table table-striped table-bordered table-light myfont">
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
<th ></th>
<td >
<input class="btn btn-primary" type="submit" value="Add Rating Info"/>
</td>
</tr>
</thead>
<tbody></tbody>
</table>
</form:form>
</div> 
<div>
 <c:import url="myfooter.jsp"/>
 </div>
</body>
</html>