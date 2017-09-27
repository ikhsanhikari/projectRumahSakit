<%-- 
    Document   : home
    Created on : Sep 8, 2017, 4:49:00 PM
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

        <title>Catatan Medis</title>

        <!-- Bootstrap CSS -->    
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- bootstrap theme -->
        <link href="css/bootstrap-theme.css" rel="stylesheet">

        <link href="css/w3.css" rel="stylesheet">
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
                <br>
                    <div class="row">
                        <div class="col-md-12">
                            <center><img src="img/homeCover.png" height="300" width="350"/></center>
                        </div>
                    </div>
                <!-- page start-->
                <center>
                        <div class="col-md-4">
                        <div class="w3-container">
                            <h2>Data Pasien</h2>
                            <p>Pasien Menunggu</p>
                            <button onclick="document.getElementById('id02').style.display = 'block'" class="w3-button w3-black">Buka</button>
                            <div id="id02" class="w3-modal">
                                <div class="w3-modal-content">
                                    <header class="w3-container w3-black"> 
                                        <span onclick="document.getElementById('id02').style.display = 'none'" 
                                              class="w3-button w3-display-topright">&times;</span>
                                        <h2>Pasien Menunggu</h2>
                                    </header>
                                    <div class="w3-container">
                                        <div class="row">
                                            <div class="col-lg-12">
                                                <section class="panel">
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
                                                            </tr>
                                                            <tr>
                                                                <c:forEach var="data" items="${pasienMenunggu}">
                                                                <tr class="gradeU">
                                                                    <td>${data.id_pasien}</td>
                                                                    <td>${data.nama_pasien}</td>
                                                                    <td>${data.tgl_lahir_pasien}</td>
                                                                    <td class="center">${data.jenis_kelamin}</td>
                                                                    <td class="center">${data.alamat}</td>
                                                                    <td class="center">${data.agama}</td>
                                                                    <td class="center">${data.keterangan}</td><td>

                                                                    </td>
                                                                </tr>
                                                            </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </section>
                                            </div>
                                        </div>
                                    </div>
                                    <footer class="w3-container w3-black">
                                        <p>Paasien Menunggu</p>
                                    </footer>
                                </div>
                            </div>
                        </div>
                    </div>
                    </center>
                <center>
                        <div class="col-md-4">
                        <div class="w3-container">
                            <h2>Data Pasien Klinik Menunggu</h2>
                            <p>Klinik Menunggu</p>
                            <button onclick="document.getElementById('id03').style.display = 'block'" class="w3-button w3-black">Buka</button>
                            <div id="id03" class="w3-modal">
                                <div class="w3-modal-content">
                                    <header class="w3-container w3-black"> 
                                        <span onclick="document.getElementById('id03').style.display = 'none'" 
                                              class="w3-button w3-display-topright">&times;</span>
                                        <h2>Klinik Menunggu</h2>
                                    </header>
                                    <div class="w3-container">
                                        <div class="row">
                                            <div class="col-lg-12">
                                                <section class="panel">
                                                    <table class="table table-striped table-advance table-hover">
                                                        <tbody>
                                                            <tr>
                                                                <th>ID_Klinik</th>
                                                                <th>Nama Pasien</th>
                                                                <th>Keluhan</th>
                                                                <th>Nama Klinik</th>
                                                                <th>Penyakit</th>
                                                                <th>Keterangan</th>
                                                            </tr>
                                                            <tr>
                                                                <c:forEach var="data" items="${klinikMenunggu}">
                                                                <tr class="gradeU">
                                                                    <td>${data.id_klinik}</td>
                                                                    <td>${data.nama_pasien}</td>
                                                                    <td>${data.keluhan}</td>
                                                                    <td class="center">${data.nama_klinik}</td>
                                                                    <td class="center">${data.penyakit}</td>
                                                                    <td class="center">${data.keterangan}</td>
                                                                </tr>
                                                            </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </section>
                                            </div>
                                        </div>
                                    </div>
                                    <footer class="w3-container w3-black">
                                        <p>Paasien Menunggu</p>
                                    </footer>
                                </div>
                            </div>
                        </div>
                    </div>
                    </center>
                <center>
                        <div class="col-md-4">
                        <div class="w3-container">
                            <h2>Data Pasien Klinik SudahDi Periksa</h2>
                            <p>Klinik Sudah Di Periksa</p>
                            <button onclick="document.getElementById('id01').style.display = 'block'" class="w3-button w3-black">Buka</button>
                            <div id="id01" class="w3-modal">
                                <div class="w3-modal-content">
                                    <header class="w3-container w3-black"> 
                                        <span onclick="document.getElementById('id01').style.display = 'none'" 
                                              class="w3-button w3-display-topright">&times;</span>
                                        <h2>Klinik Sudah Di Periksa</h2>
                                    </header>
                                    <div class="w3-container">
                                        <div class="row">
                                            <div class="col-lg-12">
                                                <section class="panel">
                                                    <table class="table table-striped table-advance table-hover">
                                                        <tbody>
                                                            <tr>
                                                                <th>ID_Klinik</th>
                                                                <th>Nama Pasien</th>
                                                                <th>Keluhan</th>
                                                                <th>Nama Klinik</th>
                                                                <th>Penyakit</th>
                                                                <th>Keterangan</th>
                                                            </tr>
                                                            <tr>
                                                                <c:forEach var="data" items="${klinikSudahDiPeriksa}">
                                                                <tr class="gradeU">
                                                                    <td>${data.id_klinik}</td>
                                                                    <td>${data.nama_pasien}</td>
                                                                    <td>${data.keluhan}</td>
                                                                    <td class="center">${data.nama_klinik}</td>
                                                                    <td class="center">${data.penyakit}</td>
                                                                    <td class="center">${data.keterangan}</td>
                                                                </tr>
                                                            </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </section>
                                            </div>
                                        </div>
                                    </div>
                                    <footer class="w3-container w3-black">
                                        <p>Paasien Sudah Di Periksa</p>
                                    </footer>
                                </div>
                            </div>
                        </div>
                    </div>
                    </center>

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
