/* global op, msg */

const delEmp = document.getElementById('deleteEmployee');

delEmp.addEventListener('click', () => {
    let ids = document.getElementById('idDeleteEmpleado').value;
    let res = op.isNotNullEmpty(ids, "El Id");
    res &= op.isNumber(ids, "El Id");
    
    sendMsg(res);
    
    msg.alertDecision('Esta Seguro que desea Eliminar al Empleado??');
})
