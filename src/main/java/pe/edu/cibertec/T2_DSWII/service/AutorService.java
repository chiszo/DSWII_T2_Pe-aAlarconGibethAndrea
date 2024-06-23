package pe.edu.cibertec.T2_DSWII.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.T2_DSWII.model.bd.Autor;
import pe.edu.cibertec.T2_DSWII.repository.AutorRepositoru;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class AutorService implements IAutorService{

    private AutorRepositoru autorRepositoru;

    @Override
    public List<Autor> listarAutores() {
        return autorRepositoru.findAll();
    }

    @Override
    public Autor guardarAutor(Autor autor) {
        return autorRepositoru.save(autor);
    }

    @Override
    public Optional<Autor> obtenerAutorxId(Integer id) {
        Optional<Autor> autor
                = autorRepositoru.findById(id);
        if(autor.isEmpty()){
            return Optional.empty();
        }
        return autor;
    }
}
