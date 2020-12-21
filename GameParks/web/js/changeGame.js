/* global op, msg */

const changeGame = document.getElementById('changeJuego');

changeGame.addEventListener('click', () => {
		 
    let id = document.getElementById('idJuego').value;
    let name = document.getElementById('nombreJuego').value;
    let edad = document.getElementById('edadMinimaJuego').value;
    let capa = document.getElementById('cantidadPersonas').value;
    let cate = document.getElementById('categoriaJuego').value;
    
    let res = op.isNotNullEmpty(id, "El Id");
    res &= op.isNumber(id, "El Id");
    
    res &= op.isNotNullEmpty(name, "El Nombre del Juego");  
    res &= op.isNameCorrect(name, "El Nombre del Juego");  
    
    res &= op.isNotNullEmpty(edad, "La Edad");
    res &= op.isNumber(edad, "La Edad");
    
    res &= op.isNotNullEmpty(capa, "La Capacidad");
    res &= op.isNumber(capa, "La Capacidad");
    
    res &= op.isNotNullEmpty(cate, "La Categoría");  
    res &= op.isNameCorrect(cate, "La Categoría");    
    
    sendMsg(res);
})
function sendMsg(res){    
    
    if(res){msg.correct();}else{msg.danger();}
}

