package Org.seguimiento.infraestructure.repository;

import Org.seguimiento.domain.Citas;
import Org.seguimiento.domain.Paciente;
import Org.seguimiento.interfaces.CitasRepository;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CitasRepositoryImpl implements CitasRepository {

        private static final String FILE_NAME = "citas.dat";

    public CitasRepositoryImpl() {
    }

    @Override
        public List<Citas> findAll() {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
                return (ArrayList<Citas>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                return new ArrayList<>();
            }
        }

        @Override
        public List<Citas> findByPacienteId(int pacienteId) {
            List<Citas> citas = findAll();
            List<Citas> citasPaciente = new ArrayList<>();
            for (Citas cita : citas) {
                if (cita.getPaciente().getId() == pacienteId) {
                    citasPaciente.add(cita);
                }
            }
            return citasPaciente;
        }

        @Override
        public void save(Citas citas) {
            List<Citas> cita = findAll();
            cita.add(citas);
            saveAll(cita);
        }

        @Override
        public void delete(Citas cita) {
            List<Citas> citas = findAll();
            citas.remove(cita);
            saveAll(citas);
        }

    @Override
    public List<Citas> findByPacienteId(Paciente paciente) {
        return null;
    }

    @Override
    public List<Citas> findByFecha(Date fecha) {
        return null;
    }

    @Override
    public void update(Citas citas) {

    }

    private void saveAll(List<Citas> citas) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
                oos.writeObject(citas);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

