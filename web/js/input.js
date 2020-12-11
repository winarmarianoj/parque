// funcion que me trae los datos ingresados en el Form Entrada y Clientes
function formEmtradas(btnEntrada) {
   
    var inputCheck = {
        nameClient : document.getElementById('nameClient').value,
        lastNameClient : document.getElementById('lastNameClient').value,
        phoneClient : document.getElementById('phoneClient').value,        
        emailClient : document.getElementById('emailClient').value,
        idGame : document.getElementById('idGame').value,
        idEmployee : document.getElementById('idEmployee').value
    };      

    let resInputCheck = op.isNotNullEmpty(inputCheck.nameClient, "El Nombre del Cliente");
    resInputCheck &= op.isNameCorrect(inputCheck.nameClient, "El Nombre del Cliente");
    resInputCheck &= op.isNotNullEmpty(inputCheck.lastNameClient, "El Apellido del Cliente");
    resInputCheck &= op.isNameCorrect(inputCheck.lastNameClient, "El Apellido del Cliente");
    resInputCheck &= op.isNotNullEmpty(inputCheck.phoneClient, "El Telefono del Cliente");
    resInputCheck &= op.isNumber(inputCheck.phoneClient, "El Telefono del Cliente");
    resInputCheck &= op.isNotNullEmpty(inputCheck.emailClient, "El Mail del Cliente");
    resInputCheck &= op.isEmailCorrect(inputCheck.emailClient, "El Mail del Cliente");
    resInputCheck &= op.isNotNullEmpty(inputCheck.idGame, "El ID del Juego");
    resInputCheck &= op.isNumber(inputCheck.idGame, "El ID del Juego");
    resInputCheck &= op.isNotNullEmpty(inputCheck.idEmployee, "El ID del Empleado");
    resInputCheck &= op.isNumber(inputCheck.idEmployee, "El ID del Empleado");

    if (resInputCheck){sendingInputClient(JSON.stringify(inputCheck));}

    document.getElementById('nameClient').value = " ";
    document.getElementById('lastNameClient').value = " ";
    document.getElementById('phoneClient').value = " ";     
    document.getElementById('emailClient').value = " ";
    document.getElementById('idGame').value = " ";
    document.getElementById('idEmployee').value = " ";
}

function sendingInputClient(datassss) {    
    fetch('http://localhost:8080/Devs/rest/account/register', {
        method: 'POST',
        body: datassss
    })
    .then(function(response){
        if (response.ok){
            response.json().then(data=>{
                if(data){           
                    msg.correct()
                }else{
                    msg.danger()
                }
            })
        }else {
            throw 'Error en la llamada a Ajax';
        }
    })  
    .catch(function(err){
        msg.danger();
    });     
}