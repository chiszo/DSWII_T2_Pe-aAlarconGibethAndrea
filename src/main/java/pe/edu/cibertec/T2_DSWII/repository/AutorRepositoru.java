package pe.edu.cibertec.T2_DSWII.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.T2_DSWII.model.bd.Autor;

@Repository
public interface AutorRepositoru extends JpaRepository<Autor, Integer> {
}
