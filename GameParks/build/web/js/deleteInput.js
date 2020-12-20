/* global op, msg */

const delEntrada = document.getElementById('deleteEntrada');

delEntrada.addEventListener('click', () => {
    let ids = document.getElementById('idDeleteEntrada').value;
    let resUsu = op.isNotNullEmpty(ids, "El Id");
    resUsu &= op.isNumber(ids, "El Id");
    
    if(resUsu){msg.correct();}else{msg.danger();}
     
    msg.alertDecision('Esta Seguro que desea Eliminar la Entrada??');
})
