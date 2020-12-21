<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />    
    <!-- Fonts and icons     -->
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
    <!-- Material Kit CSS -->
    <link href="css/stylesCentral.css" rel="stylesheet"/>
    <link rel="stylesheet" href="css/styles.css">
        <title>Respuestas de sus Operaciones</title>
    </head>
    <body>
            <%
    HttpSession sesion = request.getSession();    
    String usu = (String) request.getSession().getAttribute("usuario");
   
    %>
        <h1 class="text-center titleCentral">Aquí recibirá sus respuestas sobre las operaciones realizadas</h1>
        
        <div class="container">
		<div class="row justify-content-center mt-5">
			<div class="col-6">
				<label class="titleCentral">Resultado obtenido</label>
                                <p><b><%=session.getAttribute("resLogReg")%></b></p>
			</div>
		</div>

		<div class="row justify-content-center mt-5" style="height: auto">
			<div class="col-6">
				<a href="Login.jsp" class="btn btn-success btn-block">Ir a Inicio de Sesión o Registrarse</a>				
			</div>			
		</div>		
	</div>        
        
        <script src="js/requeridos/jquery-3.3.1.min.js"></script>
        <script src="js/requeridos/popper.min.js"></script>
        <script src="js/requeridos/bootstrap.min.js"></script>
        <script src="js/requeridos/sweetalert2.all.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <%         
    %>
    </body>
</html>
