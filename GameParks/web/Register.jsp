<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Game Park - Registro Nuevo Usuario y Empleado</title>
    
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">    
        <link rel="stylesheet" href="css/contact.css"> 
    </head>

    <body class="contacto bg-light"> 


        <header></header>        

        <!--Inicio Main-->
        <main>

            <section class="container-fluid">

                <!--Inicia Formulario de Contacto-->
                <section>                    
                    <div class="py-3 pt-2 text-muted text-center text-small">
                        <ul class="titleRegister list-inline">
                            <li class="list-inline-item"><img src="img/logos.png" width="50%" alt=""></li>
                            <li class="list-inline-item text-center"><a href="#"></a><p id="titleContacts">Formulario de Registro</p></li>
                        </ul>
                    </div>
                    
                    <!--INICIA SOLICITUD DE DATOS-->
                    <div class="row justify-content-center" >            
                                            
                        <div class="col-md-8 order-md-1">                       
        
                            <!--INICIO DEL FORMULARIO REGISTER-->
                            <form id="formRegister" class="needs-validation" novalidate action="UserServlet" method="POST">
                                <div class="row">
                                        <!--DATA DEL USUARIO-->
                                        <div class="col-md-4 mb-5">
                                            <label id="labels" for="firstName">Nombre de Usuario</label>
                                            <input type="text" class="form-control" id="userName" name="nameUser" placeholder="" value="" required>
                                            <div class="invalid-feedback">
                                                    El nombre es requerido y obligatorio.
                                            </div>
                                        </div>
                                        <div class="col-md-4 mb-5">
                                            <label id="labels" for="password1">Contraseña para su Usuario</label>
                                            <input type="password" class="form-control" id="password1" name="passUser1" placeholder="Por favor ingrese su contraseña">
                                            <div class="invalid-feedback">
                                                Por favor ingrese su contraseña.
                                            </div>
                                            <p class="txtRegister">Al menos una Minúscula, Mayúscula, un Número, un Símbolo, y mínimo de 8 caracteres.</p>
                                        </div>
                                        <div class="col-md-4 mb-5">
                                            <label id="labels" for="password2">Repita Contraseña</label>
                                            <input type="password" class="form-control" id="password2" name="passUser2" placeholder="Por favor repita su contraseña">
                                            <div class="invalid-feedback">
                                                Por favor repita su contraseña.
                                            </div>
                                        </div>
                                        <!--FIN DATA DEL USUARIO-->

                                        <!--DATA DEL EMPLEADO-->
                                        <div class="col-md-4 mb-5">
                                            <label id="labels" for="firstName">Sus Datos Personales</label>
                                        </div>
                                        <div class="col-md-4 mb-5">
                                            <label id="labels" for="firstName">Su Nombre</label>
                                            <input type="text" class="form-control" id="empName" name="nameEmployee" placeholder="" value="" required>
                                            <div class="invalid-feedback">
                                                    El nombre es requerido y obligatorio.
                                            </div>
                                        </div>
                                        <div class="col-md-4 mb-5">
                                            <label id="labels" for="lastName">Apellido</label>
                                            <input type="text" class="form-control" id="empLastName" name="lastNameEmployee" placeholder="" value="" required>
                                            <div class="invalid-feedback">
                                                    El segundo nombre es requerido y obligatorio.
                                            </div>
                                        </div>
                                        <!--FIN DATA DEL EMPLEADO-->

                                </div>                                

                                <!-- BOTON SUPERVISA Y REGISTRA -->
                                <input type="button" name="Supervisar: Primer Paso" id="btnRegister" value="Supervisar: Primer Paso" class="btn btn-warning"/>  
                                <p class="msgBtn"><b>Presione Enviar si salio existoso Supervisar</b></p>
                                <button type="submit" class="btn btn-primary my-5" ">Enviar</button>
                                <button href="Login.jsp" class="btn btn-success my-5">Volver al Login</button>                                
                            </form>
                            <!--FIN DEL FORMULARIO REGISTER-->                            
                        </div>                           
                    </div>
                    <!--FIN SOLICITUD DE DATOS-->

                    <!--Inicio del Footer-->
              <footer class="col-12 s12 m6 institucional">
                  <div class="col-12 s12 m6 text-muted text-center text-small">
                      <div class="datos">
                          <p class="">&copy; 2020 Game Park</p>
                          <ul class="list-inline">
                              <li class="list-inline-item"><a href="">Nosotros</a></li>
                              <li class="list-inline-item"><a href="">Manual</a></li>
                              <li class="list-inline-item"><a href="">Soporte</a></li>
                          </ul>
                          <ul>
                              <li class=" list-inline-item"><img src="logos/facebook.png" alt=""></li>
                              <li class=" list-inline-item"><img src="logos/instagram.png" alt=""></li>         
                              <li class=" list-inline-item"><img src="logos/twiter.png" alt=""></li>
                              <li class=" list-inline-item"><img src="logos/linkedin.png" alt=""></li>
                              <li class=" list-inline-item"><img src="logos/whatsapp.png" alt=""></li>
                              <li class=" list-inline-item"><img src="logos/youtube.png" alt=""></li>
                          </ul>            
                      </div>
                  </div>
              </footer>
              <!--Fin del Footer-->

                </section> 
                <!--Finaliza Formulario de Contacto-->

            </section>

        </main>
        <!--Fin Main-->      
        
        <script src="js/register.js"></script>
        <script src="js/uiFunctions.js"></script>
        <script src="js/uiMessages.js"></script>
        <script src="js/requeridos/jquery-3.3.1.min.js"></script>
        <script src="js/requeridos/popper.min.js"></script>
        <script src="js/requeridos/bootstrap.min.js"></script>
        <script src="js/requeridos/sweetalert2.all.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>

</html>
