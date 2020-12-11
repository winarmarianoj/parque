// funcion que me trae del Register HTML
function formRegister(btnRegister) {
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

    if (resCheck){sendingRegister(JSON.stringify(checkin));}
}

function sendingRegister(datass) {    
    fetch('http://localhost:8080/Devs/rest/account/register', {
        method: 'POST',
        body: datass
    })
    .then(function(response){
        if (response.ok){
            response.json().then(data=>{
                if(data){                    
                    window.location.href = "login.html";        
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
