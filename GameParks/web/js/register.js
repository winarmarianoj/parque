/* global op, msg */

let reg = document.getElementById('btnRegister');

// funcion que me trae del Register HTML
reg.addEventListener('click', () => {
    var pass2 = document.getElementById('password2').value;
   
    var checkin = {
        userName : document.getElementById('userName').value,
        password : document.getElementById('password1').value,
        name : document.getElementById('empName').value,        
        lastName : document.getElementById('empLastName').value
    };      

    let resCheck = op.isNotNullEmpty(checkin.userName, "El Nombre de Usuario");
    resCheck &= op.isNameCorrect(checkin.userName, "El Nombre de Usuario"); 
    
    resCheck &= op.isNotNullEmpty(checkin.password, "La contraseña");
    resCheck &= op.isPassCorrect(checkin.password, "La contraseña");
    
    resCheck &= op.isNotNullEmpty(checkin.name, "El Nombre del Empleado");
    resCheck &= op.isNameCorrect(checkin.name, "El Nombre del Empleado");
    
    resCheck &= op.isNotNullEmpty(checkin.lastName, "El Apellido del Empleado");
    resCheck &= op.isNameCorrect(checkin.lastName, "El Apellido del Empleado"); 
    
    resCheck &= op.isPasswordEquals(checkin.password,pass2);

    sendRes(resCheck);
})

function sendRes(resCheck){
    if (resCheck){msg.correct();}else{msg.danger();}
}
