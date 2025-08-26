package pe.edu.epeu.asistencia.servicio;

import pe.edu.epeu.asistencia.modelo.Estudiante;
import java.util.List;

public interface EstudianteServicioI {

    void saveEntidad(Estudiante estudiante);
    List<Estudiante> findAllEntidades();
    void updateEntidad(Estudiante estudiante, int index);


    void deleteEntidad(int index);
    Estudiante findEntidad(int index);

}
