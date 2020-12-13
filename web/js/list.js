let gameList = document.getElementById('gameList');
let hoursList = document.getElementById('hoursList');
let employeeList = document.getElementById('employeeList');
let clientList = document.getElementById('clientList');

function getFetch(url){
    return fetch(url)
    .then(response => response.json())    
}

gameList.addEventListener('click', async() => {
	var games = await getFetch('URL LISTA DE JUEGOS');
	let tableGames = "";
	tableGames = tableGames + "<tr> <th>Id</th> <th>Nombre</th> <th>Edad Minima</th> <th>Capacidad</th> <th>Categoria</th> </tr>";
	games.forEach(element => {
		tableGames = tableGames + ui.drawListGames(element);
	})
})

hoursList.addEventListener('click', async() => {
	var hours = await getFetch('URL LISTA DE HORAS');
	let tableHours = "";
	tableHours = tableHours + "<tr> <th>Id</th> <th>Hora Inicio</th> <th>Hora Fin</th> </tr>";
	hours.forEach(element => {
		tableHours = tableHours + ui.drawListHours(element);
	})
})

employeeList.addEventListener('click', async() => {
	var emp = await getFetch('URL LISTA DE EMPLEADOS');
	let tableEmp = "";
	tableEmp = tableEmp + "<tr> <th>Id</th> <th>Nombre</th> <th>Apellido</th> </tr>";
	emp.forEach(element => {
		tableEmp = tableEmp + ui.drawListEmployee(element);		
	})
})

clientList.addEventListener('click', async() => {
	var cli = await getFetch('URL A LISTA DE CLIENTES');
	let tableClient = "";
	tableClient = tableClient + "<tr> <th>Id</th> <th>Nombre</th> <th>Apellido</th> <th>DNI</th> <th>Telefono</th> <th>Mail</th> </tr>";
	cli.forEach(element => {
		tableClient = tableClient + ui.drawListClient(element);
	})
})