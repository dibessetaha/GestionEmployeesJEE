<%--
  Created by IntelliJ IDEA.
  User: abdra
  Date: 12/03/2023
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<link rel="stylesheet" href="/webproject/css/add.css">
    <title>Title</title>
</head>

<body>
<%@include file="sidebar.jsp"%>
<div class='dashboard-content'>
    <div class='container'>
        <div class='card'>
            <div class='card-header'>
                <h4>Modifier Employes</h4>
            </div>
            <div class='card-body'>
                <div class="card mb-4">
                    <div class="form-body">
                    	<div class="row">
                    	<div class="form-content">
							<div style="background-color: #152733;" class="form-items">      
								<h3>Modifier l'employer : ${user.nom} ${user.prenom }</h3>   		
								<form method="post" action="">
							    <div class="row">
							   		 <div class="col-md-6">
								   		 <input type="hidden" name="id" class="form-control" value="${user.id }"  required placeholder="Enter last Name">
									  </div>
								  	 <div class="col-md-6">
								   		 <input type="text" name="nom" class="form-control" value="${user.nom }"  required placeholder="Enter last Name">
									  </div>
								   <div class="col-md-6">
									    <input type="text" name="prenom" class="form-control" value="${user.prenom }"  required placeholder="Enter first Name">
							  		</div>
							  </div>
							<div class="row">
							  <div class="col-md-6">
							    <input type="text" name="username" class="form-control" value="${user.username}"  required placeholder="Enter Username">
							  </div>
							  <div class="col-md-6">
							    <input type="password" name="password" value="${user.password }"  class="form-control" required placeholder="Password">
							  </div>
							</div>
							 <div class="row">
							 	  <div class="col-md-6">
							    <input type="email" name="email" class="form-control" value="${user.email }"  required placeholder="email">
							  </div>
							   <div class="col-md-6">
							    <input type="text" name="cv" class="form-control" value="${user.cv }"  required placeholder="cv">
							  </div>
							 </div>
							<div class="row">
							   <div class="col-md-6 mt-3">
							    <input type="date" name="dateNaissance" value="${user.dateNaissance }"  class="form-control" id="exampleInputPassword1" placeholder="Poste">
							  </div>
							   <div class="col-md-6">
							    <input type="text" name="role"  value="${user.role }" class="form-control" id="exampleInputPassword1" placeholder="role">
							  </div>
							</div>
							   <div class="form-button mt-3">
									<button id="submit" type="submit" class="btn btn-primary">Modifier</button>
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

</body>
</html>
