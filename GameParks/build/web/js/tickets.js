/* global op, msg */

// funcion que me trae los datos ingresados en el Form Entrada y Clientes
let i = document.getElementById('btnSuperInput');

i.addEventListener('click', () => {
    
    let nameClient = document.getElementById('nameClient').value;
    let lastNameClient = document.getElementById('lastNameClient').value;
    let dni = document.getElementById('dniClient').value;
    let phoneClient = document.getElementById('phoneClient').value;
    let emailClient = document.getElementById('emailClient').value;
    let idGame = document.getElementById('idGame').value;
    let idEmployee = document.getElementById('idEmployee').value;

    let resInputCheck = op.isNotNullEmpty(nameClient, "El Nombre del Cliente");
    resInputCheck &= op.isNameCorrect(nameClient, "El Nombre del Cliente");
    
    resInputCheck &= op.isNotNullEmpty(lastNameClient, "El Apellido del Cliente");
    resInputCheck &= op.isNameCorrect(lastNameClient, "El Apellido del Cliente");
    
    resInputCheck &= op.isNotNullEmpty(dni, "El DNI del Cliente");
    resInputCheck &= op.isNumber(dni, "El DNI del Cliente");
    
    resInputCheck &= op.isNotNullEmpty(phoneClient, "El Telefono del Cliente");
    resInputCheck &= op.isNumber(phoneClient, "El Telefono del Cliente");
    
    resInputCheck &= op.isNotNullEmpty(emailClient, "El Mail del Cliente");
    resInputCheck &= op.isEmailCorrect(emailClient, "El Mail del Cliente");
    
    resInputCheck &= op.isNotNullEmpty(idGame, "El ID del Juego");
    resInputCheck &= op.isNumber(idGame, "El ID del Juego");
    
    resInputCheck &= op.isNotNullEmpty(idEmployee, "El ID del Empleado");
    resInputCheck &= op.isNumber(idEmployee, "El ID del Empleado");

    send(resInputCheck)

})
function send(ress){
    if (ress){msg.correct();}else{msg.danger();}
}
