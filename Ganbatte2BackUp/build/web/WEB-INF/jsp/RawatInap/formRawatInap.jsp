<%-- 
    Document   : formRawatInap
    Created on : Sep 12, 2017, 2:17:57 PM
    Author     : hikari
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<!DOCTYPE html>
<html lang="en">
  <head>
   
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
      
     <%@include file="sideBar.jsp" %>
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
                              Data Pasien ${index}
                          </header>
                          <div class="col-lg-6 panel">
                              <table cellpadding="10px">
                              <tr>
                                  <td>Nama Pasien</td>
                                  <td>:</td>
                                  <td>${data.nama_pasien}</td>
                              </tr>
                              <tr>
                                  <td>Jenis Kelamin</td>
                                  <td>:</td>
                                  <td>${data.jenis_kelamin}</td>
                              </tr>
                              <tr>
                                  <td>Tanggal Lahir</td>
                                  <td>:</td>
                                  <td>${data.tgl_lahir_pasien}</td>
                              </tr>
                              
                          </table>
                          </div>
                              <div class="col-lg-6 panel">
                                  <table cellpadding="10px">
                         
                              <tr>
                                  <td>Alamat</td>
                                  <td>:</td>
                                  <td>${data.alamat}</td>
                              </tr>
                              <tr>
                                  <td>Agama</td>
                                  <td>:</td>
                                  <td>${data.agama}</td>
                              </tr>
                              <tr>
                                  <td>Keterangan</td>
                                  <td>:</td>
                                  <td>${data.keterangan}</td>
                              </tr>
                          </table>
                              </div>
                         
                      </section>
                  </div>
              </div>
                <div class="row">
                        <div class="col-lg-12">
                            <section class="panel">
                                <header class="panel-heading">
                                    Data Rawat Inap
                                </header>
                                <div class="panel-body">
                                    <div class="form">
                                        ${warn}
                                        <form:form modelAttribute="rawatInapDto" class="form-validate form-horizontal "  method="POST" id="formData" action="saveRawatInapPasien.htm">
                                            <form:hidden path="tgl_keluar" value="-"/>
                                            <form:hidden path="id_pasien" value="${data.id_pasien}"/>
                                            <div class="form-group ">
                                                <label class="control-label col-lg-2">Nomor Ruangan<span class="required">*</span></label>
                                                <div class="col-lg-10">
                                                    <form:select style="width:300px;height:30px"  path="id_nomor_ruangan" class="validate validate[required] form-control" id="nama" required="required" type="text" >
                                                        <option disabled="true" selected="true">pilih nomor ruangan</option>
                                                        <c:forEach var="data" items="${listNomorRuangan}">
                                                            <c:if test="${data.status_ruangan.equals('kosong')}">
                                                                <option value="${data.id_nomor_ruangan}">${data.nomor_ruangan} status (${data.status_ruangan})</option>
                                                            </c:if>
                                                        </c:forEach>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="form-group ">
                                                <label class="control-label col-lg-2">Catatan Medis <span class="required">*</span></label>
                                                <div class="col-lg-10">
                                                    <form:input style="width:300px;height:30px"  path="catatan_medis_rawat_inap" class="validate validate[required] form-control"  required="required" type="text" />
                                                </div>
                                            </div>
                                                <div class="form-group">
                                                <div class="col-lg-offset-2 col-lg-10">
                                                    <input class="btn btn-primary" type="submit" value="tambah"/>
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
    <!-- nicescroll -->
    <script src="js/jquery.scrollTo.min.js"></script>
    <script src="js/jquery.nicescroll.js" type="text/javascript"></script>
    <!--custome script for all page-->
    <script src="js/scripts.js"></script>


  </body>
</html>
