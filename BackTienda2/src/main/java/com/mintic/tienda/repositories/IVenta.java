package com.mintic.tienda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mintic.tienda.dto.VentaCliente;
import com.mintic.tienda.entities.Proveedor;
import com.mintic.tienda.entities.Venta;

public interface IVenta  extends CrudRepository<Venta,Long> {
	
	@Query(value="SELECT \r\n"
			+ "C.nombre,C.numeroDocumento,C.Sede,SUM(V.totalVenta) AS totalVenta\r\n"
			+ "FROM cliente C \r\n"
			+ "INNER JOIN venta V ON (C.id=V.idCliente) \r\n"
			+ "GROUP BY C.numeroDocumento",nativeQuery = true)
	List<VentaCliente> reporte();
	
}
