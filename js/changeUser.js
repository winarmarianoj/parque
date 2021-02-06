const change = document.getElementById('changeUser');
const del = document.getElementById('deleteUser');

function getFetch(url){
    return fetch(url)
        .then(response => response.json())
}

function takeListUser(){
    var usu = getFetch('http://localhost:8082/GamePark/rest/user/userList');
    let tableUser = "";
    tableUser = tableUser + "<tr> <th>Id Usuario</th> <th>Nombre de Usuario</th> <th>Conectado o no</th> </tr>";
    usu.forEach(element => {
        tableUser = tableUser + ui.drawListUserChange(element);
    })
}

change.addEventListener('click', () => {
	let id = document.getElementById('idUser').value;
	let jsonId = JSON.stringify(id);
	idUser.value = "";

	fetch('http://localhost:8082/GamePark/rest/user/user' + jsonId, {
        method: 'POST',
        body: jsonId
    })
    .then(response => response.json())
    .then(json => {
        document.getElementById('idUsuario').value = id;
    	document.getElementById('nombreUsuario').value = json.nombre;
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

	fetch('http://localhost:8082/GamePark/rest/user/delete' + jsonId, {
        method: 'POST',
        body: jsonId
    })
    .then(response => response.json())
    .then(json => {    	
    	if(json){msg.correct();}else{msg.danger();}
    })
    .catch(function(err) {
        op.saveErrorsList(err);
        msg.danger()
    });
})

function formChangeUser(btnChangeUser){
    var usu = {
        id : document.getElementById('idUsuario').value,
        name : document.getElementById('nombreUsuario').value
    }

 	let changeCheckUser = op.isNotNullEmpty(nameUsu, "El Nombre de Usuario");
    changeCheckUser &= op.isNameCorrect(nameUsu, "El Nombre de Usuario");

    if (changeCheckUser){sendingChangeUsu(JSON.stringify(usu));}

    nombreUsuario.value = "";
}

function sendingChangeUsu(datos){
	fetch('http://localhost:8082/GamePark/rest/user/changeUser', {
        method: 'POST',
        body: datos
    })
    .then(response => response.json())
    .then(json => {
        if(json){
            msg.correct();
        }else{
            msg.danger();
        }
    })
    .catch(function(err){
        msg.danger();
    });     
}

takeListUser();