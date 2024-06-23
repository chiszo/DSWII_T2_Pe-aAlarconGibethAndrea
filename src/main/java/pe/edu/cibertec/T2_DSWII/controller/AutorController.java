package pe.edu.cibertec.T2_DSWII.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.T2_DSWII.exception.ResourceNotFoundException;
import pe.edu.cibertec.T2_DSWII.model.bd.Autor;
import pe.edu.cibertec.T2_DSWII.service.AutorService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/autor")
public class AutorController {

    private AutorService autorService;

    @GetMapping("")
    public ResponseEntity<List<Autor>> listarAutores(){
        List<Autor> autorList = new ArrayList<>(autorService.listarAutores());
        if(autorList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(autorList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> obtenerautorXId(
            @PathVariable Integer id){
        Autor autor = autorService
                .obtenerAutorxId(id).orElseThrow(
                        () -> new ResourceNotFoundException("La Autor con Id " +
                                id + " no existe"));
        return new ResponseEntity<>(autor, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Autor> registrarautor(
            @RequestBody Autor autor
    ){
        return new ResponseEntity<>(autorService.guardarAutor(autor),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> actualizarcategoria(
            @PathVariable Integer id,
            @RequestBody Autor autor
    ){
        Autor newautor = autorService.obtenerAutorxId(id)
                .orElseThrow(() -> new ResourceNotFoundException("La autor con ID"
                        + id + " no existe"));
        newautor.setNomautor(autor.getNomautor());
        newautor.setApeautor(autor.getApeautor());
        newautor.setFechnacautor(autor.getFechnacautor());
        return new ResponseEntity<>(autorService.guardarAutor(newautor),
                HttpStatus.OK);
    }
}
