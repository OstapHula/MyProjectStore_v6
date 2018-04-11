<%@ include file="/WEB-INF/taglib.jsp" %>

<div class="container body userList">
   <div class="row">
   
     <%@ include file="/WEB-INF/fragments/_leftnav.jsp" %>
     
     <div class="col-lg-9">			
		<h2>List Users</h2>
		<hr>
		<div style="overflow-x: auto">
			<table class="table table-sm table-bordered ">
			  <thead class="thead-light">
			    <tr>
			      	<th>Id</th>
			      	<th width="100">Image</th>
					<th>FullName</th>
					<th>Email</th>
					<th>Address</th>
					<th>Telephone</th>
					<th>Age</th>
					<th>CreatedAt</th>
					<!-- <th>shops</th> -->
					<th>Delete</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach items="${userListModel}" var="user">
				    <tr>
				      <td scope="row">${user.id}</td>
				      <td>
				      	<c:if test="${user.isActivated.equals('0')}"><div class="is-activated-false"></div></c:if>
				      	<c:if test="${user.isActivated == '1'}"><div class="is-activated-true"></div></c:if>
				      	<img src="data:image/png; base64, ${user.imagePath}" alt="image profile" class="list-profile-img">
						${user.role.role}
				      </td>
					  <td>${user.firstName} ${user.lastName}</td>
					  <td>${user.email}</td>
					  <td>${user.address}</td>
					  <td>${user.telephone}</td>
					  <td>${user.age}</td>
					  <td>${user.createdAt}</td>
					  <%-- <td>${user.shops}</td> --%>
					  <td>	  	
					  	<a href="/user/delete/user?id=${user.id}" class="btn btn-danger"><i class="fas fa-trash-alt"></i> Delete</a>
					  	<!-- <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal">
						  <i class="fas fa-trash-alt"></i> Delete
						</button> -->
					  </td>
				    </tr>
				    
				    <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-hidden="true">
				      <div class="modal-dialog" role="document">
				        <div class="modal-content">
				          <div class="modal-header">
				            <h5 class="modal-title" id="photoModalLabel">Delete user: ${user.firstName}</h5>
				            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
				              <span aria-hidden="true">&times;</span>
				            </button>
				          </div>
				          <div class="modal-body">
				            <div class="row">
						      <div class="col-md-5"> 
						      	<div class="profile-img">  
						           <img src="data:image/png; base64, ${user.imagePath}" alt="image profile"/> 							      
					       	  	</div>
						      </div>
						      <div class="col-md-7">
						        <h2>${user.role.role} profile</h2>
						        <hr>
						        <ul>
							         <li>Name: ${user.firstName} ${user.lastName}</li>
							         <li>Age: ${user.age}</li>
								  	 <li>Email: ${user.email}</li>
									 <li>Address: ${user.address}</li>
									 <li>Telephone: ${user.telephone}</li>
						        </ul>
						      </div>
					        </div>
				          </div>
				          <div class="modal-footer justify-content-between">
				            <a href="/user/delete?id=${user.id}" class="btn btn-danger"><i class="fas fa-trash-alt"></i> Delete</a>
				            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				          </div>
				        </div>
				      </div>
				    </div>
				    
				</c:forEach>
			  </tbody>
			</table>
		</div>
	</div>
  </div>
</div>

	