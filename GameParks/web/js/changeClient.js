const change = document.getElementById('changeCliente');
const del = document.getElementById('deleteCliente');

change.addEventListener('click', () => {
	let id = document.getElementById('idCliente').value;
	let jsonId = JSON.stringify(id);
	idCliente.value = "";

	fetch('URL PARA PEDIR LOS DATOS DE CLIENTE', {
        method: 'POST',
        body: jsonId
    })
    .then(response => response.json())
    .then(json => {    	    	
    	document.getElementById('nombreCliente').value = json.nombreCliente;
    	document.getElementById('apellidoCliente').value = json.apellidoCliente;
        document.getElementById('dniCliente').value = json.dniCliente;
        document.getElementById('telefonoCliente').value = json.telefonoCliente;
        document.getElementById('mailCliente').value = json.mailCliente;
    })
    .catch(function(err) {
        op.saveErrorsList(err);
        msg.danger()
    });
})

del.addEventListener('click', () => {
	let id = document.getElementById('idCliente').value;
	let jsonId = JSON.stringify(id);
	idCliente.value = "";

	fetch('URL PARA ELIMINAR CLIENTE', {
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

function formChangeCliente(btnChangeCliente){
	var changeClient = {
    	nombreCliente : document.getElementById('nombreCliente').value,
        apellidoCliente : document.getElementById('apellidoCliente').value,
        dniCliente : document.getElementById('dniCliente').value,
        telefonoCliente : document.getElementById('telefonoCliente').value,
        mailCliente : document.getElementById('mailCliente').value
	}

 	let changeCheckClient = op.isNotNullEmpty(changeClient.nombreCliente, "El Nombre del Cliente");
    changeCheckClient &= op.isNameCorrect(changeClient.nombreCliente, "El Nombre del Cliente");
    changeCheckClient &= op.isNotNullEmpty(changeClient.apellidoCliente, "El Apellido del Cliente");
    changeCheckClient &= op.isNameCorrect(changeClient.apellidoCliente, "El Apellido del Cliente");
    changeCheckClient &= op.isNotNullEmpty(changeClient.dniCliente, "El DNI");
    changeCheckClient &= op.isNumber(changeClient.dniCliente, "El DNI");
    changeCheckClient &= op.isNotNullEmpty(changeClient.telefonoCliente, "El Telefono");
    changeCheckClient &= op.isNumber(changeClient.telefonoCliente, "El Telefono");
    changeCheckClient &= op.isNotNullEmpty(changeClient.mailCliente, "El Mail");
    changeCheckClient &= op.isNameCorrect(changeClient.mailCliente, "El Mail");

    if (changeCheckClient){sendingchangeClient(JSON.stringify(changeClient));} 
    
    nombreCliente.value = "";
    apellidoCliente.value = "";
    dniCliente.value = "";
    telefonoCliente.value = "";
    mailCliente.value = "";
}

function sendingchangeClient(datosssss){
	fetch('URL PARA ENVIAR MODIFICACIONES JUEGO', {
        method: 'POST',
        body: datosssss
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