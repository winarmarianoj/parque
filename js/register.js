/*
 funcion que me trae del Register HTML
*/
function fun(btnRegistrate){
    let pass2 = document.getElementById('password2').value;

    let checkin = {
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


    if (resCheck){
        const url = 'http://localhost:8082/GameParks/rest/user/registered';
        fetch(url, {
            method: 'POST',
            body: JSON.stringify(checkin),
            headers:{
                'Content-Type': 'application/json'
            }
        })
            .then(response => response.json())
            .then(json => {
                let parseo = JSON.parse(json)
                if(parseo){
                    msg.correct()
                    sendUser()
                }else{
                    alert('No Andaaaaaaaaaaa')
                }
            })
            .catch(() => {
                msg.invalidAdd("NO SE QUE PASA")
            })
    }
}


function sendUser(){
    window.location.href = "login.html";
}

