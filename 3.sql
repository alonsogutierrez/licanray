use licanRay;

select usuario.nombre as vendedor,sum(((producto.precio_venta)-(producto.precio_compra))*(ventas_detalle.cant_producto)) as utilidadesTotales
from usuario,caja,ventas,ventas_detalle, producto
where usuario.id_usuario=caja.id_usuario
and caja.id_caja=ventas.id_caja
and ventas.id_venta=ventas_detalle.id_venta
and producto.id_producto=ventas_detalle.id_producto
group by vendedor