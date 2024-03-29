$(document).ready(()=>{
    

    

    const list = () =>{
        const sede = 1;
        $('#Sede').val(sede);
        $.ajax({
            url:'http://localhost:8090/tiendagenerica/v1/usuariosNuevoFront',
            type:'GET',
            dataType: 'json',
            success: function(res){
               
                let data = '';

                res.forEach(element => {

                    if(element.sede==1) {
                        data+=`
                        <tr alumnoId = ${element.id}>
                        <td>${element.id}</td>
                        <td>${element.idTipoDocumento.id}</td>
                        <td>${element.idTipoDocumento.tipo}</td>
                        <td>${element.numeroDocumento}</td>
                        <td>${element.nombre}</td>
                        <td>${element.nombreUsuario}</td>
                        <td>${element.email}</td>
                        <td>${element.sede}</td>
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
                    }
                   
                    
                });
                
                $('#tbody').html(data);
    
            }
        })
    }

    const loginsede1 = () =>{
      
        const usuario = {
            nombreUsuario: $('#Usuario').val(),
            password: $('#pwd').val() 
        }

            $.ajax({
                
                url:'http://localhost:8090/tiendagenerica/v1/loginSedes',
                contentType: 'application/json',
                type:'POST',
                data: JSON.stringify(usuario),
                dataType: 'json',
                success: (data) => {
                    entrar();
                }
            })
        }
    
    

     const reset = () =>{
                $('#idTipoDocumento').val('');
                $('#numeroDocumento').val('');
                $('#nombre').val('');
                $('#password').val('');
                $('#nombreUsuario').val('');
                $('#email').val('');
                $('#sede').val('');
    }

    const entrar = () =>{
        location.href="http://127.0.0.1:5500/PaginaCrud.html";
    }

    const entrar2 = () =>{
        location.href="http://127.0.0.1:5500/Usuarios2Cali.html";
    }

    const entrar3 = () =>{
        location.href="http://127.0.0.1:5500/Usuarios3Medellin.html";
    }

    const enviarUsuarios = () =>{
        $('#loging').on('click', function(){
            const usuario = {
                nombreUsuario: $('#Usuario').val(),
                password: $('#pwd').val() 
            }

        $.ajax({
            url: 'http://localhost:8090/tiendagenerica/v1/loginSedes',
            contentType: 'application/json',
            type:'POST',
            data: JSON.stringify(usuario),
            dataType: 'json',
           success:(data) => {
            console.log(data.sede);
            if(1 == data.sede){
                
                entrar();
            }
            if(2 == data.sede){
                entrar2();
            }
            if(3 == data.sede){
                entrar3();
            }

            if(1 ==! data.sede || 2 ==! data.sede || 3 ==! data.sede ){
                alert("usuario no encontrado, intentelo denuevo");
            }
            
           
           }

        })
        })
    }

    const save = () =>{
        $('#agregar').on('click', function(){
            
            const datosAlumnos = {
                sede: $('#Sede').val(),
                idTipoDocumento: $('#idTipoDocumento').val(),
                numeroDocumento: $('#numeroDocumento').val(),
                nombre: $('#nombre').val(),
                password: $('#password').val(),
                nombreUsuario: $('#nombreUsuario').val(),
                email: $('#email').val()
                
            }

            $.ajax({
                
                url:'http://localhost:8090/tiendagenerica/v1/NuevoUsuarioNuevoFront',
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
                url: 'http://localhost:8090/tiendagenerica/v1/usuariosNuevoFront/' + id,
                type:'GET',
                dataType: 'json',
               success:(res) => {
                console.log(res);
                let data =`
                <strong> ID </strong> : ${res.id} <br>
                <strong>Tipo Documento </strong> : ${res.idTipoDocumento.tipo}<br>
                <strong> Documento </strong> : ${res.numeroDocumento}<br>
                <strong> Nombre </strong> : ${res.nombre}<br>
                <strong> Usuario </strong> : ${res.nombreUsuario}<br>
                <strong> Sede </strong> : ${res.sede}<br><br>
                 <strong> Email </strong> : ${res.email}<br><br>

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
                    url : 'http://localhost:8090/tiendagenerica/v1/usuariosNuevoFront/' + id,
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
                url: 'http://localhost:8090/tiendagenerica/v1/usuariosNuevoFront/' + id,
                type:'GET',
                dataType: 'json',
               success:(res) => {
                console.log(res);
                $('#TipoDocumento').val(res.idTipoDocumento.id);
                $('#idTipoDocumento').val(res.idTipoDocumento.tipo);
                $('#numeroDocumento').val(res.numeroDocumento);
                $('#nombre').val(res.nombre);
                $('#password').val(res.password);
                $('#nombreUsuario').val(res.nombreUsuario);
                $('#email').val(res.email);
                $('#id').val(res.id);
                $('#sede').val(res.sede);
               }
            })
        })
    }

    const editarAlumno = () => {
        $('#editar').on('click', function(){
            let id = $('#id').val();
            $('#agregar').css('display', 'none');
            $('#editar').css('display', 'block');

            const TipoDocumento ={
                id: $('#TipoDocumento').val(),
                tipo: $('#idTipoDocumento').val()
            }

            const datosAlumnos = {
                id: $('#id').val(),
                idTipoDocumento: $('#TipoDocumento').val(),
                numeroDocumento: $('#numeroDocumento').val(),
                nombre: $('#nombre').val(),
                password: $('#password').val(),
                nombreUsuario: $('#nombreUsuario').val(),
                email: $('#email').val(),
                sede: $('#Sede').val(),
            }
            console.log(datosAlumnos.id);
            $.ajax({
                url:'http://localhost:8090/tiendagenerica/v1/NuevoUsuarioNuevoFront',
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

    let validar = document.getElementById("idTipoDocumento");

    const valor =() =>{
        if(validar ==! null){
            if(validar<5 || validar>7){
                alert("porfavor introdzca un valor valido");
            }else{
                alert("valor correcto");
            }
        }
        
    }

    buscar();
    save();
    list(); 
    valor(); 
    deleteUsuario(); 
    TraerAlumno();
    editarAlumno();
    enviarUsuarios();
})