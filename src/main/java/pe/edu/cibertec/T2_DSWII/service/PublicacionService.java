package pe.edu.cibertec.T2_DSWII.service;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.T2_DSWII.model.bd.Publicacion;
import pe.edu.cibertec.T2_DSWII.repository.PublicacionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PublicacionService implements IPublicacionService {
    private PublicacionRepository publicacionRepository;
    @Override
    public List<Publicacion> listarPublicaciones() {
        return publicacionRepository.findAll();
    }

    @Override
    public Publicacion guardarPublicacion(Publicacion publicacion) {
        return publicacionRepository.save(publicacion);
    }

    @Override
    public Optional<Publicacion> obtenerPublicacionxId(Integer id) {
        Optional<Publicacion> publicacion
                = publicacionRepository.findById(id);
        if(publicacion.isEmpty()){
            return Optional.empty();
        }
        return publicacion;
    }
}
