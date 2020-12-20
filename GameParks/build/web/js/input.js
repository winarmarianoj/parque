/* global op, msg */

// funcion que me trae los datos ingresados en el Form Entrada y Clientes
function formEmtradas(btnEntrada) {
   
    var inputCheck = {
        nameClient : document.getElementById('nameClient').value,
        lastNameClient : document.getElementById('lastNameClient').value,
        dni : document.getElementById('dniClient').value,
        phoneClient : document.getElementById('phoneClient').value,        
        emailClient : document.getElementById('emailClient').value,
        idGame : document.getElementById('idGame').value,
        idEmployee : document.getElementById('idEmployee').value
    };      

    let resInputCheck = op.isNotNullEmpty(inputCheck.nameClient, "El Nombre del Cliente");
    resInputCheck &= op.isNameCorrect(inputCheck.nameClient, "El Nombre del Cliente");
    resInputCheck &= op.isNotNullEmpty(inputCheck.lastNameClient, "El Apellido del Cliente");
    resInputCheck &= op.isNameCorrect(inputCheck.lastNameClient, "El Apellido del Cliente");
    resInputCheck &= op.isNotNullEmpty(inputCheck.dni, "El DNI del Cliente");
    resInputCheck &= op.isNameCorrect(inputCheck.dni, "El DNI del Cliente");
    resInputCheck &= op.isNotNullEmpty(inputCheck.phoneClient, "El Telefono del Cliente");
    resInputCheck &= op.isNumber(inputCheck.phoneClient, "El Telefono del Cliente");
    resInputCheck &= op.isNotNullEmpty(inputCheck.emailClient, "El Mail del Cliente");
    resInputCheck &= op.isEmailCorrect(inputCheck.emailClient, "El Mail del Cliente");
    resInputCheck &= op.isNotNullEmpty(inputCheck.idGame, "El ID del Juego");
    resInputCheck &= op.isNumber(inputCheck.idGame, "El ID del Juego");
    resInputCheck &= op.isNotNullEmpty(inputCheck.idEmployee, "El ID del Empleado");
    resInputCheck &= op.isNumber(inputCheck.idEmployee, "El ID del Empleado");

    if (resInputCheck){msg.correct();}else{msg.danger();}

}
