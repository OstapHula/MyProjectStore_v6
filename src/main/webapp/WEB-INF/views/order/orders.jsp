<%@ include file="/WEB-INF/taglib.jsp" %>

<div class="container body orderList">
   <div class="row">
   
     <%@ include file="/WEB-INF/fragments/_leftnav.jsp" %>
     
     <div class="col-lg-9">			
		<h2>Order List</h2>
		<hr>
		<div style="overflow-x: auto">
			<table class="table table-sm table-bordered ">
			  <thead class="thead-light">
			    <tr>
			      	<th>Id</th>
					<th>Status</th>
					<th>User</th>
					<th>Products</th>
					<th>Created At</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach items="${listOrders}" var="order">
				    <tr>
				      <td scope="row">${order.id}</td>
				      <td>${order.status}</td>
					  <td>${order.user.firstName} ${order.user.email}</td>
					  <td>
					  	<c:forEach items="${order.quantitys}" var="quantity">
					  		Id: ${quantity.product.id} |
					  		Name: ${quantity.product.name} |
					  		Price: ${quantity.product.price} |
					  		Quantity: ${quantity.quantity} |
					  		Sum: ${quantity.product.price*quantity.quantity}
					  		<br>
					  	</c:forEach>
					  </td>
					  <td>${order.createdAt}</td>
				    </tr>
				</c:forEach>
			  </tbody>
			</table>
		</div>
	</div>
  </div>
</div>