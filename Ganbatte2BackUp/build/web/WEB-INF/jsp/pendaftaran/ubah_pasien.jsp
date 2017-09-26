<%-- 
    Document   : ubah_pasien
    Created on : Aug 17, 2017, 6:17:48 AM
    Author     : hikari
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
    <meta name="author" content="GeeksLabs">
    <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
    <link rel="shortcut icon" href="img/favicon.png">

    <title>Ubah Data Pasien</title>

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
      
    <%@include file="sideBar.jsp" %>
      <!--sidebar end-->
      

      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
		  <div class="row">
				<div class="col-lg-12">
					<h3 class="page-header"><i class="fa fa-files-o"></i> Ubah Pasien</h3>
					<ol class="breadcrumb">
						<li><i class="fa fa-home"></i><a href="index.htm">Home</a></li>
						<li><i class="icon_document_alt"></i>Pasien</li>
					</ol>
				</div>
			</div>
              <!-- Form validations --> 
              <div class="row">
                  <div class="col-lg-12">
                      <section class="panel">
                          <header class="panel-heading">
                             Data Pasien
                          </header>
                          <div class="panel-body">
                              <div class="form">
                                  <form:form modelAttribute="pasienDto" class="form-validate form-horizontal "  method="POST" action="ubahPasien.htm">
                                      <form:hidden path="id_pasien"/>
                                      <div class="form-group ">
                                          <label class="control-label col-lg-2">Nama Lengkap <span class="required">*</span></label>
                                          <div class="col-lg-10">
                                              <form:input style="width:300px;height:30px" required="required" path="nama_pasien" class=" form-control" id="fullname" name="fullname" type="text" />
                                          </div>
                                      </div>
                                      <div class="form-group ">
                                          <label  class="control-label col-lg-2">Tanggal Lahir <span class="required">*</span></label>
                                          <div class="col-lg-10">
                                              <form:input path="tgl_lahir_pasien" style="width:300px;height:30px" required="required" class="form-control"   />
                                          </div>
                                      </div>
                                      <div class="form-group ">
                                          <label for="username" required="required" class="control-label col-lg-2">Jenis Kelamin <span class="required">*</span></label>
                                          <div class="col-lg-10">
                                              <div class="radio">
                                              <label>
                                                  <form:radiobutton required="required" path="jenis_kelamin"  name="optionsRadios" id="optionsRadios1" value="Laki - Laki" />
                                                  Laki - Laki
                                              </label>
                                          </div>
                                          <div class="radio">
                                              <label>
                                                  <form:radiobutton path="jenis_kelamin" required="required"  name="optionsRadios" id="optionsRadios1" value="Perempuan"/>
                                                  Perempuan
                                              </label>
                                          </div>
                                          </div>
                                      </div>
                                      <div class="form-group ">
                                          <label  class="control-label col-lg-2">Alamat <span class="required">*</span></label>
                                          <div class="col-lg-10">
                                             <form:textarea path="alamat" rows="4" class="form-control " style="width:300px" requred="true" required="required" />
                                          </div>
                                      </div>
                                      <div class="form-group ">
                                          <label class="control-label col-lg-2" for="inputSuccess">Agama</label>
                                      <div class="col-lg-10">
                                            <form:select path="agama" style="width:300px;height:30px" class="form-control m-bot15" required="required">
                                              <option selected="true" disabled="ture">-agama-</option>
                                              <option>Islam</option>
                                              <option>Kristen</option>
                                              <option>Khatolik</option>
                                              <option>Hindu</option>
                                              <option>Budha</option>
                                          
                                          </form:select>

                                      </div>
                                      </div>
                                      <div class="form-group ">
                                          <label for="email" class="control-label col-lg-2">Keterangan <span class="required">*</span></label>
                                          <div class="col-lg-10">
                                              <form:input path="keterangan" style="width:300px;height:30px" required="required" class="form-control " id="email" name="email"  />
                                          </div>
                                      </div>
                                      <div class="form-group">
                                          <div class="col-lg-offset-2 col-lg-10">
                                              <input class="btn btn-primary" type="submit" value="ubah"/>
                                          </div>
                                      </div>
                                  </form:form>
                              </div>
                          </div>
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
    <!-- nice scroll -->
    <script src="js/jquery.scrollTo.min.js"></script>
    <script src="js/jquery.nicescroll.js" type="text/javascript"></script>
    <!-- jquery validate js -->
    <script type="text/javascript" src="js/jquery.validate.min.js"></script>

    <!-- custom form validation script for this page-->
    <script src="js/form-validation-script.js"></script>
    <!--custome script for all page-->
    <script src="js/scripts.js"></script>    


  </body>
</html>
