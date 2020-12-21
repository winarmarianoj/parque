/* global op, msg */

const delCli = document.getElementById('deleteCliente');

delCli.addEventListener('click', () => {
    msg.alertDecision('Esta Seguro que desea Eliminar al Cliente??');   
})
