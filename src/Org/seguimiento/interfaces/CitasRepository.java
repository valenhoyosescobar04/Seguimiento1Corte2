package Org.seguimiento.interfaces;

import Org.seguimiento.domain.Citas;
import Org.seguimiento.domain.Paciente;

import java.util.Date;
import java.util.List;

public interface CitasRepository {

    List<Citas> findAll();

    List<Citas> findByPacienteId(int pacienteId);

    void save(Citas citas);

    void delete(Citas citas);

    List<Citas> findByPacienteId(Paciente paciente);

    List<Citas> findByFecha(Date fecha);

    void update(Citas citas);
}


