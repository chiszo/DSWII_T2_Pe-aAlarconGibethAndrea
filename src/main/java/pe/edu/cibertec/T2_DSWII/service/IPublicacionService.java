package pe.edu.cibertec.T2_DSWII.service;

import pe.edu.cibertec.T2_DSWII.model.bd.Publicacion;

import java.util.List;
import java.util.Optional;

public interface IPublicacionService {
    List<Publicacion> listarPublicaciones();
    Publicacion guardarPublicacion(Publicacion publicacion);
    Optional<Publicacion> obtenerPublicacionxId(Integer id);
}
