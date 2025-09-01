package pe.edu.epeu.asistencia.servicio;

import pe.edu.epeu.asistencia.modelo.Participante;
import java.util.List;

public interface ParticipanteServicioI {

    void save(Participante participante);

    List<Participante> findAll();

    void update(Participante participante, int index);


    void delete(int index);
    Participante findById(int index);

}
