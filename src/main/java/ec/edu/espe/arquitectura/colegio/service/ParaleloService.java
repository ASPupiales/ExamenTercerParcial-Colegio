package ec.edu.espe.arquitectura.colegio.service;

import ec.edu.espe.arquitectura.colegio.dao.EstudianteRepository;
import ec.edu.espe.arquitectura.colegio.dao.ParaleloRepository;
import ec.edu.espe.arquitectura.colegio.exception.EntityNotFoundException;
import ec.edu.espe.arquitectura.colegio.model.Estudiante;
import ec.edu.espe.arquitectura.colegio.model.Paralelo;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParaleloService {

  private final ParaleloRepository paraleloRepository;
  private final EstudianteRepository estudianteRepository;

  public Paralelo asignarEstudiante(String cedula, String nivel) {
    Optional<Estudiante> estudianteOpt =
        this.estudianteRepository.findByCedulaAndNivel(cedula, nivel);
    if (!estudianteOpt.isPresent()) {
      throw new EntityNotFoundException(
          "Estudiante con cedula: " + cedula + " y de nivel: " + nivel + " no existe");
    }

    String paralelo = String.valueOf(generarParaleloRandom());

    Optional<Paralelo> paraleloOpt =
        this.paraleloRepository.findByNivelAndNombreParalelo(nivel, paralelo);
    if (!paraleloOpt.isPresent()) {
      throw new EntityNotFoundException(
          "Paralelo : " + paralelo + " de nivel: " + nivel + " no existe");
    }

    Paralelo paraleloBD = paraleloOpt.get();

    List<Estudiante> estudiantesParalelo = paraleloBD.getEstudiantes();
    estudiantesParalelo.add(estudianteOpt.get());

    paraleloBD.setEstudiantes(estudiantesParalelo);

    return this.paraleloRepository.save(paraleloBD);
  }

  public List<Estudiante> obtenerListadoEstudiantes(String nivel, String paralelo) {
    Optional<Paralelo> paraleloOpt =
        this.paraleloRepository.findByNivelAndNombreParalelo(nivel, paralelo);
    if (!paraleloOpt.isPresent()) {
      throw new EntityNotFoundException(
          "Paralelo : " + paralelo + " de nivel: " + nivel + " no existe");
    }
    Paralelo paraleloBD = paraleloOpt.get();
    return paraleloBD.getEstudiantes();
  }

  private Character generarParaleloRandom() {
    Random random = new Random();
    String paralelos = "ABC";
    int randomInt = random.nextInt(paralelos.length());
    return paralelos.charAt(randomInt);
  }
}
