$(document).ready(()=>{
    alert('Sludos desde main.js con JS6');

    const buscarCliente = () =>{
        $(document).on('click','#usuario', function(){
           
            const cedulaAlumno = {
                numeroDocumento: $('#numeroDocumento').val(),
            }
            //el attr es para identificar que es un atributo, un atributo es una caracteistica espesifica la cual en este caso es 
            // tr al cual le estoy pasando el alumnoId con el valor del id que quiero capturar, por tal motivo nombro el atributo como:
            // alumnoId parapoder identificarlo.
            alert("boton mapeado");

          
            $.ajax({
                
                url:'http://localhost:8090/tiendagenerica/v1/cliente/documentoNuevoFront',
                contentType: 'application/json',
                type:'POST',
                data: JSON.stringify(cedulaAlumno),
                dataType: 'json',
                success: (res) => {
                   console.log(res);
                let data = '';
                    data=`
                    <td>${res.id}</td>
                    <td>${res.idTipoDocumento.id}</td>
                    <td>${res.idTipoDocumento.tipo}</td>
                    <td>${res.numeroDocumento}</td>
                    <td>${res.nombre}</td>
                    <td>${res.direccion}</td>
                    <td>${res.telefono}</td>
                    <td>${res.email}</td>
                    `
                    $('#tbody1').html(data); 

                
                }
                
            })
            
           
        })
    }


    const buscarUsuario = () =>{
        $(document).on('click','#usuarioDatosUsuario', function(){
           
            const cedulaUsuario = {
                numeroDocumento: $('#numeroUsuario').val(),
            }
            //el attr es para identificar que es un atributo, un atributo es una caracteistica espesifica la cual en este caso es 
            // tr al cual le estoy pasando el alumnoId con el valor del id que quiero capturar, por tal motivo nombro el atributo como:
            // alumnoId parapoder identificarlo.
            alert("boton mapeado");

          
            $.ajax({
                
                url:'http://localhost:8090/tiendagenerica/v1/cliente/buscarUsuarioNuevoFront',
                contentType: 'application/json',
                type:'POST',
                data: JSON.stringify(cedulaUsuario),
                dataType: 'json',
                success: (res) => {
                   console.log(res);
                 /*let data = '';
                    data=`
                    <td>${res.id}</td>
                    <td>${res.idTipoDocumento.id}</td>
                    <td>${res.idTipoDocumento.tipo}</td>
                    <td>${res.numeroDocumento}</td>
                    <td>${res.nombre}</td>
                    <td>${res.direccion}</td>
                    <td>${res.telefono}</td>
                    <td>${res.email}</td>
                    `
                    $('#tbody1').html(data); 
                    */
                
                }
                
            })
            
           
        })
    }

    buscarCliente();
    buscarUsuario();
})