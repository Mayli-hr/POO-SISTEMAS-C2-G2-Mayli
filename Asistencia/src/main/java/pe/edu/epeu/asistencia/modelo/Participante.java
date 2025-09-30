package pe.edu.epeu.asistencia.modelo;

import jakarta.persistence.*;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.StringProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.epeu.asistencia.enums.Carrera;
import pe.edu.epeu.asistencia.enums.TipoParticipante;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "participante")
public class Participante {
    @Id
    private String dni;
    private String nombre;
    private String apellido;
    private Boolean  estado;
    @Enumerated(EnumType.STRING)
    private Carrera carrera;
    @Enumerated(EnumType.STRING)
    private TipoParticipante tipoParticipante;


}
