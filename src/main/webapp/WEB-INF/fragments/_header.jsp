<%@ include file="/WEB-INF/taglib.jsp"%>

<header>
	<nav class="navbar navbar-expand-lg navbar-dark fixed-top">
		<a class="navbar-brand logo" href="/"> 
			<img src="${rootUrl}/resources/img/favicon.ico"> 
			N<div class="logo-a">V</div>VIFORCE
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav mr-auto ">
				<li class="nav-item active"><a class="nav-link"	href="${rootUrl}/">home</a></li>
				<li class="nav-item"><a class="nav-link" href="/product/catalog">catalog</a></li>
				<li class="nav-item"><a class="nav-link" href="#SandP">shipping</a></li>
				<li class="nav-item"><a class="nav-link" href="#contact">contact</a></li>
			</ul>
			<ul class="navbar-nav align-items-center right-navbar">

				<sec:authorize access="!isAuthenticated()">
					<li class="nav-item">
						<a class="nav-link btn btn-outline-secondary" href="${rootUrl}/login" role="button">
							<i class="fas fa-user"></i> Login or Register
						</a>
					</li>
				</sec:authorize>

				<sec:authorize access="isAuthenticated()">
					<sec:authentication property="principal.username" var="username" />
					<li>
						<div class="btn-group">
							<a role="button"
								class="dropdown-toggle nav-link btn btn-outline-secondary" 
									href="/user" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false"> 
								${username} <span class="badge badge-light">42</span>
							</a>
							<div class="dropdown-menu">
								<a href="/user" role="button" class="btn dropdown-item"> 
									<i class="fas fa-user"></i> Profile
								</a> 
								<a href="/user/edit" role="button" class="btn dropdown-item">
									<i class="fas fa-edit"></i> Edit
								</a> 
								<a href="/user/favorite" role="button"	class="btn dropdown-item"> 
									<i class="fas fa-heart"></i> Favorite
								</a> 
								<a href="/user/cart" role="button" class="btn dropdown-item">
									<i class="fas fa-shopping-cart"></i> Cart
								</a> 
								<a href="/user/history" role="button" class="btn dropdown-item">
									<i class="fas fa-history"></i> Shopping history
								</a>
								
								<div class="dropdown-divider"></div>
								
								<c:url var="logoutUrl" value="/logout" />
								<form:form action="${logoutUrl}" method="post" id="logout">
									<button type="submit" class="btn btn-outline-danger dropdown-item text-uppercase" value="logout"> 
										<i class="fas fa-sign-out-alt"></i> Logout
									</button>
								</form:form>
								
								 <!-- admin -->
							    <c:if test="${username == 'admin@gmail.com'}">
									<div class="dropdown-divider"></div>								     
								    <a href="/product/add-product" class="btn dropdown-item">
								    	<i class="fas fa-plus"></i> New product
								    </a>						
							        <a href="/product/catalog" class="btn dropdown-item">
							        	<i class="fas fa-th"></i> Products
							        </a>
							        <a href="/order/orders" class="btn dropdown-item">
							        	<i class="fas fa-clipboard-list"></i> Orders
							        </a>								     
							        <a href="/user/users" class="btn dropdown-item">
							       		<i class="fas fa-users"></i> Users
							        </a>								     			
							 	</c:if>
							</div>
						</div>
					</li>
				</sec:authorize>
			</ul>
		</div>
	</nav>
</header>




