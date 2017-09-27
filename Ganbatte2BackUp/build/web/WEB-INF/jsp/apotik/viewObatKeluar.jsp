<%-- 
    Document   : viewObatKeluar
    Created on : Aug 29, 2017, 12:18:34 AM
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

        <title>View Obat Keluar</title>

        <!-- Bootstrap CSS -->    
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- bootstrap theme -->
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

    </head>

    <body>
        <!-- container section start -->
        <section id="container" class="">


            <!--header start-->
            <%@include file="header.jsp" %>
            <!--header end-->

            <!--sidebar start-->
            <%@include file="sideBar.jsp" %>

            <!--sidebar end-->

            <!--main content start-->
            <section id="main-content">
                <section class="wrapper">            
                    <!--overview start-->
                    <div class="row">
                        <div class="col-lg-12">
                            <h3 class="page-header"><i class="fa fa-sign-out"></i> Data Obat Keluar</h3>
                            <ol class="breadcrumb">
                                <li><i class="fa fa-home"></i><a href="home.htm">Home</a></li>
                                <li><i class="fa fa-sign-out"></i>Data Obat Keluar</li>
                            </ol>
                        </div>
                    </div>
                    <!-- page start-->
                    <div class="row">
                        <div class="col-lg-12">
                            <section class="panel">
                                <header class="panel-heading">
                                    Data Obat Keluar
                                </header>

                                <table class="table table-striped table-advance table-hover">
                                    <tbody>
                                        <tr>
                                            <th>ID Obat Keluar</th>
                                            <th>Nama Obat</th>
                                            <th>Nama Pasien</th>
                                            <th>Harga Obat Keluar</th>
                                            <th>Tanggal Pembayaran</th>
                                            <th>Jumlah Obat Keluar</th>
                                            <th>keterangan</th>
                                            <th><i class="icon_cogs"></i> Action</th>
                                        </tr>
                                        <tr>
                                            <c:forEach var="data" items="${listObatKeluar}">
                                                <c:url value="updateStatusObat.htm" var="ubah">
                                                    <c:param name="index" value="${data.id_obat_keluar}"/>
                                                </c:url>
                                            <tr class="gradeU">
                                                <td>${data.id_obat_keluar}</td>
                                                <td>${data.nama_obat}</td>
                                                <td>${data.nama_pasien}</td>
                                                <td>${data.harga_obat_keluar}</td>
                                                <td>${data.tgl_pembayaran}</td>
                                                <td>${data.jumlah_obat_keluar}</td>
                                                <td>${data.status_obat}</td>
                                                <td><div class="btn-group">
                                                        <a class="btn btn-default" href="${ubah}"><i class="fa fa-hand-o-down"></i> Ambil</a> 
                                                    </div>
                                                </td>
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