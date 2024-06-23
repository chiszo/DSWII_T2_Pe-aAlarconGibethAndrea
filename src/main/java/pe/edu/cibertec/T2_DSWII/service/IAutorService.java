package pe.edu.cibertec.T2_DSWII.service;

import pe.edu.cibertec.T2_DSWII.model.bd.Autor;

import java.util.List;
import java.util.Optional;

public interface IAutorService {
    List<Autor> listarAutores();
    Autor guardarAutor(Autor autor);
    Optional<Autor> obtenerAutorxId(Integer id);
}
