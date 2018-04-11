<%@ include file="/WEB-INF/taglib.jsp" %>

<div class="container body favoriteList">
   <div class="row">
   
     <%@ include file="/WEB-INF/fragments/_leftnav.jsp" %>
     
     <div class="col-lg-9">			
		<h2>Favorite products</h2>
		<hr>
		<div style="overflow-x: auto">
			<table class="table table-sm table-bordered ">
			  <thead class="thead-light">
			    <tr>
			      	<th>Image</th>
					<th>Title</th>
					<th>Price</th>
					<th>Likes</th>					
					<th>Dislike</th>					
					<th>Details</th>					
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach items="${productsModel}" var="product">
				    <tr>
				      <td scope="row"><img src="data:image/png; base64, ${product.imagePath}" alt="image profile" class="list-cart-img"></td>
				      <td>${product.name}</td>		
					  <td>${product.price}</td>
					  <td>${product.usersLike.size()}</td>
					  <td><a href="/dislike?id=${product.id}"><i class="fas fa-heart heart" style="color: #faa"></i></a></td>
					  <td>
						  <a href="/product/product/${product.id}" class="btn btn-secondary">
	               			<i class="fas fa-info"></i> Details
	               		  </a>
	               	  </td>
				    </tr>
				</c:forEach>
			  </tbody>
			</table>
		</div>
	</div>
  </div>
</div>
