<%@ include file="/WEB-INF/taglib.jsp" %>
 
 <div class="container body profile">
    <div class="row">
    
      <%@ include file="/WEB-INF/fragments/_leftnav.jsp" %>
      
      <div class="col-lg-9">
      	<div class="row">
	      <div class="col-md-5"> 
	      	<div class="profile-img">  
	           <img src="data:image/png; base64, ${userProfile.imagePath}" alt="image profile"/> 
	            <a href="#" data-toggle="modal" data-target="#photoModal">
	               <i class="fas fa-search-plus fa-2x"></i>
	       	  	</a>
       	  	</div>
	      </div>
	      <div class="col-md-7">
	        <h2>${userProfile.role.role} profile</h2>
	        <hr>
	        <ul>
		         <li>Name: ${userProfile.firstName} ${userProfile.lastName}</li>
		         <li>Age: ${userProfile.age}</li>
			  	 <li>Email: ${userProfile.email}</li>
				 <li>Telephone: ${userProfile.telephone}</li> 
	        </ul>
	      </div>
        </div>
      </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="photoModal" tabindex="-1" role="dialog" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="photoModalLabel">Photo ${userProfile.firstName}</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
             <img src="data:image/png; base64, ${userProfile.imagePath}" alt="image profile"/>
          </div>
          <div class="modal-footer justify-content-between">
            <a href="user/edit" role="button" class="btn btn-primary"><i class="fas fa-upload"></i> Upload new photo</a>
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          </div>
        </div>
      </div>
    </div>
  </div>
 
 
 
 
 