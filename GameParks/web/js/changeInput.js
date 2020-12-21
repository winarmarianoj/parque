/* global op, msg */

const changeEntrada = document.getElementById('changeEntrada');

changeEntrada.addEventListener('click', () => {
    
    let id = document.getElementById('idEntrada').value;
    let fecha = document.getElementById('fechaEntrada').value;
    let idCli = document.getElementById('idCliEntrada').value;
    let idEmp = document.getElementById('idEmpEntrada').value;
    let idJue = document.getElementById('idJueEntrada').value;
    
    let res = op.isNotNullEmpty(id, "El Id");
    res &= op.isNumber(id, "El Id");
    
    res &= op.isNotNullEmpty(fecha, "La Fecha");
    res &= op.isNumber(fecha, "La Fecha");
    
    res &= op.isNotNullEmpty(idCli, "ID del Cliente");
    res &= op.isNumber(idCli, "ID del Cliente");
    
    res &= op.isNotNullEmpty(idEmp, "ID del Empleado");
    res &= op.isNumber(idEmp, "ID del Empleado");
    
    res &= op.isNotNullEmpty(idJue, "ID del Juego");
    res &= op.isNumber(idJue, "ID del Juego");
    
    sendMsg(res);
})
function sendMsg(res){    
    
    if(res){msg.correct();}else{msg.danger();}
}
