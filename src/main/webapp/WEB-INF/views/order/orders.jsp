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
					<th>Order Status</th>
					<th>User</th>
					<th>Products</th>
					<th>In Cart</th>
					<th>Created At</th>
					<th>Delete</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach items="${listOrders}" var="order">
				    <tr>
				      <td scope="row">${order.id}</td>
				      <td>${order.orderStatus}</td>
					  <td>${order.user.firstName} ${order.user.email}</td>
					  <td>
					  	<c:forEach items="${order.products}" var="product">
					  		Id: ${product.id}<br>
					  		Name: ${product.name}<br>
					  		Price: ${product.price}<br>
					  	</c:forEach>
					  </td>
					  <td>${order.inCart}</td>
					  <td>${order.createdAt}</td>
					  <td>
					  	<a href="/user/delete?id=${user.id}" class="btn btn-danger"><i class="fas fa-trash-alt"></i> Delete</a>
					  </td>
				    </tr>
				</c:forEach>
			  </tbody>
			</table>
		</div>
	</div>
  </div>
</div>