const change = document.getElementById('changeJuego');
const del = document.getElementById('deleteJuego');

change.addEventListener('click', () => {
	let id = document.getElementById('idJuego').value;
	let jsonId = JSON.stringify(id);
	idJuego.value = "";

	fetch('URL PARA PEDIR LOS DATOS DE JUEGO', {
        method: 'POST',
        body: jsonId
    })
    .then(response => response.json())
    .then(json => {    	    	
    	document.getElementById('nombreJuego').value = json.nombreJuego;
    	document.getElementById('edadMinimaJuego').value = json.edadMinimaJuego;
        document.getElementById('cantidadPersonas').value = json.cantidadPersonas;
        document.getElementById('categoriaJuego').value = json.categoriaJuego;
    })
    .catch(function(err) {
        op.saveErrorsList(err);
        msg.danger()
    });
})

del.addEventListener('click', () => {
	let id = document.getElementById('idJuego').value;
	let jsonId = JSON.stringify(id);
	idJuego.value = "";

	fetch('URL PARA ELIMINAR EMPLEADO Y USUARIO', {
        method: 'POST',
        body: jsonId
    })
    .then(response => response.json())
    .then(json => {    	
    	if(json){msg.correct();}
    })
    .catch(function(err) {
        op.saveErrorsList(err);
        msg.danger()
    });
})

function formChangeJuego(btnChangeJuego){
	var changeGame = {
    	nombreJuego : document.getElementById('nombreJuego').value,
        edadMin : document.getElementById('edadMinimaJuego').value,
        cantPers : document.getElementById('cantidadPersonas').value,
        cate : document.getElementById('categoriaJuego').value
	}

 	let changeCheckGame = op.isNotNullEmpty(changeGame.nombreJuego, "El Nombre del Juego");
    changeCheckGame &= op.isNameCorrect(changeGame.nombreJuego, "El Nombre del Juego");
    changeCheckGame &= op.isNotNullEmpty(changeGame.edadMin, "La Edad Minima");
    changeCheckGame &= op.isNumber(changeGame.edadMin, "La Edad Minima");
    changeCheckGame &= op.isNotNullEmpty(changeGame.cantPers, "La Cantidad de Personas");
    changeCheckGame &= op.isNumber(changeGame.cantPers, "La Cantidad de Personas");
    changeCheckGame &= op.isNotNullEmpty(changeGame.cate, "La Categoría");
    changeCheckGame &= op.isNameCorrect(changeGame.cate, "La Categoría");

    if (changeCheckGame){sendingchangeGame(JSON.stringify(changeGame));} 
    
    nombreJuego.value = "";
    edadMinimaJuego.value = "";
    cantidadPersonas.value = "";
    categoriaJuego.value = "";
}

function sendingchangeGame(datossss){
	fetch('URL PARA ENVIAR MODIFICACIONES JUEGO', {
        method: 'POST',
        body: datossss
    })
    .then(function(response){
        if (response.ok){
            response.json().then(data=>{
                if(data){      
                    msg.correct()
                }else{
                    msg.danger()
                }
            })
        }else {
            throw 'Error en la llamada a Ajax';
        }
    })  
    .catch(function(err){
        msg.danger();
    });     
}