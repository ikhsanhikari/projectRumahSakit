<%-- 
    Document   : home
    Created on : Aug 16, 2017, 8:36:12 PM
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
        <link rel="shortcut icon" href="img/favicon.png">

        <title>Home</title>

        <!-- Bootstrap CSS -->    
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- bootstrap theme -->
        <link href="css/w3.css" rel="stylesheet">
        <link href="css/bootstrap-theme.css" rel="stylesheet">
        <!--external css-->
        <!-- font icon -->
        <link href="css/elegant-icons-style.css" rel="stylesheet" />
        <link href="css/font-awesome.min.css" rel="stylesheet" />    
        <!-- full calendar css-->
        <link href="assets/fullcalendar/fullcalendar/bootstrap-fullcalendar.css" rel="stylesheet" />
        <link href="assets/fullcalendar/fullcalendar/fullcalendar.css" rel="stylesheet" />
        <!-- easy pie chart-->
        <link href="assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>
        <!-- owl carousel -->
        <link rel="stylesheet" href="css/owl.carousel.css" type="text/css">
        <link href="css/jquery-jvectormap-1.2.2.css" rel="stylesheet">
        <!-- Custom styles -->
        <link rel="stylesheet" href="css/fullcalendar.css">
        <link href="css/widgets.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <link href="css/style-responsive.css" rel="stylesheet" />
        <link href="css/xcharts.min.css" rel=" stylesheet">	
        <link href="css/jquery-ui-1.10.4.min.css" rel="stylesheet">
        <!-- =======================================================
            Theme Name: NiceAdmin
            Theme URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
            Author: BootstrapMade
            Author URL: https://bootstrapmade.com
        ======================================================= -->
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
                    <br>
                    <div class="row">
                        <div class="col-md-12">
                            <center><img src="img/homeCover.png" height="300" width="350"/></center>
                        </div>
                    </div>
                    <div class="row">   
                        <center>
                        <div class="col-md-4">
                            <div class="w3-container">
                                <h2>Data Pasien</h2>
                                <p>Lima Terdaftar Terakhir</p>
                                <button onclick="document.getElementById('id01').style.display = 'block'" class="w3-button w3-black">Buka</button>
                                <div id="id01" class="w3-modal">
                                    <div class="w3-modal-content">
                                        <header class="w3-container w3-black"> 
                                            <span onclick="document.getElementById('id01').style.display = 'none'" 
                                                  class="w3-button w3-display-topright">&times;</span>

                                            <h2>Data Pasien</h2>
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
                                                                    <c:forEach var="data" items="${listPasien}">
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
                                            <p>Pasien</p>
                                        </footer>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </center>
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
                                            <h2>Modal Header</h2>
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
                                <h2>Data Pasien</h2>
                                <p>Jumlah Pasien</p>
                                <button onclick="document.getElementById('id03').style.display = 'block'" class="w3-button w3-black">Buka</button>
                                <div id="id03" class="w3-modal">
                                    <div class="w3-modal-content">
                                        <header class="w3-container w3-black"> 
                                            <span onclick="document.getElementById('id03').style.display = 'none'" 
                                                  class="w3-button w3-display-topright">&times;</span>
                                            <h2>Jumlah Pasien</h2>
                                        </header>
                                        <div class="w3-container">
                                            <div class="row">
                                                <div class="col-lg-12">
                                                    <h1>Total Pasien <br>Yang Terdaftar<br> Berjumlah ${jumlah}</h1>
                                                </div>
                                            </div>
                                        </div>
                                        <footer class="w3-container w3-black">
                                            <p>jumlah pasien menunggu</p>
                                        </footer>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </center>
                
                
                </section>
               
            </section>
            <!--main content end-->
        </section>
        <!-- container section start -->

        <!-- javascripts -->
        <script src="js/jquery.js"></script>
        <script src="js/jquery-ui-1.10.4.min.js"></script>
        <script src="js/jquery-1.8.3.min.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.9.2.custom.min.js"></script>
        <!-- bootstrap -->
        <script src="js/bootstrap.min.js"></script>
        <!-- nice scroll -->
        <script src="js/jquery.scrollTo.min.js"></script>
        <script src="js/jquery.nicescroll.js" type="text/javascript"></script>
        <!-- charts scripts -->
        <script src="assets/jquery-knob/js/jquery.knob.js"></script>
        <script src="js/jquery.sparkline.js" type="text/javascript"></script>
        <script src="assets/jquery-easy-pie-chart/jquery.easy-pie-chart.js"></script>
        <script src="js/owl.carousel.js" ></script>
        <!-- jQuery full calendar -->
        <<script src="js/fullcalendar.min.js"></script> <!-- Full Google Calendar - Calendar -->
        <script src="assets/fullcalendar/fullcalendar/fullcalendar.js"></script>
        <!--script for this page only-->
        <script src="js/calendar-custom.js"></script>
        <script src="js/jquery.rateit.min.js"></script>
        <!-- custom select -->
        <script src="js/jquery.customSelect.min.js" ></script>
        <script src="assets/chart-master/Chart.js"></script>

        <!--custome script for all page-->
        <script src="js/scripts.js"></script>
        <!-- custom script for this page-->
        <script src="js/sparkline-chart.js"></script>
        <script src="js/easy-pie-chart.js"></script>
        <script src="js/jquery-jvectormap-1.2.2.min.js"></script>
        <script src="js/jquery-jvectormap-world-mill-en.js"></script>
        <script src="js/xcharts.min.js"></script>
        <script src="js/jquery.autosize.min.js"></script>
        <script src="js/jquery.placeholder.min.js"></script>
        <script src="js/gdp-data.js"></script>	
        <script src="js/morris.min.js"></script>
        <script src="js/sparklines.js"></script>	
        <script src="js/charts.js"></script>
        <script src="js/jquery.slimscroll.min.js"></script>
        <script>

            //knob
            $(function () {
                $(".knob").knob({
                    'draw': function () {
                        $(this.i).val(this.cv + '%')
                    }
                })
            });

            //carousel
            $(document).ready(function () {
                $("#owl-slider").owlCarousel({
                    navigation: true,
                    slideSpeed: 300,
                    paginationSpeed: 400,
                    singleItem: true

                });
            });

            //custom select box

            $(function () {
                $('select.styled').customSelect();
            });

            /* ---------- Map ---------- */
            $(function () {
                $('#map').vectorMap({
                    map: 'world_mill_en',
                    series: {
                        regions: [{
                                values: gdpData,
                                scale: ['#000', '#000'],
                                normalizeFunction: 'polynomial'
                            }]
                    },
                    backgroundColor: '#eef3f7',
                    onLabelShow: function (e, el, code) {
                        el.html(el.html() + ' (GDP - ' + gdpData[code] + ')');
                    }
                });
            });

        </script>

    </body>
</html>

