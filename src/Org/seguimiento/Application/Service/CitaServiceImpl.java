package Org.seguimiento.Application.Service;


import Org.seguimiento.domain.Citas;
import Org.seguimiento.interfaces.CitasRepository;
import Org.seguimiento.interfaces.CitasService;

import java.util.Date;
import java.util.List;

public class CitaServiceImpl implements CitasService {
    private final CitasRepository citasRepository;


    public CitaServiceImpl(CitasRepository citasRepository) {
        this.citasRepository = citasRepository;
    }

    @Override
    public List<Citas> findAll() {
        return citasRepository.findAll();
    }

    @Override
    public List<Citas> findByFecha(Date fecha) {
        return citasRepository.findByFecha(fecha);
    }

    @Override
    public void save(Citas citas) {
        citasRepository.save(citas);
    }

    @Override
    public void update(Citas citas) {
        citasRepository.update(citas);
    }

    @Override
    public void delete(Citas citas) {
        citasRepository.delete(citas);
    }
}


