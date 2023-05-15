<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html> <head> 
 <title>JLC Bookstore</title> 
 <link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"> 
 <link href="mycss/bookstore.css" rel="stylesheet"> 
</head> 
<body> 
<div class="card"> 
<c:import url="myheader.jsp"/> 
</div> 
<div class="container"> 
<form action="/showAllBooks" > 
 <table class="table table-striped table-bordered table-light myfont"> 
<tr> 
<td> 
 <select name="author" class="form-control mytext" > 
 <c:forEach var="authorName" items="${MyAuthorList}"> 
 <option value="${authorName}">  
 <c:out value="${authorName}"/>
 </option> 
 </c:forEach> 
 </select> 
</td> 
Java Learning Center 79 Spring MicroServices 
<td> 
 <select name="category" class="form-control mytext" > 
 <c:forEach var="catName" items="${MyCateogryList}"> 
 <option value="${catName}"> 
 <c:out value="${catName}"/> 
 </option> 
 </c:forEach> 
 </select> 
 </td> 
<td> <input class="btn btn-primary" type="submit" value="Show Books " /> </td> 
</tr> 
 </table> 
 </form> 
</div> 
<div class="container"> 
 <table class="table table-striped table-bordered table-light myfont"> 
 <thead class="bg-info"> 
<tr> 
<th>Book ID</th> 
<th>Book Name</th> 
<th>Author</th> 
<th>Publications </th> 
<th>Category</th> 
<th colspan="2" align="center"> 
<a href="showMyCart" class="btn btn-danger"> Show My Cart </a> 
 </th> 
</tr> 
</thead> 
 <tbody> 
<c:forEach var="mybook" items="${MyBooksList}"> 
<tr> 
<td> ${mybook.bookId } </td> 
<td>${mybook.bookName }</td> 
<td>${mybook.author }</td> 
<td>${mybook.publication }</td> 
<td>${mybook.category }</td> 
<td> 
<form:form action="addToCart"> 
<input type="hidden" name="bookId" value="${mybook.bookId }"/> 
<input class="btn btn-primary" type="submit" value=" Add to My Cart " /> 
</form:form> 
</td> 
Java Learning Center 80 Spring MicroServices 
<td> 
<form:form action="showBookInfo" method="get"> 
<input type="hidden" name="bookId" value="${mybook.bookId }"/> 
<input class="btn btn-primary" type="submit" value=" More Info " /> 
</form:form> 
</td> 
</tr> 
</c:forEach> 
 </tbody> 
 </table> 
</div> 
 <c:import url="myfooter.jsp"/> 
</body> </html> 