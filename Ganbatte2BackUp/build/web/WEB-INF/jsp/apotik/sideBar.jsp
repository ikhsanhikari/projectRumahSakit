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
                        <a class="" href="homeObat.htm">
                            <i class="icon_house_alt"></i>
                            <span>Home</span>
                        </a>
                    </li>
                 
                    <li class="sub-menu">
                        <a href="javascript:;" class="">
                            <i class="fa  fa-medkit"></i>
                            <span>Data Obat</span>
                            <span class="menu-arrow arrow_carrot-right"></span>
                        </a>
                        <ul class="sub">
                            <li><a class="active" href="viewObat.htm">Lihat Data Obat</a></li>
                            <li><a  href="formTambahObat.htm">Tambah Data Obat</a></li>
                        </ul>
                    </li>
                    <li class="sub-menu">
                        <a href="javascript:;" class="">
                            <i class="fa  fa-sign-out"></i>
                            <span>Obat Keluar</span>
                            <span class="menu-arrow arrow_carrot-right"></span>
                        </a>
                        <ul class="sub">
                            <li><a class="active" href="viewObatKeluar.htm">Lihat Obat Keluar</a></li>
                            <li><a  href="formTambahObatKeluar.htm">Tambah Obat Keluar</a></li>
                        </ul>
                    </li>
                    <li class="sub-menu">
                        <a href="javascript:;" class="">
                            <i class="fa  fa-sign-in"></i>
                            <span>Obat Masuk</span>
                            <span class="menu-arrow arrow_carrot-right"></span>
                        </a>
                        <ul class="sub">
                            <li><a class="active" href="viewObatMasuk.htm">Lihat Obat Masuk</a></li>
                            <li><a  href="formTambahObatMasuk.htm">Tambah Obat Masuk</a></li>
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
