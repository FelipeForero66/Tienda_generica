$(document).ready(()=>{
  

    const list = () =>{
        $.ajax({
            url:'http://localhost:8090/tiendagenerica/v1/clientes',
            type:'GET',
            dataType: 'json',
            success: function(res){
                console.log(res);
                let data = '';
                res.forEach(element => {
                    data+=`
                    <tr alumnoId = ${element.id}>
                    <td>${element.id}</td>
                    <td>${element.idTipoDocumento.id}</td>
                    <td>${element.idTipoDocumento.tipo}</td>
                    <td>${element.numeroDocumento}</td>
                    <td>${element.nombre}</td>
                    <td>${element.telefono}</td>
                    
                    <tr/>
                    `
                });
    
                $('#tbody').html(data);
            }
        })
    }

    const listProductos = () =>{
        $.ajax({
            url:'http://localhost:8090/tiendagenerica/v1/productos',
            type:'GET',
            dataType: 'json',
            success: function(res){
                console.log(res);
                let data = '';
                res.forEach(element => {
                    data+=`
                    <tr alumnoId = ${element.id}>
                    <td>${element.id}</td>
                    <td>${element.idProveedor.id}</td>
                    <td>${element.ivaCompra}</td>
                    <td>${element.nombre}</td>
                    <td>${element.precioCompra}</td>
                    <td>${element.precioVenta}</td>
                    
                    <tr/>
                    `
                });
    
                $('#tbody1').html(data);
    
            }
        })
    }

    const listVentas = () =>{
        $.ajax({
            url:'http://localhost:8090/tiendagenerica/v1/reporteVenta',
            type:'GET',
            dataType: 'json',
            success: function(res){
                console.log(res);
                let data = '';
                res.forEach(element => {
                    data+=`
                    <tr>
                    <td>${element.numeroDocumento}</td>
                    <td>${element.nombre}</td>
                    <td>${element.totalVenta}</td>
                   
                    <tr/>
                    `
                });
    
                $('#tbody2').html(data);
    
            }
        })
    }

    list();
    listProductos();
    listVentas();
})