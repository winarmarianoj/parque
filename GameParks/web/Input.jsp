<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

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
    <link rel="stylesheet" type="text/css" href="css/forms.css">

  <title> Game Park - Ingreso de Entradas y Clientes </title>
</head>

<body>
        <%
    HttpSession sesion = request.getSession();    
    String usu = (String) request.getSession().getAttribute("usuario");
    if(usu == null){
        request.getSession().setAttribute("resLogReg", "El Usuario y Contraseña no fueron cargados o estan vacíos.!");
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
                    <li class="nav-item ">
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
                    <li class="nav-item active">
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

      <main class="main-panel">
        
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

        <!--INICIO AREA DE INGRESO DE DATOS -->
        <section class="fondoEntrada">
              <div class="content formGames">
                <div class="container-fluid">
                  <div class="row">
                    <div class="col-md-8">
                      <div class="card">
                        <div class="card-header card-header-primary">
                          <h4 class="card-title">Genera Entradas y Clientes </h4>
                          <p class="card-category">Ingresar todos los datos solicitados</p>
                        </div>
                        <div class="card-body">

                          <!--INICIO DEL FORMULARIO -->  
                          <form action="InputServlet" method="POST">
                            <div class="row my-5">

                              <!--DATOS DEL CLIENTE-->
                              <div class="col-md-5">
                                <div class="form-group">
                                  <label class="bmd-label-floating">Datos del Cliente</label>
                                </div>
                              </div>
                              <div class="col-md-3">
                                <div class="form-group">
                                  <label class="bmd-label-floating">Nombre del Cliente</label>
                                  <input type="text" class="form-control" id="nameClient" name="nameClient">
                                </div>
                              </div>
                              <div class="col-md-4">
                                <div class="form-group">
                                  <label class="bmd-label-floating">Apellido del Cliente</label>
                                  <input type="text" class="form-control" id="lastNameClient" name="lastNameClient">
                                </div>
                              </div>
                              <div class="col-md-5 my-3">
                                <div class="form-group">
                                  <label class="bmd-label-floating">DNI del Clietne</label>
                                  <input type="text" class="form-control" id="dniClient" name="dniClient">
                                </div>
                              </div>
                              <div class="col-md-3 my-3">
                                <div class="form-group">
                                  <label class="bmd-label-floating">Telefono o Celular</label>
                                  <input type="text" class="form-control" id="phoneClient" name="phoneClient">
                                </div>
                              </div>
                              <div class="col-md-4 my-3">
                                <div class="form-group">
                                  <label class="bmd-label-floating">Email para Contactarlo</label>
                                  <input type="email" class="form-control" id="emailClient" name="emailClient">
                                </div>
                              </div>
                            </div>
                            <!--FIN DATOS DEL CLIENTE-->

                            <!--DATOS DE LA ENTRADA-->
                            <div class="row my-3">                            
                              <div class="col-md-5">
                                <div class="form-group">
                                  <label class="bmd-label-floating">Información de la Entrada</label>
                                </div>
                              </div>
                              <div class="row my-3">
                                <div class="col-md-6">
                                  <div class="form-group">
                                    <label class="bmd-label-floating">Id del Juego</label>
                                    <input type="text" class="form-control" id="idGame" name="idGame">
                                  </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                      <label class="bmd-label-floating">Id del Empleado</label>
                                      <input type="text" class="form-control" id="idEmployee" name="idEmployee">
                                    </div>
                                </div>
                              </div>
                            </div>
                            <!--FIN DATOS DE LA ENTRADA-->
                            <button id="btnSuperInput"  type="button" value="Supervisar: Primer Paso" class="btn btn-warning my-2">Supervisar: Primer Paso</button>
                            <p><b>Presione Enviar si salio existoso Supervisar</b></p>
                            
                            <button id="btnInput" type="submit" class="btn btn-primary pull-right my-2">Enviar</button>

                          </form>
                          <!--FIN DEL FORMULARIO-->

                        </div>
                      </div>
                    </div>
                    
                  </div>
                </div>
            </div>  
        </section>  
        
        <!--INICIO AREA DE INGRESO DE DATOS -->  

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

      </main>

    </div>
    <!--FINAL WRAPPER--> 

    <script src="js/colorEfects.js"></script>
    <script src="js/tickets.js"></script>
    <script src="js/uiFunctions.js"></script>
    <script src="js/uiMessages.js"></script>
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
