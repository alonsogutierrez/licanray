use licanRay;

select usuario.nombre as vendedor,count(ventas.id_venta) as ventasTotales,
sum(((producto.precio_venta)-(producto.precio_compra))*(ventas_detalle.cant_producto)) as utilidadesTotales
from usuario,ventas,ventas_detalle,producto,caja
where ventas.id_venta = ventas_detalle.id_venta
and ventas_detalle.id_producto = producto.id_producto
and usuario.id_usuario = caja.id_usuario
and caja.id_caja = ventas.id_caja
and ventas.fecha between '2015-01-01' and '2015-07-22'
group by vendedor order by ventasTotales desc;