/* global op, msg */

// Funcion que me trae del Login HTML
function formLogin(btnLogin) {    

    var loged = {
        userName : document.getElementById('userName').value,
        password : btoa(document.getElementById('password').value)
    };	

    let resLogin = op.isNotNullEmpty(loged.userName,"El Nombre de Usuario");
    resLogin &= op.isEmailCorrect(loged.userName,"El Nombre de Usuario");
    resLogin &= op.isNotNullEmpty(loged.password,"La Contraseña");
    resLogin &= op.isPassCorrect(loged.password,"La Contraseña");

    if (resLogin){msg.correct();}
}

// funcion que me trae del Forgot HTML
function formForgot(btnForgot) {

    var pass2 = document.getElementById('password2').value;

    var forgot = {
        userName : document.getElementById('userName').value,
        password : document.getElementById('password1').value
    };    	
    let resForgot = op.isNotNullEmpty(forgot.userName,"El Nombre del Usuario");
    resForgot &= op.isEmailCorrect(forgot.userName,"El Nombre del Usuario");
    resForgot &= op.isNotNullEmpty(forgot.password,"La Contraseña");
    resForgot &= op.isPassCorrect(forgot.password,"La Contraseña");
    resForgot &= op.isPasswordEquals(forgot.password,pass2);

    if (resForgot){msg.correct();}else{msg.danger();}        
}
