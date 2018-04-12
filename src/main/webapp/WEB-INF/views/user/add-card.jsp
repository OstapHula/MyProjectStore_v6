<%@ include file="/WEB-INF/taglib.jsp"%>


<div class="container body change-pass">
	<div class="row">

		<%@ include file="/WEB-INF/fragments/_leftnav.jsp"%>

		<div class="col-lg-9">
			<h2>Add card</h2>
      		<hr>
			<form:form action="/user/add-card" modelAttribute="addCardModel" method="POST">
				<div class="form-group">
					<form:errors path="*" cssClass="error"/>
					
					<c:if test="${error != null}">
						<div class="alert alert-danger" role="alert">
							<span class="error">${error}</span>
						</div>
					</c:if>
				</div>
				 <div class="form-group row">
			         <label class="col-sm-3 control-label">Card number: </label>
			         <div class="col-sm-9">
			           <form:input path="cardNumber" cssClass="form-control" title="Card number" placeholder="number"/>
			         </div>
			     </div>				
				 <div class="form-group row">
			         <label class="col-sm-3 control-label">Validity period: </label>
			         <div class="col-sm-2">
			           <form:input path="validityPeriodMM" cssClass="form-control" title="MM" placeholder="MM"/>
			         </div> /
			         <div class="col-sm-2">
			           <form:input path="validityPeriodYY" cssClass="form-control" title="yy" placeholder="yy"/>
			         </div> 
			     </div>						
				 <div class="form-group row">
			         <label class="col-sm-3 control-label">Security code: </label>
			         <div class="col-sm-9">
			           <form:input path="securityCode" cssClass="form-control" title="Security code" placeholder="code"/>
			         </div>
			     </div>						
				 <div class="form-group row">
			         <label class="col-sm-3 control-label">Cardowner: </label>
			         <div class="col-sm-4">
			           <form:input path="cardownerFirstName" cssClass="form-control" title="Cardowner" placeholder="first_name"/>
			         </div>
			         <div class="col-sm-4 offset-sm-1">
			           <form:input path="cardownerLastName" cssClass="form-control" title="Cardowner" placeholder="last_name"/>
			         </div>
			     </div>						
								
				<div class="row">
					<button type="submit" class="col-sm-9 offset-3 btn btn-success btn-block" value="Add card">
						<i class="fas fa-credit-card"></i> Add card
					</button>			
				</div>
			</form:form>
		</div>
	</div>
</div>