<%--
  Created by IntelliJ IDEA.
  User: abdra
  Date: 19/03/2023
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" href="http://localhost:8080/webproject/css/mescongees.css">
    <title>Title</title>
</head>
<body>
<%@include file="/Users/RH/sidebar.jsp"%>
<div class='dashboard-content'>
    <div class='container'>
        <div class='card'>
            <div class='card-header'>
                <h4>Approuver ou refuser les congees</h4>
            </div>
            <div class='card-body'>
            <c:forEach var="conge" items="${congees}">
                
            	<form method="post" action="">
                <div class="mt-3">   	
                    <ul class="list list-inline">
                        <li class="d-flex justify-content-between">
                            <div class="d-flex flex-row align-items-center">
                                <div class="ml-2">
                                    <h6 class="mb-0">&ensp;${conge.intitule}</h6>
									<h6 class="mb-0">&ensp;Emp Informations</h6>
                                    <h7 class="mb-0">&ensp;${conge.nom}</h7>
                                    <h7 class="mb-0">&ensp;${conge.prenom}</h7>
                                    <div class="d-flex flex-row mt-1 text-black-50 date-time">
                                        <div>&ensp;<i class="fa-regular fa-calendar"></i> <span class="ml-2">${conge.dateDebut}</span></div>
                                        <div class="ml-3">&ensp;<i class="fa-regular fa-calendar"></i> <span class="ml-2">${conge.dateFin}</span></div>
                                    </div>
                                </div>
                                <input type="hidden" name="id" class="form-control" value="${conge.id }"  required placeholder="Enter last Name">
								<button class="badge bg-type" style="color:black;" type="submit"><i class="fa fa-check-circle checkicon" style="font-size:20px;color:green"></i></button>
								<a class="badge bg-type" style="color:black;" href="refuserconge?id=${conge.id }"><i class="fa-solid fa-circle-xmark" style="font-size:20px;color:red"></i></a>
                            </div>
                        </li>
                    </ul>
                </div>
            	</form>
             </c:forEach>
            </div>
        </div>
    </div>
</div>
</div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/js/all.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
<script src="../../js/script.js"></script>
</body>
</html>




