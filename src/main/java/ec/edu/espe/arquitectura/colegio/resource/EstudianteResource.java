package ec.edu.espe.arquitectura.colegio.resource;

import ec.edu.espe.arquitectura.colegio.model.Estudiante;
import ec.edu.espe.arquitectura.colegio.service.EstudianteService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estudiante")
@RequiredArgsConstructor
public class EstudianteResource {
  private final EstudianteService service;

  @PostMapping
  public ResponseEntity<Estudiante> crearEstudiante(@RequestBody Estudiante estudiante) {
    try {
      return ResponseEntity.ok(this.service.crearEstudiante(estudiante));
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }

  @GetMapping("/listar")
  public ResponseEntity<List<Estudiante>> obtenerEstudiantesPorNivel(
      @RequestParam("nivel") String nivel) {
    try {
      List<Estudiante> listado = this.service.obtenerEstudiantesPorNivel(nivel);
      return ResponseEntity.ok(listado);
    } catch (Exception e) {
      return ResponseEntity.notFound().build();
    }
  }
}
