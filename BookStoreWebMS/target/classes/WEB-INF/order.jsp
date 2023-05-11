<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<html> 
<head> 
 <title>JLC Bookstore</title> 
 <link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"> 
 <link href="mycss/bookstore.css" rel="stylesheet"> 
</head> 
 <body> 
<div class="card"> 
<c:import url="myheader.jsp"/> 
</div> 
<h2> Your Order is Successfully Placed..Order details as follows</h2>
<h4>${Order}</h4>
<table class="table table-striped table-bordered table-light myfont">
<thead><tr>
<th>BookId</th>
<th>Qty</th>
<th>Cost</th>
</tr></thead>
<tbody>
<c:forEach var="orderItemList" items="${OrderItemList }">
<tr>

<td>${orderItemList.bookId}</td>
<td>${orderItemList.qty}</td>
<td>${orderItemList.cost}</td>
</tr>

</c:forEach>
</tbody>
</table>
<c:import url="myfooter.jsp"/> 
</body> 
</html>