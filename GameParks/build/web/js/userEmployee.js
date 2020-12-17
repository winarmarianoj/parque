const change = document.getElementById('changeEmployeeUser');
const del = document.getElementById('deleteEmployeeUser');

change.addEventListener('click', () => {
	let id = document.getElementById('idEmployee').value;
	let jsonId = JSON.stringify(id);
	idEmployee.value = "";

	fetch('URL PARA PEDIR LOS DATOS DE EMPLEADO Y USUARIO', {
        method: 'POST',
        body: jsonId
    })
    .then(response => response.json())
    .then(json => {    	
    	document.getElementById('nombreUsuario').value = json.nombreUsuario;
    	document.getElementById('nombreEmpleado').value = json.nombreEmpleado;
    	document.getElementById('apellidoEmpleado').value = json.apellidoEmpleado;
    })
    .catch(function(err) {
        op.saveErrorsList(err);
        msg.danger()
    });
})

del.addEventListener('click', () => {
	let id = document.getElementById('idEmployee').value;
	let jsonId = JSON.stringify(id);
	idEmployee.value = "";

	fetch('URL PARA ELIMINAR EMPLEADO Y USUARIO', {
        method: 'POST',
        body: jsonId
    })
    .then(response => response.json())
    .then(json => {    	
    	if(json){msg.correct();}
    })
    .catch(function(err) {
        op.saveErrorsList(err);
        msg.danger()
    });
})

function formChangeProfile(btnChangeProfile){
	var changeProfile = {
		nameUsu : document.getElementById('nombreUsuario').value,
    	nameEmp : document.getElementById('nombreEmpleado').value,
 		apeEmp : document.getElementById('apellidoEmpleado').value
	}

 	let changeCheck = op.isNotNullEmpty(changeProfile.nameUsu, "El Nombre de Usuario");
    changeCheck &= op.isNameCorrect(changeProfile.nameUsu, "El Nombre de Usuario");
    changeCheck = op.isNotNullEmpty(changeProfile.nameEmp, "El Nombre del Empleado");
    changeCheck &= op.isNameCorrect(changeProfile.nameEmp, "El Nombre del Empleado");
    changeCheck = op.isNotNullEmpty(changeProfile.apeEmp, "El Apellido del Empleado");
    changeCheck &= op.isNameCorrect(changeProfile.apeEmp, "El Apellido del Empleado");

    if (changeCheck){sendingChangeEmpUsu(JSON.stringify(changeProfile));} 

    nombreUsuario.value = "";
    nombreEmpleado.value = "";
    apellidoEmpleado.value = "";
}

function sendingChangeEmpUsu(datos){
	fetch('URL PARA ENVIAR MODIFICACIONES EN USUARIO Y EMPLEADO', {
        method: 'POST',
        body: datos
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