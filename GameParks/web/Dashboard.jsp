<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Game Park</title>
    <!-- Meta tags -->
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />    
    <!-- Fonts and icons     -->
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
    <!-- Material Kit CSS -->
    <link href="css/stylesCentral.css" rel="stylesheet"/>
    <link rel="stylesheet" href="css/styles.css">
    <!-- API TIEMPO-->
    <script type="text/javascript" src="https://rss2json.com/gfapi.js"></script>
</head>

<body>
    
    <%
    HttpSession sesion = request.getSession();    
    String usu = (String) request.getSession().getAttribute("usuario");
    if(usu == null){
        request.getSession().setAttribute("resLog", "El Usuario y Contraseña no fueron cargados o estan vacíos.!");
        response.sendRedirect("ResLogRes.jsp");
    }else{
    %>

    <div class="wrapper ">

      <header>

          <!--INICIA MENU LATERAL IZQUIERDO-->
          <div class="sidebar" data-color="green" data-background-color="white">
          
            <div class="logo row d-flex justify-content-center align-items-center pb-4">
              <img src="img/logos.png" width="30%" alt="">
              <a href="" class="simple-text logo-normal">Game Park</a>
            </div>

            <div class="sidebar-wrapper">

                <!--INICIO OPCIONES-->
                <ul class="nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="Dashboard.jsp">
                          <i class="material-icons">dashboard</i>
                          <p>Noticias en General</p>
                        </a>
                    </li> 
                    <li class="nav-item ">
                        <a class="nav-link" href="Games.jsp">
                          <i class="material-icons">power_settings_new</i>
                          <p>Nuevo Juego y Horario</p>
                        </a>
                    </li>
                    <li class="nav-item ">
                        <a class="nav-link" href="Input.jsp">
                          <i class="material-icons">input</i>
                          <p>Nueva Entrada y Cliente</p>
                        </a>
                    </li>
                    <li class="nav-item ">
                        <a class="nav-link" href="Changes.jsp">
                          <i class="material-icons">cached</i>
                          <p>Modificaciones</p>
                        </a>
                    </li>
                    <li class="nav-item ">
                        <a class="nav-link" href="Delete.jsp">
                          <i class="material-icons">delete</i>
                          <p>Eliminar Objeto</p>
                        </a>
                    </li>                     
                    <li class="nav-item ">
                        <a class="nav-link" href="List.jsp">
                          <i class="material-icons">list</i>
                          <p>Listados</p>
                        </a>
                    </li> 
                    <li class="nav-item ">
                        <a class="nav-link" href="Reports.jsp">
                          <i class="material-icons">content_paste</i>
                          <p>Informes</p>
                        </a>
                    </li>                          
                </ul>
                <!--FIN DE OPCIONES-->

                <!--Inicio del Footer-->
                <section class="col-12 s12 m6 institucional">
                    <div class="col-12 s12 m6 text-muted text-center text-small">
                        <div class="datos">
                            <p class="">&copy; 2020 Game Park</p>
                            <ul class="list-inline">
                                <li class="list-inline-item"><a href="GameParkNosotros.jsp">Nosotros</a></li>
                                <li class="list-inline-item"><a href="GameParkManual.jsp">Manual</a></li>
                                <li class="list-inline-item"><a href="GameParkSoporte.jsp">Soporte</a></li>
                            </ul>
                            <ul>
                                <li class=" list-inline-item"><img src="logos/smallLogos/facebook.png" alt=""></li>
                                <li class=" list-inline-item"><img src="logos/smallLogos/instagram.png" alt=""></li>         
                                <li class=" list-inline-item"><img src="logos/smallLogos/twiter.png" alt=""></li>
                                <li class=" list-inline-item"><img src="logos/smallLogos/linkedin.png" alt=""></li>
                                <li class=" list-inline-item"><img src="logos/smallLogos/whatsapp.png" alt=""></li>
                                <li class=" list-inline-item"><img src="logos/smallLogos/youtube.png" alt=""></li>
                            </ul>            
                        </div>
                    </div>
                </section>
                <!--Fin del Footer-->

            </div>          

          </div>
          <!--FIN MENU LATERAL IZQUIERDO-->
      </header>

      <!--INICIA PANEL DERECHO COMPLETO-->
      <div class="main-panel">

            <!--INICIA MENU SUPERIOR-->
            <nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top ">
              <div class="container-fluid">          
                <div class="collapse navbar-collapse justify-content-end">
                  <ul class="navbar-nav">
                    <li>
                      <button class="btn btn-light" id="btnInicio" onclick="formColorsInicio(btnInicio)" data-toggle="tooltip" data-placement="top" title="Más Brillo"><img src="icons/inicio.png" alt=""></button>
                    </li>
                    <li>
                      <button class="btn btn-dark" id="btnSunrise" onclick="formColorsSunrise(btnSunrise)" data-toggle="tooltip" data-placement="top" title="Más cálido sin Brillo"><img src="icons/amanecer.png" alt=""></button>
                    </li>
                    <li>
                      <button class="btn btn-dark" id="btnDays" onclick="formColorsDay(btnDays)" data-toggle="tooltip" data-placement="top" title="Un Gris tranquilo"><img src="icons/dom.png" alt=""></button>
                    </li>
                    <li>
                      <button class="btn btn-dark" id="btnNight" onclick="formColorsNight(btnNight)" data-toggle="tooltip" data-placement="top" title="Estilo Noche"><img src="icons/luna.png" alt=""></button>
                    </li>
                    <li>
                      <a href="Logout.jsp" type="button" class="btn btn-dark" id="btnLogout" data-toggle="tooltip" data-placement="top" title="Logout"><img src="icons/logout.png" alt=""></a>
                    </li>  
                  </ul>
                </div>
              </div>
            </nav>
            <!--FIN MENU SUPERIOR-->
          
          <!--INICIA CUERPO PRINCIPAL DEL HTML-->
          <div class="content">
            <div class="container-fluid dash">
              <div class="row">
                
                  <section class="columna1 col-8 offset-fixed f-left">                      
                    <!--INICIO CARROUSEL 1 SECTORES DEL PARQUE-->
                    <div class="carousel-fotos carousel slide w-100 pb-4" data-ride="carousel">
                        <p class="titleEvents text-center">SECTORES DE GAME PARK</p> 
                        <div class="galeria carousel-inner w-100" role="listbox"> 
                            <div class="carousel-item row no-gutters active">
                                <div id="textPhotosCarousel" class="imagen col-3 float-left text-center"><a titles="" href="" ><img src="img/carrousel/1.jpg" alt=""/></a>Sector 1</div>
                                <div id="textPhotosCarousel" class="imagen col-3 float-left text-center"><a titles="" href=""><img src="img/carrousel/2.jpg" alt=""/></a>Sector 2</div>
                                <div id="textPhotosCarousel" class="imagen col-3 float-left text-center"><a titles="" href=""><img src="img/carrousel/3.jpg" alt=""/></a>Sector 3</div>
                                <div id="textPhotosCarousel" class="imagen col-3 float-left text-center"><a titles="" href=""><img src="img/carrousel/4.jpg" alt=""/></a>Sector 4</div>
                            </div>
                            <div class="carousel-item row no-gutters">
                                <div id="textPhotosCarousel" class="imagen col-3 float-left text-center"><a titles="" href=""><img src="img/carrousel/5.jpg" alt=""/></a>Sector 5</div>
                                <div id="textPhotosCarousel" class="imagen col-3 float-left text-center"><a titles="" href=""><img src="img/carrousel/6.jpg" alt=""/></a>Sector 6</div>
                                <div id="textPhotosCarousel" class="imagen col-3 float-left text-center"><a titles="" href=""><img src="img/carrousel/7.jpg" alt=""/></a>Sector 7</div>
                                <div id="textPhotosCarousel" class="imagen col-3 float-left text-center"><a titles="" href=""><img src="img/carrousel/8.jpg" alt=""/></a>Sector 8</div>
                            </div>
                        </div>                        
                    </div>
                    <!--FIN CARROUSEL 1 SECTORES DEL PARQUE-->

                    <!--INICIO CARROUSEL 2 SECTORES DEL PARQUE-->
                    <div class="carousel-fotos2 carousel slide w-100 pb-4" data-ride="carousel">
                        <p class="titleEvents text-center">SECTORES DE GAME PARK</p> 
                        <div class="galeria carousel-inner w-100" role="listbox"> 
                            <div class="carousel-item row no-gutters active">
                                <div id="textPhotosCarousel" class="imagen col-3 float-left text-center"><a titles="" href="" ><img src="img/carrousel/9.jpg" alt=""/></a>Sector 9</div>
                                <div id="textPhotosCarousel" class="imagen col-3 float-left text-center"><a titles="" href=""><img src="img/carrousel/10.jpg" alt=""/></a>Sector 10</div>
                                <div id="textPhotosCarousel" class="imagen col-3 float-left text-center"><a titles="" href=""><img src="img/carrousel/11.jpg" alt=""/></a>Sector 11</div>
                                <div id="textPhotosCarousel" class="imagen col-3 float-left text-center"><a titles="" href=""><img src="img/carrousel/12.jpg" alt=""/></a>Sector 12</div>
                            </div>
                            <div class="carousel-item row no-gutters">
                                <div id="textPhotosCarousel" class="imagen col-3 float-left text-center"><a titles="" href=""><img src="img/carrousel/13.jpg" alt=""/></a>Sector 13</div>
                                <div id="textPhotosCarousel" class="imagen col-3 float-left text-center"><a titles="" href=""><img src="img/carrousel/14.jpg" alt=""/></a>Sector 14</div>
                                <div id="textPhotosCarousel" class="imagen col-3 float-left text-center"><a titles="" href=""><img src="img/carrousel/15.jpg" alt=""/></a>Sector 15</div>
                                <div id="textPhotosCarousel" class="imagen col-3 float-left text-center"><a titles="" href=""><img src="img/carrousel/16.jpg" alt=""/></a>Sector 16</div>
                            </div>
                        </div>                        
                    </div>
                    <!--FIN CARROUSEL 2 SECTORES DEL PARQUE-->
                  </section>  

                  <section class="columna2 col-4 offset-fixed f-right">
                      <!--EL CLIMA -->
                      <p id="titlePubli">CLIMA</p>
                      <div class="card col-4 f-right clima">
                          <!-- tutiempo.net - Ancho:350px - Alto:411px -->
                          <iframe src="https://www.tutiempo.net/s-widget/app/?LocId=42833&sc=1" scrolling="no" frameborder="0" style="border:none; overflow:hidden; width:310px; height:411px;" allowtransparency="true"></iframe>
                      </div>
                      <!--FIN DEL CLIMA-->
                  </section>                  
              </div>
              <div class="row">
                  <section class="columna1 col-6 offset-fixed f-left">
                      <!--INICIO PUBLICIDADES-->
                    <div id="publicidades">
                        <p id="titlePubli">PUBLICIDADES</p>
                        <div class="" role="listbox" > <!--carousel-inner w-180-->
                            <div class="galeriaPublicaciones carousel-item row no-gutters active">
                                <div id="textPhotosPubli" class="imagen col-3 float-left text-center"><a titles="TURISMO" href="" ><img
                                            src="img/publicidades/turismo.jpg" widht="120" height="120" alt="TURISMO" /></a>TURISMO</div>                                                             
                                <div id="textPhotosPubli" class="imagen col-3 float-left text-center"><a titles="INSTITUTO" href="" ><img
                                            src="img/publicidades/instituto.jpg" widht="120" height="120" alt="INSTITUTO" /></a>INSTITUTO</div>
                                <div id="textPhotosPubli" class="imagen col-3 float-left text-center"><a titles="ELECTRO"
                                        href="" ><img src="img/publicidades/electro.jpg" widht="120" height="120" alt="ELECTRO" /></a>ELECTRO</div>
                                <div id="textPhotosPubli" class="imagen col-3 float-left text-center"><a titles="HAMBUR"
                                        href=""><img src="img/publicidades/hamburgueza.jpg" widht="120" height="120" alt="HAMBUR" /></a>HAMBUR</div> 
                            </div>
                            <div class="galeriaPublicaciones carousel-item row no-gutters active">
                                <div id="textPhotosPubli" class="imagen col-3 float-left text-center"><a titles="SUPER" href="" ><img
                                            src="img/publicidades/super.jpg" widht="120" height="120" alt="SUPER" /></a>SUPER</div>
                                <div id="textPhotosPubli" class="imagen col-3 float-left text-center"><a titles="PROJECTOR" href="" ><img
                                            src="img/publicidades/projector.jpg" widht="120" height="120" alt="PROJECTOR" /></a>PROJECTOR</div>
                                <div id="textPhotosPubli" class="imagen col-3 float-left text-center"><a titles="ROPA" href="" ><img
                                            src="img/publicidades/ropa.jpg" widht="120" height="120" alt="ROPA" /></a>ROPA</div>
                                <div id="textPhotosPubli" class="imagen col-3 float-left text-center"><a titles="ICE" href="" ><img
                                            src="img/publicidades/ice.png" widht="120" height="120" alt="ICE" /></a>ICE</div>
                            </div>                            
                        </div>
                    </div>
                    <!--FIN PUBLICIDADES--> 
                  </section>

                  <section class="columna2 col-6 offset-fixed f-right">
                      <!--NOTICIAS EN GENERAL-->
                      <p id="titlePubli">NOTICIAS</p>
                      <div id="noticias"></div>     
                  </section>                
              </div>              

            </div>
          </div>
          <!--FIN CUERPO PRINCIPAL DEL HTML-->

          <!--INICIA FOOTER-->
          <footer class="footer">
            <div class="container-fluid">          
              <div class="copyright float-right">
                &copy;
                <script>
                  document.write(new Date().getFullYear())
                </script>, made with <i class="material-icons">favorite</i> by
                <a href="https://cv.winarmarianoj.vercel.app/" target="_blank">Mariano Wiñar</a> for a better web.
              </div>          
            </div>
          </footer>
          <!--FIN DEL FOOTER-->

      </div>
      <!--FIN PANEL DERECHO COMPLETO-->

    </div>
    <!--FIN DEL WRAPPER-->
    
    <script src="js/news.js"></script>
    <script src="js/colorEfects.js"></script>
    <script src="js/requeridos/jquery-3.3.1.min.js"></script>
    <script src="js/requeridos/popper.min.js"></script>
    <script src="js/requeridos/bootstrap.min.js"></script>
    <script src="js/requeridos/sweetalert2.all.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <% }        
    %>
</body>

</html>
