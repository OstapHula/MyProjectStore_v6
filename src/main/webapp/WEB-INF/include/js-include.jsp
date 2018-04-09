<script src="${pageContext.request.contextPath}/resources/js/jquery-slim.min.js"></script>
<!-- <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script> -->
<script src="${pageContext.request.contextPath}/resources/js/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

<script>
$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip(); 
});
</script>
<script>
	$('#myTab a').on('click', function (e) {
	  e.preventDefault()
	  $(this).tab('show')
	})
</script> 