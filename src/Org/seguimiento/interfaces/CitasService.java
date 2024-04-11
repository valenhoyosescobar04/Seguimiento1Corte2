package Org.seguimiento.interfaces;

import Org.seguimiento.domain.Citas;
import Org.seguimiento.domain.Paciente;

import java.util.Date;
import java.util.List;
public interface CitasService {

    List<Citas> findAll();


    List<Citas> findByFecha(Date fecha);

    void save(Citas citas);

    void update(Citas cita);

    void delete(Citas cita);
}