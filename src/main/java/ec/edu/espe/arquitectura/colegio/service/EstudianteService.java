package ec.edu.espe.arquitectura.colegio.service;

import ec.edu.espe.arquitectura.colegio.dao.EstudianteRepository;
import ec.edu.espe.arquitectura.colegio.exception.EntityNotFoundException;
import ec.edu.espe.arquitectura.colegio.model.Estudiante;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EstudianteService {

  private final EstudianteRepository estudianteRepository;

  public Estudiante crearEstudiante(Estudiante estudiante) {
    Optional<Estudiante> estudianteOpt =
        this.estudianteRepository.findByCedula(estudiante.getCedula());
    if (estudianteOpt.isPresent()) {
      throw new EntityNotFoundException(
          "Estudiante con cedula: " + estudiante.getCedula() + " ya existe");
    }
    return this.estudianteRepository.save(estudiante);
  }

  public List<Estudiante> obtenerEstudiantesPorNivel(String nivel) {
    return this.estudianteRepository.findByNivel(nivel);
  }
}
