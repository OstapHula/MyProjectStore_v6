<%@ include file="/WEB-INF/taglib.jsp"%>


<div class="container body change-pass">
	<div class="row">

		<%@ include file="/WEB-INF/fragments/_leftnav.jsp"%>

		<div class="col-lg-9">
			<h2>Change password</h2>
      		<hr>
			<form:form action="/user/change-pass" modelAttribute="changePassModel" method="POST">
				<div class="form-group">
					<form:errors path="*" cssClass="error"/>
					
					<c:if test="${error != null}">
						<div class="alert alert-danger" role="alert">
							<span class="error">${error}</span>
						</div>
					</c:if>
				</div>
				
				 <div class="form-group row">
			         <label class="col-sm-3 control-label">Old password: </label>
			         <div class="col-sm-9">
			           <form:password path="password" cssClass="form-control" title="Password" placeholder="Password"/>
			         </div>
			     </div>
				 <div class="form-group row">
			         <label class="col-sm-3 control-label">Confirm old password: </label>
			         <div class="col-sm-9">
			           <form:password path="passwordConfirmation" cssClass="form-control" title="Password" placeholder="Confirm password"/>
			         </div>
			     </div>
				 <div class="form-group row">
			         <label class="col-sm-3 control-label">New password: </label>
			         <div class="col-sm-9">
			           <form:password path="newPassword" cssClass="form-control" title="Password" placeholder="New password"/>
			         </div>
			     </div>						
				<div class="row">
					<button type="submit" class="col-sm-9 offset-3 btn btn-success btn-block" value="Change password">
						<i class="fas fa-key"></i> Change password
					</button>			
				</div>
			</form:form>
		</div>
	</div>
</div>