<%-- 
    Document   : updateKlinik
    Created on : Aug 20, 2017, 4:46:55 PM
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

        <title>Catatan Medis</title>

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
                            <h3 class="page-header"><i class="fa fa-pencil-square-o"></i> Catatan Medis</h3>
                            <ol class="breadcrumb">
                                <li><i class="fa fa-home"></i><a href="index.htm">Home</a></li>
                                <li><i class="fa fa-pencil-square-o"></i>Catatan Medis</li>
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
                                        <form:form modelAttribute="klinikDto" class="form-validate form-horizontal "  method="POST" action="ubahDataKlinik.htm">
                                            <form:hidden path="id_klinik"/>
                                            <div class="form-group ">
                                                <label class="control-label col-lg-2" for="inputSuccess">Nama Pasien</label>
                                                <div class="col-lg-10">
                                                    <form:select path="id_pasien" class="form-control m-bot15" style="width:300px" required="required">
                                                        <option selected="true" disabled="ture">-pasien-</option>
                                                        <c:forEach var="data" items="${listPasien}">    
                                                            <option value="${data.id_pasien}">${data.nama_pasien}</option>
                                                        </c:forEach>

                                                    </form:select>

                                                </div>
                                            </div>
                                             <div class="form-group ">
                                                <label class="control-label col-lg-2" for="inputSuccess">Nama Klinik</label>
                                                <div class="col-lg-10">
                                                    <form:select path="jenis_klinik" class="form-control m-bot15" style="width:300px" required="required">
                                                        <option selected="true" disabled="ture">-klinik-</option>
                                                        <c:forEach var="data" items="${listJenisKlinik}">    
                                                            <option value="${data.id_jenis_klinik}">${data.nama_klinik}</option>
                                                        </c:forEach>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="form-group ">
                                                <label class="control-label col-lg-2">Penyakit <span class="required">*</span></label>
                                                <div class="col-lg-10">
                                                    <form:input required="required" style="width:300px;height:30px;border-radius:0px;" path="penyakit" class=" form-control" id="fullname" name="fullname" type="text" />
                                                </div>
                                            </div>
                                            <div class="form-group ">
                                                <label class="control-label col-lg-2">Catatan Medis Klinik <span class="required">*</span></label>
                                                <div class="col-lg-10">
                                                    <form:input required="required" style="width:300px;height:30px;border-radius:0px;" path="catatan_medis_klinik" class=" form-control" id="fullname" name="fullname" type="text" />
                                                </div>
                                            </div>
                                            <div class="form-group ">
                                                <label class="control-label col-lg-2">Keluhan <span class="required">*</span></label>
                                                <div class="col-lg-10">
                                                    <form:input required="required" style="width:300px;height:30px;border-radius:0px;" path="keluhan" class=" form-control" id="fullname" name="fullname" type="text" />
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-lg-offset-2 col-lg-10">
                                                    <input class="btn btn-primary" type="submit"/>
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