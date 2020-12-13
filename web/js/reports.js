let amountInputByDay = document.getElementById('amountInputByDay');
let amountInputByDayGameEmployee = document.getElementById('amountInputByDayGameEmployee');
let employeeListByGame = document.getElementById('employeeListByGame');

amountInputByDay.addEventListener('click', async() => {	
	let anio = document.getElementById('anio').value;
	let mes = document.getElementById('mes').value;
	let dia = document.getElementById('dia').value;

	var info = {
		anio : anio,
		mes : mes,
		dia : dia
	}

	let fecha = JSON.stringify(info);

	anio.value = "";
	mes.value = "";
	dia.value = "";

	fetch('URL AL QUERY 1', {
        method: 'POST',
        body: fecha
    })
    .then(response => response.json())
    .then(json => {
    	ui.drawQuery1(json,anio,mes,dia);
    })
    .catch(function(err) {
        op.saveErrorsList(err);
        msg.danger()
    });
})

amountInputByDayGameEmployee.addEventListener('click', async() => {
	let anio = document.getElementById('anio').value;
	let mes = document.getElementById('mes').value;
	let dia = document.getElementById('dia').value;
	let nameGame = document.getElementById('gameName').value;

	var info = {
		anio : anio,
		mes : mes,
		dia : dia,
		nameGame : nameGame
	}

	let query2 = JSON.stringify(info);

	anio.value = "";
	mes.value = "";
	dia.value = "";
	gameName.value = "";

	fetch('URL AL QUERY 2', {
        method: 'POST',
        body: query2
    })
    .then(response => response.json())
    .then(json => {
    	ui.drawQuery2(json,anio,mes,dia,nameGame);
    })
    .catch(function(err) {
        op.saveErrorsList(err);
        msg.danger()
    });
})

employeeListByGame.addEventListener('click', async() => {
	let nameGame = document.getElementById('gameName').value;
	let info = JSON.stringify(nameGame);
	gameName.value = "";

	let tableQuery3 = "";
	tableQuery3 = tableQuery3 + "<tr> <th>Id</th> <th>Nombre</th> <th>Apellido</th> <th>Nombre del Juego</th> </tr>";

	fetch('URL AL QUERY 3', {
        method: 'POST',
        body: info
    })
    .then(response => response.json())
    .then(json => {
    	json.forEach(element => {
			tableQuery3 = tableQuery3 + ui.drawQuery3(element,nameGame);
		})	
    })
    .catch(function(err) {
        op.saveErrorsList(err);
        msg.danger()
    });
	
})