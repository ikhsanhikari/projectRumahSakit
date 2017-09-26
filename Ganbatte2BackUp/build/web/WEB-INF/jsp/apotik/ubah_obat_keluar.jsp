<%-- 
    Document   : ubah_obat_keluar
    Created on : Aug 29, 2017, 2:05:28 PM
    Author     : hikari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script> 
        <link rel="stylesheet" type="text/css" media="screen" href="js/validation/css/validationEngine.jquery.css">
        <link rel="stylesheet" type="text/css" media="screen" href="css/datepicker.css">
        <link rel="stylesheet" type="text/css" media="screen" href="js/validation/css/tabel.css">
        <script type="text/javascript" src="js/validation/jquery.validationEngine-en.js"></script>
        <script type="text/javascript" src="jsbootstrap-datepicker.js.js"></script>
        <script type="text/javascript" src="js/validation/jquery.validationEngine.js"></script>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
        <meta name="author" content="GeeksLabs">
        <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
        <link rel="shortcut icon" href="img/favicon.png">

        <title>Data Obat Keluar</title>

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
                            <h3 class="page-header"><i class="fa fa-sign-out"></i> Data Obat Keluar</h3>
                            <ol class="breadcrumb">
                                <li><i class="fa fa-home"></i><a href="home.htm">Home</a></li>
                                <li><i class="fa fa-sign-out"></i>Data Obat Keluar</li>
                            </ol>
                        </div>
                    </div>
                    <!-- Form validations --> 
                    <div class="row">
                        <div class="col-lg-12">
                            <section class="panel">
                                <header class="panel-heading">
                                    Data Obat
                                </header>
                                <div class="panel-body">
                                    <div class="form">
                                        <form:form modelAttribute="obatKeluarDto" class="form-validate form-horizontal "  method="POST" id="formData" action="updateObatKeluar.htm">
                                            <form:hidden path="id_obat_keluar"/>
                                            <div class="form-group ">
                                                <label class="control-label col-lg-2">Id Obat <span class="required">*</span></label>
                                                <div class="col-lg-10">
                                                    <form:select style="width:300px;height:30px"  path="id_obat" class="form-control" id="nama" name="fullname" required="required" type="text" >
                                                        <option  selected="true" value="${obatKeluarDto.id_obat}">${obatKeluarDto.id_obat}</option>
                                                        <c:forEach var="data" items="${listObat}">
                                                            <option value="${data.id_obat}">${data.nama_obat}</option>
                                                        </c:forEach>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="form-group ">
                                                <label class="control-label col-lg-2">id_pasien<span class="required">*</span></label>
                                                <div class="col-lg-10">
                                                    <form:select style="width:300px;height:30px"  path="id_pasien" class="form-control"  required="required"  >
                                                        <option  selected="true" value="${obatKeluarDto.id_pasien}">${obatKeluarDto.id_pasien}</option>
                                                        <c:forEach var="data" items="${listPasien}">
                                                            <option value="${data.id_pasien}">${data.nama_pasien}</option>
                                                        </c:forEach>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="form-group ">
                                                <label class="control-label col-lg-2">Tanggal obat keluar <span class="required">*</span></label>
                                                <div class="col-lg-10">
                                                    <form:input style="width:300px;height:30px"  path="tgl_obat_keluar" class="form-control" id="nama" name="fullname" required="required" type="text" />
                                                </div>
                                            </div> 
                                            <div class="form-group ">
                                                <label class="control-label col-lg-2">Tanggal Pembayaran  Obat <span class="required">*</span></label>
                                                <div class="col-lg-10">
                                                    <form:input style="width:300px;height:30px"  path="tgl_pembayaran" class="form-control" id="nama" name="fullname" required="required" type="text" />
                                                </div>
                                            </div>
                                            <div class="form-group ">
                                                <label class="control-label col-lg-2">Jumlah Obat Keluar <span class="required">*</span></label>
                                                <div class="col-lg-10">
                                                    <form:input style="width:300px;height:30px"  path="jumlah_obat_keluar" class="form-control" id="nama" name="fullname" required="required" type="text" />
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
        <!-- nice scroll -->
        <script src="js/jquery.scrollTo.min.js"></script>
        <script src="js/jquery.nicescroll.js" type="text/javascript"></script>
        <!-- jquery validate js -->
        <script type="text/javascript" src="js/jquery.validate.min.js"></script>

        <!-- custom form validation script for this page-->
        <script src="js/form-validation-script.js"></script>
        <!--custome script for all page-->
        <script src="js/scripts.js"></script>    
        <script>
            $(document).ready(function () {
                $("#ttl").datepicker("dd/mm/yyyy");
            });
        </script>

    </body>
</html>
