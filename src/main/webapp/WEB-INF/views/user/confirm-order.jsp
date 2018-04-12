<%@ include file="/WEB-INF/taglib.jsp"%>


<div class="container body confirm-order">
	<div class="row">

		<%@ include file="/WEB-INF/fragments/_leftnav.jsp"%>

		<div class="col-lg-9">
			<h2>Confirm order</h2>
      		<hr>
			<div class="row" style="overflow-x: auto">
				<table class="table table-sm table-bordered ">
				  <thead class="thead-light">
				    <tr>
				      	<th>Image</th>
						<th>Title</th>
						<th>Create At</th>
						<th>price</th>
						<th>Quantity</th>
						<th>Total</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:forEach items="${orderModel.quantitys}" var="quantity">
					    <tr>
					      <td scope="row"><img src="data:image/png; base64, ${quantity.product.imagePath}" alt="image product" class="list-cart-img" ></td>
					      <td>${quantity.product.name}</td>
					      <td>${quantity.product.createdAt}</td>
						  <td>${quantity.product.price} <i class="fas fa-dollar-sign"></i></td>					  
						  <td><div class="quantity">${quantity.quantity}</div></td> 
						  <td>${quantity.product.price*quantity.quantity} <i class="fas fa-dollar-sign"></i></td>
					    </tr>
					    <c:set var = "sum" scope = "session" value = "${sum + quantity.product.price*quantity.quantity}"/>
					</c:forEach>
					<tr>
						<td colspan="5"><h5>Sum</h5></td>
						<td><c:out value = "${sum}"/><i class="fas fa-dollar-sign"></i></td>
					</tr>
				  </tbody>
				</table>
			</div>
				
			<form:form action="/user/confirm-order" modelAttribute="orderModel" method="POST">
				<div class="row">
					<div class="col-md-6 text-center">
						<h5>Select a address: </h5>
						<c:choose>
							<c:when test="${!orderModel.user.addreses.isEmpty()}">
								<c:forEach items="${orderModel.user.addreses}" var="address">
									<div class="card border-warning mb-3" style="max-width: 18rem;">
									  <div class="card-body text-warning">
									  	<div class="custom-control custom-radio">
											<form:radiobutton path="${orderModel.addres}" name="customRadio1" class="custom-control-input" id="customRadio_${address.id}"/>
											<form:label path="${orderModel.addres}" class="custom-control-label" for="customRadio_${address.id}">
												 <h5 class="card-title">Addres ${address.id}</h5>
											</form:label>
										</div>
									   
									    <p class="card-text">
									    	<i class="fas fa-map-marker"></i> 
									 		st. ${address.street}, ${address.houseNumber }/${address.apartmenNumbert}<br>
									 		${address.country}, ${address.city}, ${address.postalCode}
									 		<a href="/user/edit/address/${address.id}">
										    	<i class="fas fa-edit float-right text-warning"></i>
										    </a>
									    </p>
									  </div>
									</div>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<a role="button" class="btn btn btn-warning btn-block" href="/user/add-address">
									<i class="fas fa-map-marker"></i> Add address
								</a>
							</c:otherwise>
						</c:choose>
					</div>
					<div class="col-md-6 text-center">
						<h5>Select a card: </h5>
						<c:choose>
							<c:when test="${!orderModel.user.cards.isEmpty()}">
								<c:forEach items="${orderModel.user.cards}" var="card">
									<div class="card border-info mb-3" style="max-width: 18rem;">
									  <div class="card-body text-info">
									  	<div class="custom-control custom-radio">
											<form:radiobutton path="${orderModel.card}" name="customRadio2" class="custom-control-input" id="customRadio_${card.id}"/>
											<form:label path="${orderModel.card}" class="custom-control-label" for="customRadio_${card.id}">
												 <h5 class="card-title">Card ${card.id}</h5>
											</form:label>
										</div>
									    
									    <p class="card-text">
									    	<i class="fas fa-credit-card"></i>
									    	${card.cardownerFirstName} ${card.cardownerLastName}<br>
									 		${card.cardNumber}<br>
									 		<a href="/user/edit/card/${card.id}">
										    	<i class="fas fa-edit float-right text-warning"></i>
										    </a>
									    </p>
									  </div>
									</div>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<a role="button" class="btn btn btn-info btn-block" href="/user/add-card">
									<i class="fas fa-credit-card"></i> Add credit card
								</a>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				
				<div class="row">
					<button type="submit" class="col-12 btn btn-success btn-block payment-btn" value="Confirm order">
						<i class="fas fa-clipboard-check"></i> Go to payment
					</button>			
				</div>
			</form:form>
		</div>
	</div>
</div>