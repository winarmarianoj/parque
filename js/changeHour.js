const change = document.getElementById('changeHour');
const del = document.getElementById('deleteHour');

change.addEventListener('click', () => {
	let id = document.getElementById('idHours').value;
	let jsonId = JSON.stringify(id);
	idHours.value = "";

	fetch('URL PARA PEDIR LOS DATOS DE EMPLEADO Y USUARIO', {
        method: 'POST',
        body: jsonId
    })
    .then(response => response.json())
    .then(json => {    	    	
    	document.getElementById('horaInicio').value = json.horaInicio;
    	document.getElementById('horaFin').value = json.horaFin;
    })
    .catch(function(err) {
        op.saveErrorsList(err);
        msg.danger()
    });
})

del.addEventListener('click', () => {
	let id = document.getElementById('idHours').value;
	let jsonId = JSON.stringify(id);
	idHours.value = "";

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

function formChangeHour(btnChangeHour){
	var changeHour = {
    	horaInicio = document.getElementById('horaInicio').value,
        horaFin = document.getElementById('horaFin').value
	}

 	let changeCheck = op.isNotNullEmpty(changeHour.horaInicio, "La Hora de Inicio");
    changeCheck &= op.isNumber(changeHour.horaInicio, "La Hora de Inicio");
    changeCheck &= op.isNotNullEmpty(changeHour.horaFin, "La Hora de Fin");
    changeCheck &= op.isNumber(changeHour.horaFin, "La Hora de Fin");

    if (changeCheck){sendingChangeHour(JSON.stringify(changeHour));} 
    
    horaInicio.value = "";
    horaFin.value = "";
}

function sendingChangeHour(datosss){
	fetch('URL PARA ENVIAR MODIFICACIONES HORARIO', {
        method: 'POST',
        body: datosss
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