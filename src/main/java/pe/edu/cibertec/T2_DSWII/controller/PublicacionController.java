package pe.edu.cibertec.T2_DSWII.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.T2_DSWII.exception.ResourceNotFoundException;
import pe.edu.cibertec.T2_DSWII.model.bd.Publicacion;
import pe.edu.cibertec.T2_DSWII.service.PublicacionService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/publicacion")
public class PublicacionController {

    private PublicacionService publicacionService;

    @GetMapping("")
    public ResponseEntity<List<Publicacion>> listarPublicaciones(){
        List<Publicacion> publicacionList = new ArrayList<>(publicacionService.listarPublicaciones());
        if(publicacionList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(publicacionList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publicacion> obtenerPublicacionXId(
            @PathVariable Integer id){
        Publicacion publicacion = publicacionService
                .obtenerPublicacionxId(id).orElseThrow(
                        () -> new ResourceNotFoundException("La Publicacion con Id " +
                                id + " no existe"));
        return new ResponseEntity<>(publicacion, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Publicacion> registrarCategoria(
            @RequestBody Publicacion publicacion
    ){
        return new ResponseEntity<>(publicacionService.guardarPublicacion(publicacion),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Publicacion> actualizarcategoria(
            @PathVariable Integer id,
            @RequestBody Publicacion publicacion
    ){
        Publicacion newpublicacion = publicacionService.obtenerPublicacionxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("La publicacion con ID"
                        + id + " no existe"));
        newpublicacion.setTitulo(publicacion.getTitulo());
        newpublicacion.setResumen(publicacion.getResumen());
        newpublicacion.setFechpublicacion(publicacion.getFechpublicacion());
        newpublicacion.setIdautor(publicacion.getIdautor());
        return new ResponseEntity<>(publicacionService.guardarPublicacion(newpublicacion),
                HttpStatus.OK);
    }
}
