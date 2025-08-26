package pe.edu.epeu.asistencia.control;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.task.TaskExecutionProperties;
import org.springframework.stereotype.Controller;
import pe.edu.epeu.asistencia.modelo.Estudiante;
import pe.edu.epeu.asistencia.repositorio.EstudianteRepositorio;
import pe.edu.epeu.asistencia.servicio.EstudianteServicioI;


@Controller
public class AsistenciaController {
@Autowired
 EstudianteServicioI estudianteServicioI;
    @FXML  private Label idMsg;
    @FXML TextField txtDato;

   // @FXML  Label txtResult;

    @FXML
     void enviar() {
        System.out.println("Enviando asistencia");
        idMsg.setText(txtDato.getText());
    }
    @FXML
    void regEstudiante(){
        Estudiante estudiante=new Estudiante();
        estudiante.setNombre(new SimpleStringProperty(txtDato.getText()));
        estudiante.setEstado(new SimpleBooleanProperty(true));
        estudianteServicioI.saveEntidad(estudiante);
        listarEstudiantes();
    }
    void  listarEstudiantes(){
        for (Estudiante e: estudianteServicioI.findAllEntidades()){
            System.out.println(e.getNombre());
        }
    }
}
