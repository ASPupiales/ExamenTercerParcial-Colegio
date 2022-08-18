package ec.edu.espe.arquitectura.colegio.model;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "paralelo")
@TypeAlias("paralelo")
public class Paralelo {
  @Id private String id;

  private String nivel;

  private String nombreParalelo;

  private List<Estudiante> estudiantes;
}
