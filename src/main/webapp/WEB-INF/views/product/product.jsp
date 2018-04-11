<%@ include file="/WEB-INF/taglib.jsp" %>

<div class="container body product">
	<div class="row">
		<div class="col-md-7 product-img">
			<img src="data:image/png; base64, ${productModel.imagePath}" alt="image profile"/>
		</div>
		<div class="col-md-5">
			<sec:authentication property="principal.username" var="username" />
			<h1>${productModel.name}</h1>
			<hr>
			<div class="row justify-content-between">
				<span class="badge badge-info">In stock: ${productModel.inStock}</span>  
				<a href="/like?id=${productModel.id}"><i class="fas fa-heart heart animated pulse" id="animated"></i></a>
			</div>
			<p style="max-hight: 200px">${productModel.description}</p>
			<h3 class="price">${productModel.price} <i class="fas fa-dollar-sign"></i></h3>
			<div class="row buy-btn">
				<c:choose>
               	<c:when test="${username == 'admin@gmail.com'}">
               		<a href="/product/edit/${productModel.id}" class="btn btn btn-warning">
               			<i class="fas fa-edit"></i> Edit
               		</a>
               		<a href="/product/delete?id=${productModel.id}" class="btn btn-danger">
               			<i class="fas fa-trash-alt"></i> Delete
               		</a>
               	</c:when>
               	<c:otherwise>
               		<c:choose>
               			<c:when test="${productModel.inStock <= 0}">
               				<a href="#" role="button" class="btn btn-success disabled">
		               			Add to cart <i class="fas fa-shopping-cart"></i>
		               		</a>
							<a href="#" role="button" class="btn btn-secondary disabled">
								Buy now <i class="fas fa-shopping-basket"></i>
							</a>
               			</c:when>
               			<c:otherwise>
               				<a href="/order/add-to-cart?id=${productModel.id}" role="button" class="btn btn-success ">
		               			Add to cart <i class="fas fa-shopping-cart"></i>
		               		</a>
							<a href="#" role="button" class="btn btn-secondary ">
								Buy now <i class="fas fa-shopping-basket"></i>
							</a>
               			</c:otherwise>
               		</c:choose>
               	</c:otherwise>
               </c:choose>
				
			</div>
		    <a data-toggle="collapse" href="#collapseExample">
		      <u>Product details</u> <i class="fas fa-sort-down"></i>
		    </a>
			<div class="collapse" id="collapseExample">
			  <div class="card card-body">
			    <ul>
					<li>Style: ${productModel.parameters.style}</li>
					<li>MaterialStrap: ${productModel.parameters.materialStrap}</li>
					<li>MaterialBody: ${productModel.parameters.materialBody}</li>
					<li>FaseType: ${productModel.parameters.faseType}</li> 
					<li>FaseColor: ${productModel.parameters.faseColor}</li> 
					<li>Weight: ${productModel.parameters.weight}</li> 
					<li>Waterproof: ${productModel.parameters.waterproof}</li> 
					<li>Glass: ${productModel.parameters.glass}</li> 
					<li>WidthStrap: ${productModel.parameters.widthStrap}</li> 
					<li>DiametrBody: ${productModel.parameters.diametrBody}</li> 
					<li>ThicknessBody: ${productModel.parameters.thicknessBody}</li> 
				</ul>
			  </div>
			</div>
		</div>
	</div>
</div>