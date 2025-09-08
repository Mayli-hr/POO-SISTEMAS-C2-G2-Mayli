package pe.edu.epeu.asistencia.control;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pe.edu.epeu.asistencia.enums.Carrera;
import pe.edu.epeu.asistencia.enums.Faculdad;
import pe.edu.epeu.asistencia.enums.TipoParticipante;
import pe.edu.epeu.asistencia.modelo.Participante;
import pe.edu.epeu.asistencia.servicio.ParticipanteServicioI;

@Controller
public class ParticipanteController {
    @FXML
    private TextField txtNombre, txtDni, txtApellidos;
    @FXML
    private ComboBox<Carrera> bcxCarrera;
    @FXML
    private ComboBox<TipoParticipante> tbxTipoParticipante;
    @FXML
    private TableView<Participante> tableView;
    ObservableList<Participante> listaParticipante;
    @FXML
    private TableColumn<Participante, String> dniColum,nombreColum,apellidoColum,carreraColum,tipoPartColum;
    @Autowired
    ParticipanteServicioI ps;
    @FXML
    public void initialize(){
        bcxCarrera.getItems().setAll(Carrera.values());
        tbxTipoParticipante.getItems().setAll(TipoParticipante.values());
        definirColumnas();
        listaParticipante();


    }
    public void limpiarFormulario(){
        txtNombre.setText("");
        txtDni.setText("");
        txtApellidos.setText("");
        bcxCarrera.setValue(null);
        tbxTipoParticipante.setValue(null);


    }
    @FXML
    public void registrarParticipante(){
        Participante p = new Participante();
        p.setDni(new SimpleStringProperty(txtDni.getText()));
        p.setNombre(new SimpleStringProperty(txtNombre.getText()));
        p.setApellido(new SimpleStringProperty(txtApellidos.getText()));
        p.setCarrera(bcxCarrera.getSelectionModel().getSelectedItem());
        p.setTipoParticipante(tbxTipoParticipante.getSelectionModel().getSelectedItem());
        ps.save(p);
        listaParticipante();
        limpiarFormulario();

    }
    public void definirColumnas(){
        dniColum=new TableColumn("DNI");
        nombreColum=new TableColumn("Nombres");
        apellidoColum=new TableColumn("Apellidos");
        carreraColum=new TableColumn("Carrra");
        tipoPartColum=new TableColumn("Tipo Participante");
        tableView.getColumns().addAll( dniColum,nombreColum,apellidoColum,carreraColum,tipoPartColum);
    }
    public void listaParticipante(){
        dniColum.setCellValueFactory(cellData->cellData.getValue().getDni());
        nombreColum.setCellValueFactory(cellData->cellData.getValue().getNombre());
        apellidoColum.setCellValueFactory(cellData->cellData.getValue().getApellido());

        carreraColum.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getCarrera().toString()));
        listaParticipante= FXCollections.observableArrayList(ps.findAll());
        tableView.setItems(listaParticipante);
    }

}
