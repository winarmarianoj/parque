/* global op, msg */

const delHours = document.getElementById('deleteHour');

delHours.addEventListener('click', () => {
    let ids = document.getElementById('idDeleteHora').value;
    let res = op.isNotNullEmpty(ids, "El Id");
    res &= op.isNumber(ids, "El Id");
    
    if(res){msg.correct();}else{msg.danger();}
     
    msg.alertDecision('Esta Seguro que desea Eliminar el Horario??');
})
