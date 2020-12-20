<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">          
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="css/stylesLogin.css">
    <title>Game Park - Cambio de contraseña</title>
</head>
<body class="log">     

    <header> </header>

    <main>
        
        <!--INICIA INGRESO DE EMAIL Y CONTRASEÑA-->
    	<section class="loguer">
            <div class="loguerin-dark p-3 shadow-lg rounded justify-content-center">

                <!--TITLE FORM-->
                <div class="row d-flex justify-content-center align-items-center pb-4 pt-3">
                    <img src="img/logos.png" width="15%" alt="">
                    <p class="title text-white">Nueva Contraseña</p>
                </div>

                <!--INICIO DEL FORMULARIO-->
                <form id="formForgot" action="ForgotServlet" method="POST"> 
                    <div class="form-group">
                        <input type="text" id="userName"
                            class="form-control form-control-sm bg-light" 
                            placeholder="Nombre del Usuario" name="nameUser">
                    </div>

                    <div class="form-group">
                        <input type="password" id="password1"
                            class="form-control form-control-sm bg-light" 
                            placeholder="Contraseña" name="pass1">
                    </div>

                    <div class="form-group">
                        <input type="password" id="password2"
                            class="form-control form-control-sm bg-light" 
                            placeholder="Contraseña" name="pass2">
                    </div>


                    <!-- BOTON SEND -->                    
                    <input type="button" name="Supervisar: Primer Paso" id="btnRegister" value="Supervisar: Primer Paso" onclick="formForgot(btnForgot)" class="btn btn-warning"/>  
                    <p class="msgBtn"><b>Presione Enviar si salio existoso Supervisar</b></p>
                    <button type="submit" class="btn btn-primary my-5" ">Enviar</button>

                    <div class="text-center mt-2 my-4">
                        <a href="Login.jsp" class="text-warning">Volver al login si no la quiere cambiar</a>
                    </div>
                    
                </form>
                <!--FIN DEL FORMULARIO-->
                
            </div>

            <!--Inicio Footer-->
            <footer class=" my-5 pt-3 text-muted text-center text-small">                        
                <p class="mb-1">&copy; 2020 Game Park</p>
                <ul class="list-inline">
                    <li class="list-inline-item"><a href="#">Nosotros</a></li>
                    <li class="list-inline-item"><a href="#">Términos</a></li>
                    <li class="list-inline-item"><a href="#">Soporte</a></li>
                    <li class="list-inline-item"><a href="#"></a></li>
                    <li class="list-inline-item"><img src="logos/facebook.png" alt=""></li>
                    <li class="list-inline-item"><img src="logos/instagram.png" alt=""></li>
                    <li class="list-inline-item"><img src="logos/linkedin.png" alt=""></li>
                    <li class="list-inline-item"><img src="logos/twiter.png" alt=""></li>
                    <li class="list-inline-item"><img src="logos/youtube.png" alt=""></li> 
                </ul>     
            </footer>
            <!--Fin Footer-->            

        </section>
        <!--FIN INGRESO DE EMAIL Y CONTRASEÑA-->        

    </main>

    <footer></footer>
    
    <script src="js/login.js"></script>
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


