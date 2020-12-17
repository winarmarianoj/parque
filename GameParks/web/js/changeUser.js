const change = document.getElementById('changeUser');
const del = document.getElementById('deleteUser');

change.addEventListener('click', () => {
	let id = document.getElementById('idUser').value;
	let jsonId = JSON.stringify(id);
	ididUser.value = "";

	fetch('URL PARA PEDIR LOS DATOS DE EMPLEADO Y USUARIO', {
        method: 'POST',
        body: jsonId
    })
    .then(response => response.json())
    .then(json => {    	
    	document.getElementById('nombreUsuario').value = json.nombreUsuario;
    })
    .catch(function(err) {
        op.saveErrorsList(err);
        msg.danger()
    });
})

del.addEventListener('click', () => {
	let id = document.getElementById('idUser').value;
	let jsonId = JSON.stringify(id);
	idUser.value = "";

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

function formchangeUser(btnchangeUser){
	let nameUsu = document.getElementById('nombreUsuario').value;

 	let changeCheckUser = op.isNotNullEmpty(nameUsu, "El Nombre de Usuario");
    changeCheckUser &= op.isNameCorrect(nameUsu, "El Nombre de Usuario");

    if (changeCheckUser){sendingChangeUsu(JSON.stringify(nameUsu));} 

    nombreUsuario.value = "";
}

function sendingChangeUsu(datos){
	fetch('URL PARA ENVIAR MODIFICACIONES EN USUARIO ', {
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