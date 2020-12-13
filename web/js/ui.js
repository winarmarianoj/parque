class UI {
    //LISTADO DE JUEGOS
    drawListGames(element) {
        var tbody = document.querySelector('#reportTable tbody');
        tbody.innerHTML = '';
        var row = tbody.insertRow(i),           
            idCell = row.insertCell(0),
            nombreCell = row.insertCell(1),
            edadMinimaCell = row.insertCell(2),
            capacidadCell = row.insertCell(3),
            categoriaCell = row.insertCell(4);

        idCell.innerHTML = element.id;    
        nombreCell.innerHTML = element.nombre;
        edadMinimaCell.innerHTML = element.edadMinima;
        capacidadCell.innerHTML = element.capacidad;
        categoriaCell.innerHTML = element.categoria;  

        tbody.appendChild(row);
    }

    //LISTADO DE HORARIOS
    drawListHours(element) {
        var tbody = document.querySelector('#reportTable tbody');
        tbody.innerHTML = '';
        var row = tbody.insertRow(i),           
            idCell = row.insertCell(0),
            hora_inicioCell = row.insertCell(1),
            hora_finCell = row.insertCell(2);

        idCell.innerHTML = element.id;    
        hora_inicioCell.innerHTML = element.hora_inicio;
        hora_finCell.innerHTML = element.hora_fin;

        tbody.appendChild(row);   
    }

    //LISTADO DE EMPLEADOS
    drawListEmployee(element) {
        var tbody = document.querySelector('#reportTable tbody');
        tbody.innerHTML = '';
        var row = tbody.insertRow(i),           
            idCell = row.insertCell(0),
            nombreCell = row.insertCell(1),
            apellidoCell = row.insertCell(2);

        idCell.innerHTML = element.id;    
        nombreCell.innerHTML = element.nombre;
        apellidoCell.innerHTML = element.apellido;

        tbody.appendChild(row);   
    }

    //LISTADO DE CLIENTES
    drawListClient(element) {
        var tbody = document.querySelector('#reportTable tbody');
        tbody.innerHTML = '';
        var row = tbody.insertRow(i),           
            idCell = row.insertCell(0),
            nombreCell = row.insertCell(1),
            apellidoCell = row.insertCell(2),
            dniCell = row.insertCell(3),
            telefonoCell = row.insertCell(4),
            mailCell = row.insertCell(5);

        idCell.innerHTML = element.id;    
        nombreCell.innerHTML = element.nombre;
        apellidoCell.innerHTML = element.apellido;
        dniCell.innerHTML = element.dni;
        telefonoCell.innerHTML = element.telefono;  
        mailCell.innerHTML = element.mail;  

        tbody.appendChild(row);
    }    

    //INFORME SOBRE EL PRIMER QUERY SOLICITADO EN EL TP
    drawQuery1(query1,anio,mes,dia){
        const info = document.getElementById('queries');
        const primer = document.createElement('div');

        primer.innerHTML = `
            <div class="card my-3">
                <div class="card userName d-flex justify-content-center">
                    <p><b>Cantidad de entradas vendidas en un determinado día (de todos los juegos)</b></p>
                </div>               
                <div class="card my-3 card-body pt-0 pb-2">
                    <p>Del día : ${anio}:${mes}:${dia}</p>
                </div>
                <div class="card my-3 card-body pt-0 pb-2">
                    <p>La cantidad de : ${query1}</p>
                </div>        
            </div>
        `;
        info.appendChild(primer);
    }

    //INFORME DEL SEGUNDO QUERY SOLICITADO EN EL TP
    drawQuery2(query2,anio,mes,dia,nameGame){
        const info = document.getElementById('queries');
        const primer = document.createElement('div');

        primer.innerHTML = `
            <div class="card my-3">
                <div class="card userName d-flex justify-content-center">
                    <p><b>Cantidad de entradas vendidas en un determinado día (de todos los juegos)</b></p>
                </div>               
                <div class="card my-3 card-body pt-0 pb-2">
                    <p>Del día : ${anio}:${mes}:${dia}</p>                    
                </div>
                <div class="card my-3 card-body pt-0 pb-2">
                    <p>Nombre del Juego es _ ${nameGame}</p>
                </div>        
                <div class="card my-3 card-body pt-0 pb-2">
                    <p>La cantidad de : ${query2}</p>
                </div>        
            </div>
        `;
        info.appendChild(primer);   
    }

    //LISTADO DE EMPLEADOS ENCARGADOS DE UN MISMO JUEGO
    drawQuery3(element, nameGame){
        var tbody = document.querySelector('#queryTable tbody');
        tbody.innerHTML = '';
        var row = tbody.insertRow(i),           
            idCell = row.insertCell(0),
            nombreCell = row.insertCell(1),
            apellidoCell = row.insertCell(2);
            nameGameCell = row.insertCell(3);

        idCell.innerHTML = element.id;    
        nombreCell.innerHTML = element.nombre;
        apellidoCell.innerHTML = element.apellido;
        nameGameCell.innerHTML = nameGame;

        tbody.appendChild(row);   
    }

}
const ui = new UI();

