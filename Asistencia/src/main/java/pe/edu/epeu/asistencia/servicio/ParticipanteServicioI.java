package pe.edu.epeu.asistencia.servicio;

import pe.edu.epeu.asistencia.modelo.Participante;
import java.util.List;

public interface ParticipanteServicioI {

    void save(Participante participante);

    List<Participante> findAll();

    Participante update(Participante participante);


    void delete(String dni);
    Participante findById(int index );

}
