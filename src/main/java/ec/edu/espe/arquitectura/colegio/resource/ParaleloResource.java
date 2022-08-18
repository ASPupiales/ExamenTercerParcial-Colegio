package ec.edu.espe.arquitectura.colegio.resource;

import ec.edu.espe.arquitectura.colegio.model.Estudiante;
import ec.edu.espe.arquitectura.colegio.model.Paralelo;
import ec.edu.espe.arquitectura.colegio.service.ParaleloService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/paralelo")
@RequiredArgsConstructor
public class ParaleloResource {

  private final ParaleloService service;

  @PostMapping
  public ResponseEntity<Paralelo> asignarEstudiante(
      @RequestParam("cedula") String cedula, @RequestParam("nivel") String nivel) {
    try {
      Paralelo paraleloAsignado = this.service.asignarEstudiante(cedula, nivel);
      return ResponseEntity.ok(paraleloAsignado);
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }

  @GetMapping("/listado")
  public ResponseEntity<List<Estudiante>> obtenerListadoEstudiantes(
      @RequestParam("nivel") String nivel, @RequestParam("paralelo") String paralelo) {
    try {
      List<Estudiante> listadoEstudiantes = this.service.obtenerListadoEstudiantes(nivel, paralelo);
      return ResponseEntity.ok(listadoEstudiantes);
    } catch (Exception e) {
      return ResponseEntity.notFound().build();
    }
  }
}
