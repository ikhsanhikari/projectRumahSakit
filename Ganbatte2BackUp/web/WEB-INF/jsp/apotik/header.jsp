<%-- 
    Document   : header
    Created on : Aug 23, 2017, 4:34:47 PM
    Author     : hikari
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <header class="header dark-bg">
            <div class="toggle-nav">
                <div class="icon-reorder tooltips" data-original-title="Toggle Navigation" data-placement="bottom"><i class="icon_menu"></i></div>
            </div>

            <!--logo start-->
            <a href="homeObat.htm" style="padding-bottom: 13px"  class="logo"><img src="img/14.png" height="40"/></a>
            <!--logo end-->

    

            <div class="top-nav notification-row">  
                
                <!-- notificatoin dropdown start-->
                <ul class="nav pull-right top-menu">
                    <li id="alert_notificatoin_bar" class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">

                            <i class="icon-bell-l"></i>
                            <c:if test="${jumlahObatBelumDiambil>0}">
                                <span class="badge bg-important">${jumlahObatBelumDiambil}</span>
                            </c:if>
                                
                            
                        </a>
                        <ul class="dropdown-menu extended notification">
                            <div class="notify-arrow notify-arrow-blue"></div>
                            <li>
                                <p class="blue">Anda punya ${jumlahObatBelumDiambil} obat belum diambil</p>
                            </li>
                            <c:forEach var="data" items="${obatBelumDiambil}">
                            <li>
                                <a href="viewObatKeluar.htm">
                                    <span class="label label-primary"><i class="icon_profile"></i></span> 
                                        ${data.nama_pasien} (${data.nama_obat} (${data.jumlah_obat_keluar}))
                                    <span class="small italic pull-right">${data.id_obat_keluar}</span>
                                </a>
                            </li> 
                            </c:forEach>
                            <li>
                                <a href="#">See all notifications</a>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="profile-ava">
                                <img alt="" src="img/avatar1_small.jpg">
                            </span>
                            <span class="username">${hikari}</span>
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu extended logout">
                            <div class="log-arrow-up"></div>
                            <li class="eborder-top">
                                <a href="#"><i class="icon_profile"></i> My Profile</a>
                            </li>
                         
                            <li>
                                <a href="logOut.htm"><i class="icon_key_alt"></i> Log Out</a>
                            </li>
                         </ul>
                    </li>
                    <!-- user login dropdown end -->
                </ul>
                <!-- notificatoin dropdown end-->
            </div>
      </header> 
    </body>
</html>
