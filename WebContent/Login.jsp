<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
	<link rel="stylesheet" href="http://localhost:8080/webproject/css/loginStye.css" /> 
    <title>GEMP</title>
</head>
<body  >
<div class="container" >
		
		<div class="row">
	        <div class="col-lg-3 col-md-2"></div>
	        <div class="col-lg-6 col-md-8 login-box">
	            <div class="col-lg-12 login-key">
	                <i class="fa fa-key" aria-hidden="true"></i>
	            </div>
				<c:if test="${!empty error }">
	            		<div class="alert alert-danger" role="alert">
							${error}
						</div>
				</c:if>
	            <div class="col-lg-12 login-title">
	                Gestion d'employer
	            </div>
	
	            <div class="col-lg-12 login-form">
	                <div class="col-lg-12 login-form">
	                    <form method="post" action="">
	                        <div class="form-group">
	                            <label class="form-control-label">USERNAME</label>
	                            <input name="username" type="text" class="form-control" required>
	                        </div>
	                        <div class="form-group">
	                            <label class="form-control-label">PASSWORD</label>
	                            <input name="password" type="password" class="form-control" required >
	                        </div>
						<div class="col-lg-6 login-btm login-button">
	                         <button type="submit" class="btn btn-outline-primary">Login</button>
	                     </div>
	                    
	                    </form>
	                </div>
	            </div>
	            <div class="col-lg-3 col-md-2"></div>
	        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>


    
</body>
</html>
