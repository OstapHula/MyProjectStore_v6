<%@ include file="/WEB-INF/taglib.jsp" %>

<div class="container body orderList">
   <div class="row">
   
     <%@ include file="/WEB-INF/fragments/_leftnav.jsp" %>
     
     <div class="col-lg-9">			
		<h2>Order List</h2>
		<hr>
		<c:set var = "sum" scope = "session" value = "${0}"/>
		<div style="overflow-x: auto">
			<table class="table table-sm table-bordered ">
			  <thead class="thead-light">
			    <tr>
			      	<th>Id</th>
					<th>Status</th>
					<th>Products</th>
					<th>Card</th>
					<th>Address</th>
					<th>Price</th>
					<th>Created At</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach items="${ordersModel}" var="order">
				    <tr>
				      <td scope="row">${order.id}</td>
				      <td>${order.status}</td>
					  <td>
					  	<c:forEach items="${order.quantitys}" var="quantity">
					  		Id: ${quantity.product.id} |
					  		Name: ${quantity.product.name} |
					  		Price: ${quantity.product.price} |
					  		Quantity: ${quantity.quantity} |
					  		Sum: ${quantity.product.price*quantity.quantity}<i class="fas fa-dollar-sign"></i>
					  		<br>
					  		<c:set var = "sum" scope = "session" value = "${sum + quantity.product.price*quantity.quantity}"/>
					  	</c:forEach>
					  	
					  </td>
					  <td>${order.card.cardNumber}</td>
					  <td>
					  	<i class="fas fa-map-marker"></i> 
				 		st. ${order.addres.street}, ${order.addres.houseNumber }/${order.addres.apartmenNumbert}<br>
				 		${order.addres.country}, ${order.addres.city}, ${order.addres.postalCode}
					  </td>
					  <td><c:out value = "${sum}"/><i class="fas fa-dollar-sign"></i></td>
					  <td>${order.createdAt}</td>
				    </tr>
				</c:forEach>
			  </tbody>
			</table>
		</div>
	</div>
  </div>
</div>