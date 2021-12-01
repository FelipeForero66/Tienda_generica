$(document).ready(()=>{
    alert('Sludos desde main.js con JS6');

    

    const list = () =>{
        $.ajax({
            url:'http://localhost:8090/tiendagenerica/v1/proveedor',
            type:'GET',
            dataType: 'json',
            success: function(res){
                console.log(res);
                let data = '';
                res.forEach(element => {
                    data+=`
                    <tr alumnoId = ${element.id}>
                    <td>${element.id}</td>
                    <td>${element.ciudad}</td>
                    <td>${element.direccion}</td>
                    <td>${element.telefono}</td>
                    <td>${element.nombre}</td>
                    <td>${element.nit}</td>
                    <td>
                    <button id="btn-details" class="btn btn-warning">Detalles</button>
                    </td>
                    <td>
                    <button id="btn-delete" class="btn btn-danger">Eliminar</button>
                    </td>
                    <td>
                    <button id="btn-edit" class="btn btn-success">Editar</button>
                    </td>
                    <tr/>
                    `
                });
    
                $('#tbody').html(data);
    
            }
        })
    }

     const reset = () =>{
                $('#ciudad').val('');
                $('#direccion').val('');
                $('#nombre').val('');
                $('#telefono').val('');
                $('#nit').val('');
    }

    const save = () =>{
        $('#agregar').on('click', function(){
            const datosAlumnos = {
                ciudad: $('#ciudad').val(),
                direccion: $('#direccion').val(),
                nombre: $('#nombre').val(),
                telefono: $('#telefono').val(),
                nit: $('#nit').val()
            }

            $.ajax({
                
                url:'http://localhost:8090/tiendagenerica/v1/proveedor',
                contentType: 'application/json',
                type:'POST',
                data: JSON.stringify(datosAlumnos),
                dataType: 'json',
                success: (data) => {
                    $('#mensaje').html('Exito al crear el alumno').css('display', 'block');
                    list();
                    reset();

                    alert("Alumno registrado");
                }
            })
        })
    }

    const buscar = () =>{
        $(document).on('click','#btn-details', function(){
            let btnDetails = $(this)[0].parentElement.parentElement;

            //el attr es para identificar que es un atributo, un atributo es una caracteistica espesifica la cual en este caso es 
            // tr al cual le estoy pasando el alumnoId con el valor del id que quiero capturar, por tal motivo nombro el atributo como:
            // alumnoId parapoder identificarlo.

            
            alert("boton mapeado");

            let id = $(btnDetails).attr('alumnoId');
            console.log(id);
            $.ajax({
                url: 'http://localhost:8090/tiendagenerica/v1/proveedor/' + id,
                type:'GET',
                dataType: 'json',
               success:(res) => {
                console.log(res);
                let data =`
                <strong> ID </strong> : ${res.id} <br>
                <strong>Ciudad </strong> : ${res.ciudad}<br>
                <strong> Dirección </strong> : ${res.direccion}<br>
                <strong> Nombre </strong> : ${res.nombre}<br>
                <strong> Numero </strong> : ${res.telefono}<br><br>

                <button id="btn-limpiar" class="btn btn-warning">Limpiar</button>

                 `

                let alumno = $('#alumno-details').html(data);

                $('#btn-limpiar').on('click', () =>{
                    alumno.html('');
                })
               }


            })

           
        })
    }

   const deleteUsuario = () =>{

        $(document).on('click','#btn-delete', function(){

            if(confirm('Esta seguro que desea aliminar ?')){
                let btnDelte = $(this)[0].parentElement.parentElement;
                let id = $(btnDelte).attr('alumnoId');
                console.log(id);
    
                $.ajax({
                    url : 'http://localhost:8090/tiendagenerica/v1/proveedor/' + id,
                    type: 'DELETE',
                    dataType: 'json',
                    success:(res) =>{
                       
    
                        $('#mensaje').html('Usuario Elimnado').css('display', 'block');
                        list();
                    }
                })     
            }
        })
    }

    const TraerAlumno = () =>{
        $(document).on('click','#btn-edit', function(){
            let btnEdit = $(this)[0].parentElement.parentElement;
            let id = $(btnEdit).attr('alumnoId');
            console.log(id);

            $('#agregar').hide();
            $('#editar').show();

            $.ajax({
                url: 'http://localhost:8090/tiendagenerica/v1/proveedor/' + id,
                type:'GET',
                dataType: 'json',
               success:(res) => {
                console.log(res);
                $('#id').val(res.id);
                $('#ciudad').val(res.ciudad);
                $('#direccion').val(res.direccion);
                $('#nombre').val(res.nombre);
                $('#telefono').val(res.telefono);
                $('#nit').val(res.nit);
               }
            })
        })
    }

     const editarAlumno = () => {
        $('#editar').on('click', function(){
            let id = $('#id').val();
            $('#agregar').css('display', 'none');
            $('#editar').css('display', 'block');


            const datosAlumnos = {
                id: $('#id').val(),
                ciudad: $('#ciudad').val(),
                direccion: $('#direccion').val(),
                nombre: $('#nombre').val(),
                telefono: $('#telefono').val(),
                nit: $('#nit').val()
            }
            console.log(datosAlumnos.id);
            $.ajax({
                url:'http://localhost:8090/tiendagenerica/v1/proveedor',
                contentType: 'application/json',
                type:'POST',
                data: JSON.stringify(datosAlumnos),
                dataType: 'json',
                success: (res) => {
                    $('#mensaje').html('Alumno Modificado').css('display', 'block');
                    $('#editar').css('display', 'none');
                    $('#agregar').css('display', 'block');

                    reset();
                    list();

                }

            })
        }
    
    )}

    /*let validar = document.getElementById("idTipoDocumento");

    const valor =() =>{
        if(validar ==! null){
            if(validar<5 || validar>7){
                alert("porfavor introdzca un valor valido");
            }else{
                alert("valor correcto");
            }
        }
        
    }
*/
    buscar();
    save();
    list(); 
    //valor(); 
    deleteUsuario(); 
    TraerAlumno();
    editarAlumno();
    //enviarUsuarios();
})