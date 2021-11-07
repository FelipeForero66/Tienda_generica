
/*$(document).ready(function(){
	alert('funciona');
})

$(window).on("load",function() {
						var i = 1;
						$('#add').click(function() {
											let producto =$("#producto").val();
											if(producto.length>0){
											console.log(producto);
											i++;
											$('#dynamic_field')
													.append(
															'<tr id="row'+i+'"><td><input type="text" name="idProducto[]" readonly/></td><td><input type="text" name="nombre[]" readonly/></td><td><input type="text" name="Cantidad[]" /></td><td><input type="text" name="valorUnitario[]" readonly/></td><td><input type="text" name="iva[]" readonly/></td><td><input type="text" name="valorTotal[]" readonly/></td><td><button type="button" name="remove" id="'+i+'" class="btn btn-danger btn_remove">X</button></td></tr>');

											$("#producto").val("");
											}else{
												alert("producto invalido")
												
											}
											});

						$(document).on('click', '.btn_remove', function() {
							var button_id = $(this).attr("id");
							$('#row' + button_id + '').remove();
						});

					});

$(document).ready(function(){
	
	$ajax({
		url:'http://localhost:8090/tiendagenerica/v1/cliente',
		type:'GET',
		dataType:'json',
		success: function(res){
			console.log(res);
		}
	})	
	
					
/*const cliente = () =>{
	
	$('#buscar').on('click', function()	{
		const buscarCliente = {
			cedula: $('#cedula').val()
		} 
		$.ajax({
			url:'http://localhost:8090/tiendagenerica/v1/cliente/5',
			contentType:'application/json',
			type: 'POST',
			data:JSON.stringify()
			
		})
	})
	
}

*/



