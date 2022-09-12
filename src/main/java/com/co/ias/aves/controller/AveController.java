package com.co.ias.aves.controller;

import com.co.ias.aves.model.Ave;
import com.co.ias.aves.service.AveService;
import com.co.ias.aves.shared.models.MensajeError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aves")
@CrossOrigin("*")
public class AveController {

    private final AveService aveService;

    public AveController(AveService aveService) {
        this.aveService = aveService;
    }

    @PostMapping
    public ResponseEntity<?> crearAve(@RequestBody Ave ave){
        try {
            Ave resultadoAve = aveService.guardarAve(ave);
            return ResponseEntity.status(HttpStatus.CREATED).body(resultadoAve);
        } catch (Exception e) {
            MensajeError mensajeError = new MensajeError("1", "Ocurrio un error, intente mas tarde");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mensajeError);
        }

    }

    @GetMapping(path = "/nombre/{nombre}")
    public ResponseEntity<?> buscarAve(@PathVariable("nombre") String nombre){
        try{
            Optional<Ave> ave = aveService.buscarAve(nombre);
            MensajeError mensajeError = new MensajeError("2", "No existe un ave con ese nombre");
            return ave.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).body(mensajeError) : ResponseEntity.ok(ave);
        } catch (Exception e) {
            MensajeError mensajeError = new MensajeError("1", "Ocurrio un error, intente mas tarde");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mensajeError);
        }
    }

    @PutMapping
    public ResponseEntity<?> actualizarAve(@RequestBody Ave ave){
        try{
            Ave resultadoAve = aveService.actualizarAve(ave);
            return ResponseEntity.status(HttpStatus.OK).body(resultadoAve);
        } catch (Exception e) {
            MensajeError mensajeError = new MensajeError("1", "Ocurrio un error, intente mas tarde");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mensajeError);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> eliminarAve(@PathVariable("id") String id){
        try {
            Ave aveParaEliminar = new Ave();
            aveParaEliminar.setCdAve(id);
            aveService.eliminarAve(aveParaEliminar);
            MensajeError mensajeError = new MensajeError("0", "Se borro exitosamente");
            return ResponseEntity.status(HttpStatus.OK).body(mensajeError);
        } catch (Exception e) {
            MensajeError mensajeError = new MensajeError("1", "Ocurrio un error, intente mas tarde");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mensajeError);
        }
    }

    @GetMapping
    public ResponseEntity<?> buscarAves() {
        try {
            List<Ave> aves = aveService.buscarAves();
            MensajeError mensajeError = new MensajeError("2", "No existen aves");
            return aves.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).body(mensajeError) : ResponseEntity.ok(aves);
        } catch (Exception e) {
            MensajeError mensajeError = new MensajeError("1", "Ocurrio un error, intente mas tarde");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mensajeError);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> buscarAveId(@PathVariable("id") String id){
        try{
            Optional<Ave> ave = aveService.buscarAveId(id);
            MensajeError mensajeError = new MensajeError("2", "No existe una ave con ese id");
            return ave.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).body(mensajeError) : ResponseEntity.ok(ave);
        } catch (Exception e) {
            MensajeError mensajeError = new MensajeError("1", "Ocurrio un error, intente mas tarde");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mensajeError);
        }
    }

}
