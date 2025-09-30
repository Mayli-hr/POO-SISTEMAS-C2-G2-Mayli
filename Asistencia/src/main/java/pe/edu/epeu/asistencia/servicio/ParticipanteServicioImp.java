package pe.edu.epeu.asistencia.servicio;

import org.springframework.stereotype.Service;
import pe.edu.epeu.asistencia.modelo.Participante;
import pe.edu.epeu.asistencia.repositorio.ParticipanteRepositorio;

import java.util.List;
@Service

public class ParticipanteServicioImp extends ParticipanteRepositorio implements ParticipanteServicioI {
    //List<Estudiante> listaEstudiante= new ArrayList<>();
    @Override
    public void save(Participante participante) {
        super.ssave(participante);
    }


    @Override
    public List<Participante> findAll() {

        return super.findAll();
    }

    @Override
    public Participante update(Participante participante) {
       return super.update(participante);

    } public void delete(Participante p){}

    @Override
    public void delete(String dni) {
        super.delete(dni);

    }

    @Override
    public Participante findById(int index) {
        return listaParticipante.get(index);
    }
}
