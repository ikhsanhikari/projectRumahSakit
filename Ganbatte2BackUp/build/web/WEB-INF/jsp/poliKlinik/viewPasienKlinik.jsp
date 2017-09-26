<%-- 
    Document   : viewPasienKlinik
    Created on : Sep 2, 2017, 5:13:39 AM
    Author     : hikari
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
    <meta name="author" content="GeeksLabs">
    <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
    <link rel="shortcut icon" href="img/favicon.png">

    <title>Lihat Data Pasien</title>

    <!-- Bootstrap CSS -->    
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- bootstrap theme -->
    <link href="css/bootstrap-theme.css" rel="stylesheet">
    <!--external css-->
    <!-- font icon -->
    <link href="css/elegant-icons-style.css" rel="stylesheet" />
    <link href="css/font-awesome.min.css" rel="stylesheet" />
    <!-- Custom styles -->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet" />

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 -->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
      <script src="js/lte-ie7.js"></script>
    <![endif]-->
  </head>

  <body>
  <!-- container section start -->
  <section id="container" class="">
      <%@include file="header.jsp" %>

     <!--sidebar start-->
      
     <%@include file="sidebar.jsp" %>
      <!--sidebar end-->
      

      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
		  <div class="row">
				<div class="col-lg-12">
					<h3 class="page-header"><i class="fa fa-user"></i> Data Pasien</h3>
					<ol class="breadcrumb">
						<li><i class="fa fa-home"></i><a href="index.htm">Home</a></li>
						<li><i class="fa fa-user"></i>Pasien</li>
					</ol>
				</div>
			</div>
              <!-- page start-->
        <div class="row">
                  <div class="col-lg-12">
                      <section class="panel">
                          <header class="panel-heading">
                              Data Pasien
                          </header>
                          
                          <table class="table table-striped table-advance table-hover">
                           <tbody>
                              <tr>
                                    <th>ID_Pasien</th>
                                    <th>Nama Pasien</th>
                                    <th>Tanggal Lahir</th>
                                    <th>Jenis Kelamin</th>
                                    <th>Alamat</th>
                                    <th>Agama</th>
                                    <th>Keterangan</th>
                                    <th><i class="icon_cogs"></i> Action</th>
                              </tr>
                              <tr>
                                 <c:forEach var="data" items="${listPasien}">
                                     <c:url value="rawatPasien.htm" var="rawat">
                                         <c:param name="index" value="${data.id_pasien}"/>
                                     </c:url>
                                    <tr class="gradeU">
                                        <td>${data.id_pasien}</td>
                                        <td>${data.nama_pasien}</td>
                                        <td>${data.tgl_lahir_pasien}</td>
                                        <td class="center">${data.jenis_kelamin}</td>
                                        <td class="center">${data.alamat}</td>
                                        <td class="center">${data.agama}</td>
                                        <td class="center">${data.keterangan}</td>
                                        <td><div class="btn-group">
                                            <a class="btn btn-success" href="${rawat}"><i class="fa fa-plus-circle"></i></a>
                                            <a class="btn btn-danger" href="${hapus}"><i class="icon_close_alt2"></i></a>
                                        </div>  
                              </tr>
                              </c:forEach>
                           </tbody>
                        </table>
                      </section>
                  </div>
              </div>
              <!-- page end-->
          </section>
      </section>
      <!--main content end-->
     
  </section>
  <!-- container section end -->
    <!-- javascripts -->
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <!-- nicescroll -->
    <script src="js/jquery.scrollTo.min.js"></script>
    <script src="js/jquery.nicescroll.js" type="text/javascript"></script>
    <!--custome script for all page-->
    <script src="js/scripts.js"></script>


  </body>
</html>
