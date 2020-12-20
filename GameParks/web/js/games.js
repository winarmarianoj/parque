/* global op, msg */

// funcion que me trae los datos ingresados en el Form de Juegos y Horarios nuevos
function formJuegos(btnJuegoHorario) {
   
    var gameCheck = {
        horaInicio : document.getElementById('horaInicio').value,
        horaFin : document.getElementById('horaFin').value,
        gameName : document.getElementById('gameName').value,        
        edadMinima : document.getElementById('edadMinima').value,
        capacidadPersonas : document.getElementById('capacidadPersonas').value,
        categoria : document.getElementById('categoria').value
    };      

    let resGameCheck = op.isNotNullEmpty(gameCheck.horaInicio, "La Hora de Inicio");
    resGameCheck &= op.isNumber(gameCheck.horaInicio, "La Hora de Inicio");
    resGameCheck &= op.isNotNullEmpty(gameCheck.horaFin, "La Hora de Fin");
    resGameCheck &= op.isNumber(gameCheck.horaFin, "La Hora de Fin");
    resGameCheck &= op.isNotNullEmpty(gameCheck.gameName, "El Nombre del Juego");
    resGameCheck &= op.isNameCorrect(gameCheck.gameName, "El Nombre del Juego");
    resGameCheck &= op.isNotNullEmpty(gameCheck.edadMinima, "La Edad Minima");
    resGameCheck &= op.isNumber(gameCheck.edadMinima, "La Edad Minima");
    resGameCheck &= op.isNotNullEmpty(gameCheck.capacidadPersonas, "La Capacidad de Personas");
    resGameCheck &= op.isNumber(gameCheck.capacidadPersonas, "La Capacidad de Personas");
    resGameCheck &= op.isNotNullEmpty(gameCheck.categoria, "La Categoria del Juego");
    resGameCheck &= op.isNameCorrect(gameCheck.categoria, "La Categoria del Juego");

    if (resGameCheck){msg.correct();}else{msg.danger();}
}

