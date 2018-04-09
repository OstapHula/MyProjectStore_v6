<%@ include file="/WEB-INF/taglib.jsp" %>

<div class="container body orderList">
   <div class="row">
   
     <%@ include file="/WEB-INF/fragments/_leftnav.jsp" %>
     
     <div class="col-lg-9">			
		<h2>Order List</h2>
		<hr>
		<div style="overflow-x: auto">
			<table class="table table-sm table-bordered ">
			  <thead class="thead-light">
			    <tr>
			      	<th>Image</th>
					<th>Title</th>
					<th>price</th>
					<th>inCart</th>
					<th>Total</th>
					<th>Delete</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach items="${cartList}" var="product">
				    <tr>
				      <td scope="row"><img src="data:image/png; base64, ${product.imagePath}" alt="image product" ></td>
				      <td>${product.name}</td>
				      <td>${product.createdAt}</td>
					  <td>${product.price}</td>					  
					  <td>
					  	<c:forEach items="${product.orders}" var="order">
					  		
					  	</c:forEach>
					  </td>					  
					  <td>${product.inCart}</td>
					  <td>${product.price*product.inCart}</td>
					  <td>
					  	<a href="/user/delete?id=${user.id}" class="btn btn-danger"><i class="fas fa-trash-alt"></i> Delete</a>
					  </td>
				    </tr>
				</c:forEach>
			  </tbody>
			</table>
		</div>
	</div>
  </div>
</div>
<!-- private String name;
	
	@Column(columnDefinition = "DECIMAL(5,2)")
	private BigDecimal price;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "image_path")
	private String imagePath;
	
	@Column(name = "in_stock")
	private int inStock;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "parameters_product_id", nullable = true)
	private ParametersProductEntity parameters;
	
	@ManyToMany
	@JoinTable(
			name = "product_order",
			joinColumns = @JoinColumn(name = "product_id"),
			inverseJoinColumns = @JoinColumn(name = "order_id")
		)
	private List<OrderEntity> orders = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(
		name = "product_user",
		joinColumns = @JoinColumn(name = "product_id"),
		inverseJoinColumns = @JoinColumn(name = "user_id")
		)
	private List<UserEntity> users = new ArrayList<>();  -->
