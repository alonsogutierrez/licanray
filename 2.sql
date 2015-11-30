use licanRay;

select sec_to_time(sum(time_to_sec(caja.hora_termino)-time_to_sec(caja.hora_inicio))) as horasTrabajadas
from caja group by caja.id_caja;