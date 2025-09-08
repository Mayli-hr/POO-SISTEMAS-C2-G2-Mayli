package pe.edu.epeu.asistencia.repositorio;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

import pe.edu.epeu.asistencia.enums.Carrera;
import pe.edu.epeu.asistencia.enums.TipoParticipante;
import pe.edu.epeu.asistencia.modelo.Participante;

import java.util.ArrayList;
import java.util.List;


public abstract class ParticipanteRepositorio {
    public List<Participante> listaParticipante =new ArrayList<>();
    public List<Participante> findAll(){
        listaParticipante.add(
                new Participante(
                        new SimpleStringProperty("43631917"),
                        new SimpleStringProperty("Juan"),
                        new SimpleStringProperty("Apaza"),
                        new SimpleBooleanProperty(true),
                        Carrera.SISTEMAS,
                        TipoParticipante.ASISTENTE
                )
        );
        listaParticipante.add(
                new Participante(
                        new SimpleStringProperty("43631918"),
                        new SimpleStringProperty("Pedro"),
                        new SimpleStringProperty("Gutierrez"),
                        new SimpleBooleanProperty(true), Carrera.SISTEMAS,
                        TipoParticipante.ASISTENTE
                )
        );
        return listaParticipante;
    }

}
