package ec.edu.espe.arquitectura.colegio.dao;

import ec.edu.espe.arquitectura.colegio.model.Estudiante;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EstudianteRepository extends MongoRepository<Estudiante, String> {
  Optional<Estudiante> findByCedula(String cedula);

  Optional<Estudiante> findByCedulaAndNivel(String cedula, String nivel);

  List<Estudiante> findByNivel(String nivel);
}
