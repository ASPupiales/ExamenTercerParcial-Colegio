package ec.edu.espe.arquitectura.colegio.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "estudiante")
@TypeAlias("estudiante")
public class Estudiante {

  @Id private String id;

  private String nombres;

  private String apellidos;

  private String cedula;

  private String nivel;
}
