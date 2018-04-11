<%@ include file="/WEB-INF/taglib.jsp" %>

<div class="container body edit">
    <div class="row">

	<%@ include file="/WEB-INF/fragments/_leftnav.jsp" %>

      <div class="col-lg-9">
      	<h2>Edit profile</h2>
      	<hr>
      	<form:form 
	      		action="/user/edit" 
	      		modelAttribute="editUserModel" 
	      		method="POST" 
	      		enctype="multipart/form-data">
			<div class="form-group">
				<form:errors path="*" cssClass="error"/>
			</div>
			<div class="form-group">
              <div class="form-group row">
	          <label class="col-sm-3 control-label">First name: </label>
		         <div class="col-sm-9">
		           <form:input path="firstName" cssClass="form-control" title="First name" />
		         </div>
		      </div>
		      
		      <div class="form-group row">
		        <label class="col-sm-3 control-label">lastName: </label>
		        <div class="col-sm-9">
		          <form:input path="lastName" cssClass="form-control" title="last name" />
		      	</div>
		      </div>
		        
		      <div class="form-group row">
		         <label class="col-sm-3 control-label">Telephone: </label>
		         <div class="col-sm-9">
		           <form:input path="telephone" cssClass="form-control" title="Telephone" />
		         </div>
		      </div>
	        
		      <div class="form-group row">
		         <label class="col-sm-3 control-label">Age: </label>
		         <div class="col-sm-9">
		           <form:select path="age" cssClass="form-control" title="Age">
		           		<c:forEach var="i" begin="13" end="80">
		           			<form:option value="${i}"/>
		           		</c:forEach>
		           </form:select>
		         </div>
		      </div> 
	        
		      <div class="form-group row">
		         <label class="col-sm-3 control-label">E-mail address: </label>
		         <div class="col-sm-9">
		           <form:input path="email" cssClass="form-control" title="E-mail address" disabled="true" />
		         </div>
		      </div>
		      
		      <div class="form-group row">
		         <label class="col-sm-3 control-label">Upload image: </label>
		         <div class="col-sm-9">
		           <div class="custom-file">
					  <form:input path="file" type="file" class="custom-file-input" id="customFile"/>
					  <label class="custom-file-label" for="customFile">Choose file</label>
					</div>
		         </div>
		      </div>
		      
			  <div class="form-group row">
			  	 <div class="col-md-3">
				 	<a role="button" class="btn btn-secondary btn-block" href="/user/change-pass">
						<i class="fas fa-key"></i> Change password
					</a>
				 </div>
				 <div class="col-sm-9">
				 	<button type="submit" class="btn btn-success btn-block" value="Save change">
				 		<i class="fas fa-save"></i> Save change
				 	</button>
				 </div>
			  </div>
			</div>
		</form:form>
		<hr>
		<div class="row">
			<div class="col-md-4 offset-md-3">
				<a role="button" class="btn btn btn-warning btn-block" href="/user/add-address">
					<i class="fas fa-map-marker"></i> Add address
				</a>
			</div>
			<div class="col-md-4 offset-md-1">
				<a role="button" class="btn btn btn-info btn-block" href="/user/add-card">
					<i class="fas fa-credit-card"></i> Add credit card
				</a>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 offset-md-3">
				<c:if test="${addresesModel != null}">
					<c:forEach items="${addresesModel}" var="address">
						<div class="card border-warning mb-3" style="max-width: 18rem;">
						  <div class="card-body text-warning">
						  	<a href="/user/delete/address?id=${address.id}">
						  		<i class="fas fa-times float-right error"></i>
						  	</a>
						    <h5 class="card-title">Addres ${address.id}</h5>
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
				</c:if>
			</div>
			<div class="col-md-4 offset-md-1">
				<c:if test="${cardsModel != null }">
					<c:forEach items="${cardsModel}" var="card">
						<div class="card border-info mb-3" style="max-width: 18rem;">
						  <div class="card-body text-info">
						  	<a href="/user/delete/card?id=${card.id}">
						  		<i class="fas fa-times float-right error"></i>
						  	</a>
						    <h5 class="card-title">Card ${card.id}</h5>
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
				</c:if>
			</div>
		</div>
     </div>
   </div>
 </div>
				    