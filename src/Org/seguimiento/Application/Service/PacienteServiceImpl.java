package Org.seguimiento.Application.Service;

import Org.seguimiento.domain.Paciente;
import Org.seguimiento.infraestructure.repository.PacienteRepositoryImpl;

import java.util.Arrays;
import java.util.List;

public class PacienteServiceImpl implements PacienteService {
        private final PacienteRepository pacienteRepository;

        public PacienteServiceImpl(PacienteRepositoryImpl pacienteRepository) {
            this.pacienteRepository = (PacienteRepository) pacienteRepository;
        }

        @Override
        public List<Paciente> findAll() {
            return pacienteRepository.findAll();
        }

        @Override
        public Paciente findById(int id) {
            return pacienteRepository.findById(id);
        }

        @Override
        public void save(Paciente paciente) {
            validarPaciente(paciente);
            pacienteRepository.save(paciente);
        }

        @Override
        public void update(Paciente paciente) {
            validarPaciente(paciente);
            pacienteRepository.update(paciente);
        }

        @Override
        public void delete(int id) {
            pacienteRepository.delete(id);
        }

        private void validarPaciente(Paciente paciente) {
            if (paciente.getNombre().isEmpty()) {
                throw new IllegalArgumentException("El nombre del paciente no puede estar vacío");
                    }
                    if (paciente.getApellido().isEmpty()) {
                        throw new IllegalArgumentException("El apellido del paciente no puede estar vacío");
                    }
                    if (paciente.getEdad() <= 0) {
                        throw new IllegalArgumentException("La edad del paciente debe ser mayor que cero");
                    }
                    if (!Arrays.asList("Masculino", "Femenino", "Otro").contains(paciente.getGenero())) {
                        throw new IllegalArgumentException("El género del paciente debe ser Masculino, Femenino u Otro");
                    }
                    if (paciente.getDireccion().isEmpty()) {
                        throw new IllegalArgumentException("La dirección del paciente no puede estar vacía");
                    }
                    if (paciente.getTelefono().isEmpty()) {
                        throw new IllegalArgumentException("El teléfono del paciente no puede estar vacío");
                    }
                }

            }


