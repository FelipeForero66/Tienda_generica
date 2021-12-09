$(document).ready(()=>{
    

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
                    <tr alumnoId = ${res.id}>
                    <td>${res.id}</td>
                    <td>${res.idTipoDocumento.id}</td>
                    <td>${res.idTipoDocumento.tipo}</td>
                    <td>${res.numeroDocumento}</td>
                    <td>${res.nombre}</td>
                    <td>${res.direccion}</td>
                    <td>${res.telefono}</td>
                    <td>${res.email}</td>
                    <td>${res.sede}</td>
                    <tr/>
                    `
                    $('#IdCliente').val(res.id);
                    $('#SedeCliente').val(res.sede);
                    $('#tbody1').html(data); 

                
                }
                
            })
            
           
        })
    }

    const reset = () =>{
        $('#numeroDocumento').val('');
        $('#usuario').val('');
        $('#numeroUsuario').val('');
        $('#usuarioDatosUsuario').val('');
        $('#numeroIdProducto1').val('');
        $('#nombre1').val('');
        $('#valorCompra1').val('');
        $('#iva1').val('');
        $('#total1').val('');

        $('#numeroArticulos').val('');
        $('#totalArticulos').val('');
        $('#numeroIdProducto2').val('');
        $('#nombre2').val('');
        $('#valorCompra2').val('');
        $('#iva2').val('');

        $('#total2').val('');
        $('#numeroArticulos1').val('');
        $('#totalArticulos1').val('');
        $('#numeroIdProducto3').val('');
        $('#nombre3').val('');
        $('#valorCompra3').val('');
        $('#iva3').val('');
        $('#total3').val('');
        $('#numeroArticulos3').val('');
        $('#totalArticulos2').val('');
        $('#idCliente').val('');
        $('#idUsuario').val('');
        $('#ivaVenta').val('');
        $('#valorVenta').val('');
        $('#totalVenta').val('');
       

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
                
                url:'http://localhost:8090/tiendagenerica/v1/buscarUsuario',
                contentType: 'application/json',
                type:'POST',
                data: JSON.stringify(cedulaUsuario),
                dataType: 'json',
                success: (element) => {
                   console.log(element);
                 let data = '';
                    data=`
                    <tr usuarioId = ${element.id}>
                    <td>${element.id}</td>
                    <td>${element.idTipoDocumento.id}</td>
                    <td>${element.idTipoDocumento.tipo}</td>
                    <td>${element.numeroDocumento}</td>
                    <td>${element.nombre}</td>
                    <td>${element.nombreUsuario}</td>
                    <td>${element.sede}</td>
                    `
                    $('#IdUsuario').val(element.id);
                    $('#tbody2').html(data); 
                    
                
                }
                
            })
            
           
        })
    }

    const Producto1 = () =>{
        $(document).on('click','#producto1', function(){
         

            /*const cedulaAlumno = {
                id: $('#numeroIdProducto1').val(),
            }*/

            
            const id = $('#numeroIdProducto1').val();
            
            $.ajax({
                url: 'http://localhost:8090/tiendagenerica/v1/productoId/' + id,
                type:'GET',
                dataType: 'json',
               success:(res) => {
                console.log(res);
                $('#numeroIdProducto1').val(res.id);
                $('#iva1').val(res.ivaCompra);
                $('#nombre1').val(res.nombre);
                $('#valorCompra1').val(res.precioCompra);
                $('#total1').val(res.precioVenta);
                
               }
            })


           
        })

        
    }

    const Producto2 = () =>{
        $(document).on('click','#producto2', function(){
         

            /*const cedulaAlumno = {
                id: $('#numeroIdProducto1').val(),
            }*/

            
            const id = $('#numeroIdProducto2').val();
            
            $.ajax({
                url: 'http://localhost:8090/tiendagenerica/v1/productoId/' + id,
                type:'GET',
                dataType: 'json',
               success:(res) => {
                console.log(res);
                $('#numeroIdProducto2').val(res.id);
                $('#iva2').val(res.ivaCompra);
                $('#nombre2').val(res.nombre);
                $('#valorCompra2').val(res.precioCompra);
                $('#total2').val(res.precioVenta);
                
               }
            })


           
        })

        
    }

    const Producto3 = () =>{
        $(document).on('click','#producto3', function(){
         

            /*const cedulaAlumno = {
                id: $('#numeroIdProducto1').val(),
            }*/

            
            const id = $('#numeroIdProducto3').val();
            
            $.ajax({
                url: 'http://localhost:8090/tiendagenerica/v1/productoId/' + id,
                type:'GET',
                dataType: 'json',
               success:(res) => {
                console.log(res);
                $('#numeroIdProducto3').val(res.id);
                $('#iva3').val(res.ivaCompra);
                $('#nombre3').val(res.nombre);
                $('#valorCompra3').val(res.precioCompra);
                $('#total3').val(res.precioVenta);
                
               }
            })


           
        })

        
    }


    
    const total1 = () =>{
       $(document).on('click','#totalProducto1', function(){
           let final45 = $('#total1').val();
           let final56 = final45 * $('#numeroArticulos').val();
           $('#totalArticulos').val(final56);
        })
        
    }

    const total2 = () =>{
        $(document).on('click','#totalProducto2', function(){
            let final45 = $('#total2').val();
            let final56 = final45 * $('#numeroArticulos1').val();
            $('#totalArticulos1').val(final56);
         })
         
     }

     const total3 = () =>{
        $(document).on('click','#totalProducto3', function(){
            let final45 = $('#total3').val();
            let final56 = final45 * $('#numeroArticulos3').val();
            $('#totalArticulos2').val(final56);
         })
         
     }

     const RalizarVenta = () =>{
        $(document).on('click','#btn-edit', function(){
                $('#idCliente').val(res.idTipoDocumento.id);
                $('#idUsuario').val(res.idTipoDocumento.tipo);
                $('#ivaVenta').val(res.numeroDocumento);
                $('#valorVenta').val(res.nombre);
                $('#totalVenta').val(res.direccion);
               
            
        })
    }



     const sumas = () =>{
        $('#totalSumas').on('click', function(){

            let IdCliente1 = $('#IdCliente').val();
            let ValorClientel11= parseInt(IdCliente1);

            let IdUsuario1 = $('#IdUsuario').val();
            let ValorClientel22= parseInt(IdUsuario1);

            let Sede1 = $('#SedeCliente').val();
            let ValorSede= parseInt(Sede1);

            let ValorCompral1 = $('#valorCompra1').val();
            let ValorCompral11= parseInt(ValorCompral1);
            let ValorCompral2 = $('#valorCompra2').val();
            let ValorCompral22= parseInt(ValorCompral2);
            let ValorCompral3 = $('#valorCompra3').val();
            let ValorCompral33= parseInt(ValorCompral3);

            let ValorIval1 = $('#iva1').val();
            let ValorIval11= parseInt(ValorIval1);
            let ValorIval2 = $('#iva2').val();
            let ValorIval22= parseInt(ValorIval2);
            let ValorIval3 = $('#iva3').val();
            let ValorIval33= parseInt(ValorIval3);

            let ValorFinal1 = $('#totalArticulos').val();
            let ValorFinal11= parseInt(ValorFinal1);
            let ValorFinal2 = $('#totalArticulos1').val();
            let ValorFinal22= parseInt(ValorFinal2);
            let ValorFinal3 = $('#totalArticulos2').val();
            let ValorFinal33= parseInt(ValorFinal3);

            let ValorCompra4 = ValorCompral11 + ValorCompral22 +ValorCompral33;
            let ValorIva4 = ValorIval11 + ValorIval22 +ValorIval33;
            let ValorFinal4 = ValorFinal11 + ValorFinal22 +ValorFinal33;
            
        
        

            $('#totalVenta').val(ValorFinal4);
            $('#ivaVenta').val(ValorIva4);
            $('#valorVenta').val(ValorCompra4);
            $('#idCliente').val(ValorClientel11);
            $('#idUsuario').val(ValorClientel22);
            $('#sede').val(ValorSede);
           
        })
    }

    const saveVenta = () =>{
        $('#realizarVentas').on('click', function(){

            const datosVenta= {
                idCliente: $('#idCliente').val(),
                idUsuario: $('#idUsuario').val(),
                ivaVenta: $('#ivaVenta').val(),
                totalVenta: $('#totalVenta').val(),
                valorVenta: $('#valorVenta').val(),
                sede:  $('#sede').val()
            }

            console.log(datosVenta.idCliente);
            console.log(datosVenta.idUsuario);
    
            $.ajax({
                
                url:'http://localhost:8090/tiendagenerica/v1/nuevaVenta',
                contentType: 'application/json',
                type:'POST',
                data: JSON.stringify(datosVenta),
                dataType: 'json',
                success: (data) => {
                    $('#mensaje').html('Venta realizada con exito').css('display', 'block');
    
                    alert("Alumno registrado");

                    reset();
                }
            })
        })
    }


    buscarCliente();
    buscarUsuario();
    Producto1();
    Producto2();
    Producto3();
    total1();
    total2();
    total3();
    sumas();
    saveVenta();
})