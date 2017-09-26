<%-- 
    Document   : formPilihan
    Created on : Sep 15, 2017, 7:22:04 AM
    Author     : sou
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
        <link href="css/w3.css" rel="stylesheet">
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
                                Data Pasien ${listKlinik.id_pasien}
                            </header>
                            <div class="col-lg-6 panel">
                                <table cellpadding="10px">
                                    <tr>
                                        <td>Nama Pasien</td>
                                        <td>:</td>
                                        <td>${listKlinik.nama_pasien}</td>
                                    </tr>
                                    <tr>
                                        <td>Jenis Kelamin</td>
                                        <td>:</td>
                                        <td>${listKlinik.jenis_kelamin}</td>
                                    </tr>
                                    <tr>
                                        <td>Tanggal Lahir</td>
                                        <td>:</td>
                                        <td>${listKlinik.tgl_lahir_pasien}</td>
                                    </tr>

                                </table>
                            </div>
                            <div class="col-lg-6 panel">
                                <table cellpadding="10px">

                                    <tr>
                                        <td>Alamat</td>
                                        <td>:</td>
                                        <td>${listKlinik.alamat}</td>
                                    </tr>
                                    <tr>
                                        <td>Agama</td>
                                        <td>:</td>
                                        <td>${listKlinik.agama}</td>
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
                                Data Pasien
                            </header>

                            <table class="table table-striped table-advance table-hover">
                                <tbody>
                                    <tr>
                                        <th>ID_Klinik</th>
                                        <th>Nama Pasien</th>
                                        <th>Keluhan</th>
                                        <th>Tindakan</th>
                                        <th>Jenis Klinik</th>
                                        <th>Penyakit</th>
                                        <th>Catatan Medis</th>
                                        <th>Biaya</th>
                                        <th>Keterangan</th>
                                    </tr>
                                    <tr>
                                    <tr class="gradeU">
                                        <td>${listKlinik.id_klinik}</td>
                                        <td>${listKlinik.nama_pasien}</td>
                                        <td>${listKlinik.keluhan}</td>
                                        <td>${listKlinik.tindakan}</td>
                                        <td class="center">${listKlinik.nama_klinik}</td>
                                        <td class="center">${listKlinik.penyakit}</td>
                                        <td class="center">${listKlinik.catatan_medis_klinik}</td>
                                        <td>${listKlinik.biaya}</td>
                                        <td>${listKlinik.keterangan}</td>

                                </tbody>
                            </table>
                        </section>
                    </div>
                </div>
                <c:url value="formTambahKeluhan.htm" var="tambahKeluhan">
                    <c:param name="index" value="${listKlinik.id_klinik}"/>
                </c:url>
                <c:url value="formTambahTindakan.htm" var="tambahTindakan">
                    <c:param name="index" value="${listKlinik.id_klinik}"/>
                </c:url>  
                <c:url value="obatKeluarPasien.htm" var="obatKeluar">
                    <c:param name="index" value="${listKlinik.id_klinik}"/>
                </c:url>                        
                <div class="row">
                    <center><div class="btn-group">
                            <a class="btn btn-default " href="${tambahKeluhan}"><i class="fa fa-ambulance"></i> keluhan</a>
                            <a class="btn btn-default " href="${tambahTindakan}"><i class="fa fa-pencil-square-o"></i> Tindakan</a>
                            <a class="btn btn-default " href="${obatKeluar}"><i class="fa fa-medkit"></i> Obat</a>
                        </div>
                    </center>
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