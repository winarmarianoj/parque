/* global op, msg */

const changeCli = document.getElementById('changeCliente');

changeCli.addEventListener('click', () => {
			 
    let id = document.getElementById('idchangeCliente').value;
    let name = document.getElementById('nombreCliente').value;
    let ape = document.getElementById('apellidoCliente').value;
    let dni = document.getElementById('dniCliente').value;
    let tel = document.getElementById('telefonoCliente').value;
    let mail = document.getElementById('mailCliente').value;
    
    let res = op.isNotNullEmpty(id, "El Id");
    res &= op.isNumber(id, "El Id");
    
    res &= op.isNotNullEmpty(name, "El Nombre");  
    res &= op.isNameCorrect(name, "El Nombre"); 
    
    res &= op.isNotNullEmpty(ape, "El Apellido");  
    res &= op.isNameCorrect(ape, "El Apellido");
    
    res &= op.isNotNullEmpty(dni, "El DNI");
    res &= op.isNumber(dni, "El DNI");
    
    res &= op.isNotNullEmpty(tel, "El Telefono");
    res &= op.isNumber(tel, "El Telefono");
    
    res &= op.isNotNullEmpty(mail, "El Mail");  
    res &= op.isEmailCorrect(mail, "El Mail"); 
    
    sendMsg(res);
})

function sendMsg(res){   
    
    if(res){msg.correct();}else{msg.danger();}
}