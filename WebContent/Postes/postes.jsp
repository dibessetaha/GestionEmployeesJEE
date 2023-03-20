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
    <title>Title</title>
</head>
<style type="text/css">
.login-btm {
    float: left;
}

.login-button {
    padding-right: 0px;
    text-align: right;
    margin-bottom: 25px;
}
</style>
<body>
<c:choose>
	<c:when test="${!empty sessionScope.username }">
		<%@include file="/Users/Admin/sidebar.jsp"%>
<div class='dashboard-content'>
    <div class='container'>
        <div class='card'>
        <c:if test="${!empty delete }">
        	<p>${delete}</p>
        </c:if>
            <div class='card-header'>
                <h4>Postes</h4>
            </div>
            <div class='card-body'>
                <div class="card mb-4">
                    <div class="card-body">
                        <table id="datatablesSimple">
                            <thead>
                            <tr>
                                <th>Intitule</th>
                                <th>PlaceVide</th>
                                <th>Recrutement</th>
                                <th>Action</th>
                            </tr>
                            </thead>
                          
                            <tbody>
                            <c:forEach var="poste" items="${postes}">
                            <tr>
                            	
                                <td>${poste.intitule }</td>
                                <td>${poste.placeVide }</td>
                                <c:if test="${poste.placeVide == 0 }"><td>Places Indisponible</td></c:if>
                                <c:if test="${poste.placeVide != 0 }"><td>En cours</td></c:if>
                         
                                <td>
	                         			<a href="updateposte?id=${poste.id }"><button type="submit" class="btn btn-outline-primary">Edit</button></a>
	                         			<a href="deleteposte?id=${poste.id }"><button type="submit" class="btn btn-outline-primary">Supp</button></a>
                         			
                                </td>
                            
                            </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <a href="addposte"><button type="submit" class="btn btn-outline-primary">Add</button></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
<script >
	window.addEventListener('DOMContentLoaded', event => {
	    const datatablesSimple = document.getElementById('datatablesSimple');
	    if (datatablesSimple) {
	        new simpleDatatables.DataTable(datatablesSimple);
	    }
	});
</script>
	</c:when>
	<c:otherwise>
		<c:redirect url="login"></c:redirect>
	</c:otherwise>
</c:choose>

</body>
</html>
