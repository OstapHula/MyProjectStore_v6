<%@ include file="/WEB-INF/taglib.jsp" %>

<div class="container body products">
	<c:forEach items="${productsListByPageSize}" var="product">
	  <c:set var = "salary" scope = "session" value = "${product.id%4}"/>
	  	<c:choose>
		      <c:when test="${salary == 0}">
		        <div class="row">
		     
		          <div class="col-md-3">
		           <div class="card bg-light">
		             <%-- <img src="data:image/png; base64, ${product.imagePath}" alt="product" class="card-img-top"> --%>
		             <img src="${rootUrl}/resources/img/products/9063.png" width="250" height="250">
		             <div class="card-body text-white bg-dark">
		               <h5 class="card-title">${product.name} | ${product.price}</h5>
		               <p class="card-text">${product.description}</p>
		               <a href="/product/add-to-cart?id=${product.id}" class="btn btn-success"><i class="fas fa-shopping-cart"></i> Add to cart</a>
		             </div>
		           </div>
		          </div>
		         
		        </div>
		      </c:when>
		      
		      <c:otherwise>
		      
		       <div class="col-md-3">
		         <div class="card bg-light">
		           <%-- <img src="data:image/png; base64, ${product.imagePath}" alt="product" class="card-img-top"> --%>
		           <img src="${rootUrl}/resources/img/products/9038.png" width="250" height="250">
		           <div class="card-body text-white bg-dark">
		             <h5 class="card-title">${product.name} | ${product.price}</h5>
		             <p class="card-text">${product.description}</p>
		             <a href="/product/add-to-cart?id=${product.id}" class="btn btn-success"><i class="fas fa-shopping-cart"></i> Add to cart</a>
		           </div>
		         </div>
		       </div>

		      </c:otherwise>
		    </c:choose>
      
    </c:forEach>
</div>

	  	