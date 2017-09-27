<%-- 
    Document   : sideBar
    Created on : Aug 22, 2017, 1:51:57 PM
    Author     : hikari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <aside>
            <div id="sidebar"  class="nav-collapse ">
                <!-- sidebar menu start-->
                <ul class="sidebar-menu">                
                    <li class="">
                        <a class="" href="homeRawatInap.htm">
                            <i class="icon_house_alt"></i>
                            <span>Home</span>
                        </a>
                    </li>
                 
                    <li class="">
                        <a class="" href="rekam_medis_rawat_inap.htm">
                            <i class="fa fa-hospital-o"></i>
                            <span>Data Rekam Medis</span>
                        </a>
                    </li>
                    <li class="">
                        <a class="" href="viewRuanganPasien.htm">
                            <i class="fa fa-volume-up"></i>
                            <span>Info Lokasi Pasien</span>
                        </a>
                    </li>
                    <li class="sub-menu">
                        <a href="javascript:;" class="">
                            <i class="fa fa-university"></i>
                            <span>Data Ruangan</span>
                            <span class="menu-arrow arrow_carrot-right"></span>
                        </a>
                        <ul class="sub">
                            <li><a class="active" href="viewRuangan.htm">Lihat Data Ruangan</a></li>
                            <li><a  href="formTambahRuangan.htm">Tambah Data Ruangan</a></li>
                        </ul>
                    </li>
                    <li class="sub-menu">
                        <a href="javascript:;" class="">
                            <i class="fa  fa-sort-numeric-asc"></i>
                            <span>Nomor Ruangan</span>
                            <span class="menu-arrow arrow_carrot-right"></span>
                        </a>
                        <ul class="sub">
                            <li><a class="active" href="viewNomorRuangan.htm">Lihat Nomor Ruangan</a></li>
                            <li><a  href="formTambahNomorRuangan.htm">Tambah Nomor</a></li>
                        </ul>
                    </li>
                    <li class="sub-menu">
                        <a href="javascript:;" class="">
                            <i class="fa fa-stethoscope"></i>
                            <span>Rawat Inap</span>
                            <span class="menu-arrow arrow_carrot-right"></span>
                        </a>
                        <ul class="sub">
                            <li><a class="active" href="viewRawatInap.htm">Lihat Rawat Inap</a></li>
                            <li><a  href="formTambahRawatInap.htm">Tambah Rawat Inap</a></li>
                        </ul>
                    </li>
                    
                    <li class="">
                        <a class="" href="logOut.htm">
                            <i class="fa  fa-key"></i>
                            <span>Log Out</span>
                        </a>
                    </li>


                </ul>
                <!-- sidebar menu end-->
            </div>
        </aside>
    </body>
</html>
