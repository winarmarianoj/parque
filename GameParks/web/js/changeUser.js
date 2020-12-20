/* global msg, op */

const changeUser = document.getElementById('changeUser');

changeUser.addEventListener('click', () => {
	let id = document.getElementById('idUsuario').value;
        let name = document.getElementById('nombreUsuario').value;
        
    let resUsu = op.isNotNullEmpty(id, "El Id");
    resUsu &= op.isNumber(id, "El Id");
    resUsu &= op.isNotNullEmpty(name, "El Nombre del Usuario");    
    resUsu &= op.isNameCorrect(name, "El Nombre del Usuario");
    
    sendMsg(res);
})
function sendMsg(res){    
    
    if(res){msg.correct();}else{msg.danger();}
}

