// Funcion que me trae del Login HTML
function formLogin(btnLogin) {    

    var loged = {
        userName : document.getElementById('userName').value,
        password : btoa(document.getElementById('password').value)
    };	

	let resLogin = op.isNotNullEmpty(loged.userName,"El Nombre de Usuario");
    resLogin &= op.isEmailCorrect(loged.userName,"El Nombre de Usuario");
    resLogin &= op.isNotNullEmpty(loged.password,"La Contraseña");
	resLogin &= op.isPassCorrect(loged.password,"La Contraseña");

    if (resLogin){sendingLoged(JSON.stringify(loged));}
}

// Funcion que envia el Post con los datos del logueo
function sendingLoged(dataLogin) {
    fetch('http://localhost:8082/GamePark/rest/user/login', {
        method: 'POST',
        body: dataLogin
    })
    .then(response => response.json())
    .then(json => {
        if(json !== null){
            sessionStorage.setItem('user', JSON.stringify(json))
            msg.correct()
            window.location.href = "dashboard.html";
        }else{
            msg.invalidPassword("Verifique que los datos sean correctos")
        }
    })
    .catch(function(err) {
        op.saveErrorsList(err);
        msg.danger()
    });
}

// funcion que me trae del Forgot HTML
function formForgot(btnForgot) {

    var pass2 = document.getElementById('password2').value;

    var forgot = {
        userName : document.getElementById('userName').value,
        password : document.getElementById('password1').value
    };    	
    let resForgot = op.isNotNullEmpty(forgot.userName,"El Nombre del Usuario");
    resForgot &= op.isEmailCorrect(forgot.userName,"El Nombre del Usuario");
    resForgot &= op.isNotNullEmpty(forgot.password,"La Contraseña");
    resForgot &= op.isPassCorrect(forgot.password,"La Contraseña");
    resForgot &= op.isPasswordEquals(forgot.password,pass2);

    if (resForgot){sendingForgot(JSON.stringify(forgot));}        
}
function sendingForgot(dataForgot) {    
    fetch('http://localhost:8082/GamePark/rest/user/forgot', {
        method: 'POST',
        body: dataForgot
    })
    .then(response => response.json()
    .then(data => {
        if (data) {
            msg.correct()
            window.location.href = "login.html"; 
        } else {
            throw 'Error en la llamada a Ajax en Login';
        }
    })    
    .catch(function(err) {
        op.saveErrorsList(err);
        msg.danger()
    }));
}
