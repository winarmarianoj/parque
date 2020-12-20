/* global msg, op */

const delUser = document.getElementById('deleteUser');

delUser.addEventListener('click', () => {
    let ids = document.getElementById('idDeleteUsuario').value;
    let resUsu = op.isNotNullEmpty(ids, "El Id");
    resUsu &= op.isNumber(ids, "El Id");
    
    if(resUsu){msg.correct();}else{msg.danger();}
    
    msg.alertDecision('Esta Seguro que desea Eliminar al Usuario??');
    
})
