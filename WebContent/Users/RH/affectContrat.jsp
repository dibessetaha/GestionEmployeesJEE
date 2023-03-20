<%@ page import="java.util.Random" %>
<%@ page import="java.util.concurrent.ThreadLocalRandom" %><%--
  Created by IntelliJ IDEA.
  User: abdra
  Date: 18/03/2023
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link rel="stylesheet" href="http://localhost:8080/webproject/css/affect.css">
    <%!  public static String randomStringFromArr() {
        String[] Styles = {"card l-bg-orange-dark", "card l-bg-green-dark", "card l-bg-cherry", "card l-bg-blue-dark"};
        int index = ThreadLocalRandom.current().nextInt(Styles.length);
        String randomElem = Styles[index];
        return randomElem;
    } %>

</head>
<body>
<%@include file="sidebar.jsp"%>
<div class='dashboard-content'>
    <div class='container'>
        <div class='card'>
            <div class='card-header'>
                <h4>Contrat </h4>
            </div>
            <div class='card-body' >
          		  <div class="row">
		            <c:forEach var="contrat" items="${contrats}">
		                        <div class="col-xl-4 col-md-6">
									<form action="" method="post">
										<input type="hidden" name="user_id" class="form-control" value="${user_id }"  required placeholder="Enter last Name">
										<input type="hidden" name="contrat_id" class="form-control" value="${contrat.id }"  required placeholder="Enter last Name">
		                            <div class="<%=randomStringFromArr()%>">
		                                <div class="card-statistic-3 p-4">
		                                    <div class="mb-4">
		                                        <h2 class="card-title mb-0">${contrat.title}</h2>
		                                    </div>
		                                    <div class="row align-items-center mb-2 d-flex">
		                                        <div class="col-8">
		                                            <h5 class="d-flex align-items-center mb-0">
		                                                ${contrat.type }
		                                            </h5>
		                                        </div>
		                                    </div>
	                  						<button class="badge bg-type" style="color:black;" type="submit">Affect</button>
		                                </div>
		                            </div>
								</form>
		                        </div>
		                  </c:forEach>
		            </div>
					
                </div>
            </div>
        </div>
    </div>


<script src="https://cdnjs.cloudflare.com/ajax/libs/web-animations/2.3.2/web-animations.min.js"></script>
<script src="https://cdn.jsdelivr.net/gh/haltu/muuri@0.9.5/dist/muuri.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/js/all.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>

</body>
</html>
