package com.co.ias.aves.service;

import com.co.ias.aves.model.Ave;
import com.co.ias.aves.repository.AveRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AveService {

    private final AveRepository aveRepository;

    public AveService(AveRepository aveRepository) {
        this.aveRepository = aveRepository;
    }
    public Ave guardarAve(Ave ave){
        return this.aveRepository.save(ave);
    }
    public void eliminarAve(Ave ave){
        this.aveRepository.delete(ave);
    }
    public Ave actualizarAve(Ave ave){
        return this.aveRepository.save(ave);
    }
    public Optional<Ave> buscarAve(String nombre){
        Optional<Ave> aveNombreComun = this.aveRepository.findByDsNombreComunOrDsNombreCientifico(nombre, nombre);
        return aveNombreComun;
    }
    public List<Ave> buscarAves(){
        return aveRepository.findAll();
    }
    public Optional<Ave> buscarAveId(String id){
        Optional<Ave> aveNombreComun = this.aveRepository.findById(id);
        return aveNombreComun;
    }

}
