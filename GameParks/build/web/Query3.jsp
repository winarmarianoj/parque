<%-- 
    Document   : reports
    Created on : 15 dic. 2020, 19:31:43
    Author     : mariano
--%>

<%@page import="logica.Juego"%>
<%@page import="logica.controladora.ControlJuego"%>
<%@page import="logica.Empleado"%>
<%@page import="java.util.List"%>
<%@page import="logica.controladora.ControlEmpleado"%>
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
                    </ul>
                  </div>
                </div>
              </nav>
              <!--FIN MENU SUPERIOR-->


            <!--INICIA SECCION DE INFORMES Y TABLAS -->
            <div class="content">
              <div class="container-fluid">
                <div class="row">                 

                  <!--INICIO DE LA TABLAS E INFORMES -->
                  <div class="col-md-12">
                    <div class="card card-plain">

                      <!-- INICIO SOLICITUD DE DATOS -->
                        <div class="card my-3 col-lg-12">

                            <!--Inicia Cabezera del Formulario-->
                            <div class="card-header pb-4">
                                <ul class="nav nav-tabs card-header-tabs nav-fill">
                                    <li class="nav-item">
                                        <a id="titleRealizaPublicaciones" class="nav-link active" href="#">Ingreso de Datos a Solicitar según Queries</a>
                                    </li>                                    
                                </ul>
                            </div>
                            <!--Fin Cabezera del Formulario-->
                            
                            <!--INICIA AREA DE MAS DATOS REQUERIDOS PARA EL QUERY -->
                            
                            <form action="Query3Servlet" method="POST">
                                <ul>
                                    <p><b>ÁREA DE INGRESO DE DATOS NECESARIOS PARA GENERAR LOS INFORMES</b></p> 
                                    <li>
                                      <label id="labels">Nombre del Juego a Requerir información</label>
                                      <input type="text" class="form-control" id="gameName" name="juegoReports" placeholder="" value="" required>                                      
                                    </li>                                    
                                </ul>                                 
                            </form>
                            <!--FIN AREA DE MAS DATOS REQUERIDOS PARA EL QUERY -->

                        </div>
                        <!-- FIN SOLICITUD DE DATOS -->
                        
                        <!-- IMPRESION DE DATOS SOLICITADOS -->
                        <div class="row justify-content-center mt-5">
                            <div class="col-6">
                                <label class="titleCentral">Resultado obtenido</label>                                
                            </div>
                            
                             <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-hover" id="reportTable">
                                        <thead>
                                            <tr>
                                              <th>ID Empleado</th>
                                              <th>Nombre</th>
                                              <th>Apellido</th>
                                             </tr>
                                        </thead>

                                        <tbody>
                                            <tr>
                                <%		
                                        ControlJuego control = (ControlJuego) session.getAttribute("resulQ3");
                                        Juego ju = control.getJue();
                                        List<Juego> listJue = control.traerJuego();
                                        List<Empleado> listEmp = null;
                                        for (Juego jue : listJue) { 
                                            if(jue.getNombre().equals(ju.getNombre())){
                                                 listEmp = jue.getListaEmpleado();
                                            }
                                        }
                                        for (Empleado e : listEmp){
                                        
                                %>
                                              <td><%=e.getEmpleado_id()%></td>
                                              <td><%=e.getNombre()%></td>
                                              <td><%=e.getApellido()%></td>
                                            </tr>

                                <%    
                                        }
                                %>
                                        </tbody>

                                    </table>
                                </div>
                            </div>
                            
                        </div>

                        <div class="row justify-content-center mt-5" style="height: auto">
                            <div class="col-6">
                                <a href="Reports.jsp" class="btn btn-success btn-block">Regresar a Reportes</a>				
                            </div>			
                        </div>		                      
                    </div>
                  </div>
                  <!--FIN DE LA TABLAS E INFORMES -->


                  <!--INICIA FOOTER-->
                  <footer class="firma">
                    <div class="container-fluid">          
                      <div class="copyright">
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
              </div>
            </div>
            <!--INICIA SECCION DE INFORMES Y TABLAS -->

        </div>
        <!--FINAL PANEL DERECHO COMPLETO--> 

    </div>
    <!--FINAL WRAPPER-->    

    <!--<script src="js/security.js"></script> -->    
    <script src="js/colorEfects.js"></script>
    <script src="js/reports.js"></script>
    <script src="js/ui.js"></script>
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
