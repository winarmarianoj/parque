/* global op, msg */

const changeHours = document.getElementById('changeHour');

changeHours.addEventListener('click', () => {
	 
    let id = document.getElementById('idHorario').value;
    let ini = document.getElementById('horaInicio').value;
    let fin = document.getElementById('horaFin').value;
    
    let res = op.isNotNullEmpty(id, "El Id");
    res &= op.isNumber(id, "El Id");
    
    res &= op.isNotNullEmpty(ini, "La Hora de Inicio");
    res &= op.isNumber(ini, "La Hora de Inicio");
    
    res &= op.isNotNullEmpty(fin, "La Hora de Fin");
    res &= op.isNumber(fin, "La Hora de Fin");
    
    sendMsg(res);
})
function sendMsg(res){    
    
    if(res){msg.correct();}else{msg.danger();}
}

