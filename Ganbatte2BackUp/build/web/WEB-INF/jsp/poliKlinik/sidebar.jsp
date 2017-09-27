<%-- 
    Document   : sidebar
    Created on : Aug 18, 2017, 11:40:18 PM
    Author     : hikari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
        <meta name="author" content="GeeksLabs">
        <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
        <link rel="shortcut icon" href="img/favicon.png">

        <title>side bar</title>

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
        <!-- =======================================================
            Theme Name: NiceAdmin
            Theme URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
            Author: BootstrapMade
            Author URL: https://bootstrapmade.com
        ======================================================= -->
    </head>
    <body>
        <aside>
            <div id="sidebar"  class="nav-collapse ">
                <!-- sidebar menu start-->
                <ul class="sidebar-menu">                
                    <li class="">
                        <a class="" href="homeKlinik.htm">
                            <i class="icon_house_alt"></i>
                            <span>Home</span>
                        </a>
                    </li>
                    <li class="">
                        <a class="" href="viewPasienKlinik.htm">
                            <i class="fa fa-user"></i>
                            <span>Lihat Data Pasien</span>
                        </a>
                    </li>
                     <li class="">
                        <a class="" href="rekam_medis_klinik.htm">
                            <i class="fa fa-hospital-o"></i>
                            <span>Rekam Medis</span>
                        </a>
                    </li>
                    <li class="sub-menu">
                        <a href="javascript:;" class="">
                            <i class="fa  fa-plus-square"></i>
                            <span>Data Jenis Klinik</span>
                            <span class="menu-arrow arrow_carrot-right"></span>
                        </a>
                        <ul class="sub">
                            <li><a class="active" href="viewJenisKlinik.htm">Lihat Jenis Klinik</a></li>
                            <li><a  href="tambah_jenis_klinik.htm">Tambah Jenis Klinik</a></li>
                        </ul>
                    </li>
                   
                    <li class="sub-menu">
                        <a href="javascript:;" class="">
                            <i class="fa   fa-pencil-square-o"></i>
                            <span>Catatan Medis</span>
                            <span class="menu-arrow arrow_carrot-right"></span>
                        </a>
                        <ul class="sub">
                            <li><a class="active" href="viewKlinik.htm">Lihat Catatan Medis</a></li>
<!--                            form_tambah_klinik.htm-->
                            <li ><a style="color: red"  href="#">Tambah Catatan Medis</a></li>
                        </ul>
                    </li>
                    <li class="">
                        <a class="" href="logOut.htm">
                            <i class="fa fa-key"></i>
                            <span>Log Out</span>
                        </a>
                    </li>


                </ul>
                <!-- sidebar menu end-->
            </div>
        </aside>
    </body>
</html>
