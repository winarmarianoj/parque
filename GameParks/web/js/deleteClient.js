/* global op, msg */

const delCli = document.getElementById('deleteCliente');

delCli.addEventListener('click', () => {
    let id = document.getElementById('idDeleteCliente').value;
    let res = op.isNotNullEmpty(id, "El Id");
    res &= op.isNumber(id, "El Id");
    
    if(res){msg.correct();}else{msg.danger();}    
     
    msg.alertDecision('Esta Seguro que desea Eliminar al Cliente??');
})
