package pe.edu.upeu.asistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.asistencia.modelo.Participante;
//@Repository
public interface ParticipanteIRepositorio extends JpaRepository<Participante,String> {
}
