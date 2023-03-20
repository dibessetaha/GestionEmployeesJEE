<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">

  <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  <link rel="stylesheet" href="../../style/SideNav.css">
    <link rel="stylesheet" href="http://localhost:8080/webproject/css/sidebarrh.css">
  <title><% if(request.getServletPath().equals("/views/admin/Employees.jsp")){%>Employees<%}%></title>
</head>
<body>
<div class='dashboard'>
  <div class="dashboard-nav">
    <header><a href="#!" class="menu-toggle"><i class="fas fa-bars"></i></a><a href="#"
                                                                               class="brand-logo"><i
            class="fas fa-anchor"></i> <span>BRAND</span></a></header>
    <nav class="dashboard-nav-list"><a
            href="rhdash" class="dashboard-nav-item "><i class="fas fa-tachometer-alt"></i> &ensp;dashboard
    </a>
      <div class='dashboard-nav-dropdown'><a href="#" class="dashboard-nav-item dashboard-nav-dropdown-toggle"><i
              class="fas fa-users"></i> &ensp;Employees </a>
        <div class='dashboard-nav-dropdown-menu'><a href="rhusers" class="dashboard-nav-dropdown-item ">Sans Contrat </a>
        <a href="aveccontrat" class="dashboard-nav-dropdown-item ">Avec contrat </a>
      </div>
      <div class='dashboard-nav-dropdown'><a href="#!" class="dashboard-nav-item dashboard-nav-dropdown-toggle"><i class="fa-solid fa-list-check"></i>&ensp;Congees </a>
        <div class='dashboard-nav-dropdown-menu'>
        <a href="congeenattente" class="dashboard-nav-dropdown-item active">Conges en attente</a>
      </div>

      <div class='dashboard-nav-dropdown'><a href="#!" class="dashboard-nav-item dashboard-nav-dropdown-toggle"><i class="fa-solid fa-file-signature"></i> &ensp;Contrat </a>
        <div class='dashboard-nav-dropdown-menu'><a
                href="contratencours" class="dashboard-nav-dropdown-item ">Contrat En cours </a></div>
      </div>

      <div class="nav-item-divider"></div>
      <a
              href="logout" class="dashboard-nav-item"><i class="fas fa-sign-out-alt"></i> Logout </a>
    </nav>
  </div>
  <div class='dashboard-app'>
    <header class='dashboard-toolbar'>
      <a href="#!" class="menu-toggle"><i class="fas fa-bars"></i></a>
    </header>
    <%--<%=request.getServletPath()%>--%>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/js/all.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
	<script src="/webproject/js/script.js"></script>
</body>
</html>
