/* global op, msg */

const delGame = document.getElementById('deleteJuego');

delGame.addEventListener('click', () => {
    let ids = document.getElementById('idDeleteJuego').value;
    let res = op.isNotNullEmpty(ids, "El Id");
    res &= op.isNumber(ids, "El Id");
    
    if(res){msg.correct();}else{msg.danger();}
    
    msg.alertDecision('Esta Seguro que desea Eliminar al Juego??');
})
