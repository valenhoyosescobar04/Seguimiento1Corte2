package Org.seguimiento.interfaces;

import Org.seguimiento.domain.Paciente;

import java.util.List;
public interface PacienteRepository {

        List<Paciente> findAll();
        Paciente findById(int id);
        void save(Paciente paciente);
        void update(Paciente paciente);
        void delete(int id);
    }

