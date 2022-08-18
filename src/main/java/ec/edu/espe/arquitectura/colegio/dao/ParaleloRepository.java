package ec.edu.espe.arquitectura.colegio.dao;

import ec.edu.espe.arquitectura.colegio.model.Paralelo;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ParaleloRepository extends MongoRepository<Paralelo, String> {
  Optional<Paralelo> findByNivelAndNombreParalelo(String nivel, String paralelo);
}
