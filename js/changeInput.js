const change = document.getElementById('changeEntrada');
const del = document.getElementById('deleteEntrada');

change.addEventListener('click', () => {
	let id = document.getElementById('idEntrada').value;
	let jsonId = JSON.stringify(id);
	idEntrada.value = "";

	fetch('URL PARA PEDIR LOS DATOS DE CLIENTE', {
        method: 'POST',
        body: jsonId
    })
    .then(response => response.json())
    .then(json => {    	    	
    	document.getElementById('fechaEntrada').value = json.fechaEntrada;
    	document.getElementById('idCliEntrada').value = json.idCliEntrada;
        document.getElementById('idEmpEntrada').value = json.idEmpEntrada;
        document.getElementById('idJueEntrada').value = json.idJueEntrada;
    })
    .catch(function(err) {
        op.saveErrorsList(err);
        msg.danger()
    });
})

del.addEventListener('click', () => {
	let id = document.getElementById('idEntrada').value;
	let jsonId = JSON.stringify(id);
	idEntrada.value = "";

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

function formChangeEntrada(btnChangeEntrada){
	var changeInput = {
        idCliEntrada : document.getElementById('idCliEntrada').value,
        idEmpEntrada : document.getElementById('idEmpEntrada').value
	}

 	let changeCheckInput = op.isNotNullEmpty(changeInput.idCliEntrada, "El Id del Cliente");
    changeCheckInput &= op.isNumber(changeInput.idCliEntrada, "El Id del Cliente");
    changeCheckInput &= op.isNotNullEmpty(changeInput.idEmpEntrada, "El Id del Empleado");
    changeCheckInput &= op.isNumber(changeInput.idEmpEntrada, "El Id del Empleado");

    if (changeCheckInput){sendingchangeInput(JSON.stringify(changeInput));} 
    
    idCliEntrada.value = "";
    idEmpEntrada.value = "";
}

function sendingchangeInput(datossssss){
	fetch('URL PARA ENVIAR MODIFICACIONES JUEGO', {
        method: 'POST',
        body: datossssss
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