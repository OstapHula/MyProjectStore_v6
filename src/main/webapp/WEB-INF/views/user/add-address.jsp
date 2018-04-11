<%@ include file="/WEB-INF/taglib.jsp"%>


<div class="container body change-pass">
	<div class="row">

		<%@ include file="/WEB-INF/fragments/_leftnav.jsp"%>

		<div class="col-lg-9">
			<h2>Add address</h2>
      		<hr>
			<form:form action="/user/add-address" modelAttribute="addAddressModel" method="POST">
				<div class="form-group">
					<form:errors path="*" cssClass="error"/>
					
					<c:if test="${error != null}">
						<div class="alert alert-danger" role="alert">
							<span class="error">${error}</span>
						</div>
					</c:if>
				</div>
				 <div class="form-group row">
			         <label class="col-sm-3 control-label">Country: </label>
			         <div class="col-sm-9">
			           <form:input path="country" cssClass="form-control" title="Country" placeholder="Country"/>
			         </div>
			     </div>
				 <div class="form-group row">
			         <label class="col-sm-3 control-label">City: </label>
			         <div class="col-sm-9">
			           <form:input path="city" cssClass="form-control" title="City" placeholder="City"/>
			         </div>
			     </div>
				 <div class="form-group row">
			         <label class="col-sm-3 control-label">Street: </label>
			         <div class="col-sm-9">
			           <form:input path="street" cssClass="form-control" title="Street" placeholder="Street"/>
			         </div>
			     </div>						
				 <div class="form-group row">
			         <label class="col-sm-3 control-label">House / Apartment </label>
			         <div class="col-sm-2">
			           <form:input path="houseNumber" cssClass="form-control" title="House number" placeholder="House"/>
			         </div> / 
			         <div class="col-sm-2">
			           <form:input path="apartmenNumbert" cssClass="form-control" title="Apartmen numbert" placeholder="Apartment"/>
			         </div>
			     </div>						
				 <div class="form-group row">
			         <label class="col-sm-3 control-label">Postal code: </label>
			         <div class="col-sm-9">
			           <form:input path="postalCode" cssClass="form-control" title="Postal code" placeholder="code"/>
			         </div>
			     </div>						
								
				<div class="row">
					<button type="submit" class="col-sm-9 offset-3 btn btn-success btn-block" value="Change password">
						<i class="fas fa-map-marker"></i> Add address
					</button>			
				</div>
			</form:form>
		</div>
	</div>
</div>