<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<link rel="stylesheet" href="/webproject/css/add.css">
    <title>Title</title>
</head>
<body>
<c:choose>
	<c:when test="${!empty sessionScope.username}">
		<%@include file="sidebar.jsp"%>
<div class='dashboard-content'>
    <div class='container'>
        <div class='card'>
            <div class='card-header'>
                <h4>Add Employes</h4>
            </div>
            <div class='card-body'>
                <div class="card mb-4">
                    <div class="form-body">
                    	<div class="row">
                    	<div class="form-content">
							<div style="background-color: #152733;" class="form-items">      
								<h3>Ajouter un employee</h3>   		
								<p>informations de l'employee</p>
								<form method="post" action="">
							  <div class="row">
								  	 <div class="col-md-6">
								   		 <input type="text" name="nom" class="form-control"  required placeholder="Enter last Name">
									  </div>
								   <div class="col-md-6">
									    <input type="text" name="prenom" class="form-control" required placeholder="Enter first Name">
							  		</div>
							  </div>
							<div class="row">
							  <div class="col-md-6">
							    <input type="text" name="username" class="form-control" required placeholder="Enter Username">
							  </div>
							  <div class="col-md-6">
							    <input type="password" name="password" class="form-control" required placeholder="Password">
							  </div>
							</div>
							 <div class="row">
							 	  <div class="col-md-6">
							    <input type="email" name="email" class="form-control" required placeholder="email">
							  </div>
							   <div class="col-md-6">
							    <input type="text" name="cv" class="form-control" required placeholder="cv">
							  </div>
							 </div>
							<div class="row">
							   <div class="col-md-6 mt-3 ">
							    <input type="text" name="dateNaissance" class="form-control" onfocus="(this.type='date')" onblur="(this.type='text')" id="exampleInputPassword1" placeholder="la date de naissance ">
							  </div>
							   <div class="col-md-6">
							    <input type="text" name="role" class="form-control" id="exampleInputPassword1" placeholder="role">
							  </div>
							</div>
							<div class="row">
                            	   <div class="col-md-6">
                                                <select name="poste_id" class="form-select mt-3" >
                                              		<option selected disabled value="">Poste</option>	
	                                            	<c:forEach var="poste" items="${postes}">
	                                            		<option value="${poste.id}">${poste.intitule }</option>
	                                            	</c:forEach>	
                                                </select>
                                            </div>
									</div>
							   <div class="form-button mt-3">
									<button id="submit" type="submit" class="btn btn-primary">Ajouter</button>
                               </div>
                              
						</form>
								
                    		</div>
                    	
						 
              		</div>
                </div>
            </div>
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
