<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<link rel="stylesheet" href="/webproject/css/add.css">
    <title>Title</title>
</head>
<body>
<c:choose>
	<c:when test="${!empty sessionScope.username}">
		<%@include file="/Users/Employe/sidebar.jsp"%>
<div class='dashboard-content'>
    <div class='container'>
        <div class='card'>
            <div class='card-header'>
                <h4>Demander Votre Conge</h4>
            </div>
            <div class='card-body'>
                    <div class="form-body">
                    <form method="post" action="">
                    		<div class="row">
							   <div class="col-md-6 ">
							    <input type="text" name="dateDebut" class="form-control" onfocus="(this.type='date')" onblur="(this.type='text')" id="exampleInputPassword1" placeholder="la date de debut ">
							  </div>
							   <div class="col-md-6">
							    <input type="text" name="dateFin" class="form-control" onfocus="(this.type='date')" onblur="(this.type='text')" id="exampleInputPassword1" placeholder="la date de fin ">
							  </div>
							  <div class="col-md-6">
							    <input type="hidden" name="user_id" value="${user.id}" class="form-control" onfocus="(this.type='date')" onblur="(this.type='text')" id="exampleInputPassword1" placeholder="la date de fin ">
							  </div>
							</div>
						
							   <div class="form-button mt-3">
									<button id="submit" type="submit" class="btn btn-primary">Demander</button>
                               </div>
					</form>                    	
						 
              		</div>
                </div>
            </div>
        </div>
    </div>
	</c:when>
	<c:otherwise>
		<c:redirect url="login"></c:redirect>
	</c:otherwise>
</c:choose>


</body>
</html>
