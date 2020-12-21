/* global op, msg */

const changeEmp = document.getElementById('changeEmployee');

changeEmp.addEventListener('click', () => {
			 
    let id = document.getElementById('idEmpleado').value;
    let name = document.getElementById('nombreEmpleado').value;
    let ape = document.getElementById('apellidoEmpleado').value;
    
    let res = op.isNotNullEmpty(id, "El Id");
    res &= op.isNumber(id, "El Id");
    
    res &= op.isNotNullEmpty(name, "El Nombre");  
    res &= op.isNameCorrect(name, "El Nombre");  
    
    res &= op.isNotNullEmpty(ape, "El Apellido");  
    res &= op.isNameCorrect(ape, "El Apellido");   
    
    sendMsg(res);
})
function sendMsg(res){    
    
    if(res){msg.correct();}else{msg.danger();}
}
