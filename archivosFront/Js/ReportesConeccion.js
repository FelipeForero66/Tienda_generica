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

                    if(element.sede > 0){
                        data+=`
                    <tr>
                    <td>${element.numeroDocumento}</td>
                    <td>${element.nombre}</td>
                    <td>${element.totalVenta}</td>
                    <td>${element.sede}</td>
                    <tr/>
                    `
                    }
                    
                });
    
                $('#tbody2').html(data);
    
            }
        })
    }

    const listVentasTOTAL = () =>{
        $.ajax({
            url:'http://localhost:8090/tiendagenerica/v1/reporteVenta',
            type:'GET',
            dataType: 'json',
            success: function(res){
                console.log(res);
                let data = '';

                let totalClientes = 0;
                let sumaTotal = 0;
                let TOTALVENTAS1 = 0;
                let TOTALVENTASFINAL = 0;

                res.forEach(element => {
                    if(element.sede > 0){
                    TOTALVENTAS1 = element.totalVenta;
                    let ValorClientel11= parseInt(TOTALVENTAS1);
                    TOTALVENTASFINAL = ValorClientel11;

                    

                        totalClientes = totalClientes+1;
                        sumaTotal = sumaTotal + TOTALVENTASFINAL;
                        
                    }

                    
                    
                    
                });
                data+=`
                        <tr>
                        <td>${totalClientes}</td>
                        <td>${sumaTotal}</td>
                        <tr/>
                        `
    
                $('#tbody8').html(data);
    
            }
        })
    }

    const listVentasBogota = () =>{
        $.ajax({
            url:'http://localhost:8090/tiendagenerica/v1/reporteVenta',
            type:'GET',
            dataType: 'json',
            success: function(res){
                console.log(res);
                let data = '';

                let totalClientes = 0;
                let sumaTotal = 0;
                let TOTALVENTAS1 = 0;
                let TOTALVENTASFINAL = 0;

                res.forEach(element => {
                    if(element.sede == 1){
                    TOTALVENTAS1 = element.totalVenta;
                    let ValorClientel11= parseInt(TOTALVENTAS1);
                    TOTALVENTASFINAL = ValorClientel11;

                    

                        totalClientes = totalClientes+1;
                        sumaTotal = sumaTotal + TOTALVENTASFINAL;
                        
                    }

                    
                    
                    
                });
                data+=`
                        <tr>
                        <td>${totalClientes}</td>
                        <td>${sumaTotal}</td>
                        <tr/>
                        `
    
                $('#tbody3').html(data);
    
            }
        })
    }

    const listVentasCali = () =>{
        $.ajax({
            url:'http://localhost:8090/tiendagenerica/v1/reporteVenta',
            type:'GET',
            dataType: 'json',
            success: function(res){
                console.log(res);
                let data = '';

                let totalClientes = 0;
                let sumaTotal = 0;
                let TOTALVENTAS1 = 0;
                let TOTALVENTASFINAL = 0;

                res.forEach(element => {
                    if(element.sede == 2){
                    TOTALVENTAS1 = element.totalVenta;
                    let ValorClientel11= parseInt(TOTALVENTAS1);
                    TOTALVENTASFINAL = ValorClientel11;

                    

                        totalClientes = totalClientes+1;
                        sumaTotal = sumaTotal + TOTALVENTASFINAL;
                        
                    }

                    
                    
                    
                });
                data+=`
                        <tr>
                        <td>${totalClientes}</td>
                        <td>${sumaTotal}</td>
                        <tr/>
                        `
    
                $('#tbody4').html(data);
    
            }
        })
    }

    const listVentasMedellin = () =>{
        $.ajax({
            url:'http://localhost:8090/tiendagenerica/v1/reporteVenta',
            type:'GET',
            dataType: 'json',
            success: function(res){
                console.log(res);
                let data = '';

                let totalClientes = 0;
                let sumaTotal = 0;
                let TOTALVENTAS1 = 0;
                let TOTALVENTASFINAL = 0;

                res.forEach(element => {
                    if(element.sede == 3){
                    TOTALVENTAS1 = element.totalVenta;
                    let ValorClientel11= parseInt(TOTALVENTAS1);
                    TOTALVENTASFINAL = ValorClientel11;

                    

                        totalClientes = totalClientes+1;
                        sumaTotal = sumaTotal + TOTALVENTASFINAL;
                        
                    }

                    
                    
                    
                });
                data+=`
                        <tr>
                        <td>${totalClientes}</td>
                        <td>${sumaTotal}</td>
                        <tr/>
                        `
    
                $('#tbody5').html(data);
    
            }
        })
    }


    list();
    listProductos();
    listVentas();
    listVentasBogota();
    listVentasCali();
    listVentasMedellin();
    listVentasTOTAL();
})