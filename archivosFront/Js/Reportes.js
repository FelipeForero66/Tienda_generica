const entrarClientes = () =>{
    location.href="http://127.0.0.1:5500/ReporteClientes.html";
}

const entrarProductos = () =>{
    location.href="http://127.0.0.1:5500/ReporteProductos.html";
}

const entrarVentas = () =>{
    location.href="http://127.0.0.1:5500/ReporteVentas.html";
}

const regresarReportes = () =>{
    location.href="http://127.0.0.1:5500/Reportes.html";
}


const entrarReportes = () =>{
    $('#reporte1').on('click', function(){
        entrarClientes();
    }
)}

const entrarReportes1 = () =>{
    $('#reporte2').on('click', function(){
        entrarProductos();
    }
)}
const entrarReportes2 = () =>{
    $('#reporte3').on('click', function(){
        entrarVentas();
    }
)}

const regresarReportes1 = () =>{
    $('#retornar1').on('click', function(){
        regresarReportes();
    }
)}

const regresarReportes2 = () =>{
    $('#retornar2').on('click', function(){
        regresarReportes();
    }
)}


const regresarReportes3 = () =>{
    $('#retornar3').on('click', function(){
        regresarReportes();
    }
)}


entrarReportes();
entrarReportes1();
entrarReportes2();
regresarReportes1();
regresarReportes2();
regresarReportes3();