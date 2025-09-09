package pe.edu.epeu.asistencia.control;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
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
    private TableColumn<Participante, Void> opcColum;

    @Autowired
    ParticipanteServicioI ps;
    int indexE=-1;

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
        if(indexE==-1) {

            ps.save(p);
        }else{
            ps.update(p, indexE);
            indexE=-1;
        }
        listaParticipante();
        limpiarFormulario();

    }
    public void definirColumnas(){
        dniColum=new TableColumn("DNI");
        nombreColum=new TableColumn("Nombres");
        apellidoColum=new TableColumn("Apellidos");
        carreraColum=new TableColumn("Carrra");
        tipoPartColum=new TableColumn("Tipo Participante");
        opcColum=new TableColumn("Opciones");
        opcColum.setPrefWidth(200);
        tableView.getColumns().addAll( dniColum,nombreColum,apellidoColum,carreraColum,tipoPartColum,opcColum);
    }
    public void agregarAccionBotones(){
        Callback<TableColumn<Participante,Void> , TableCell<Participante, Void >> cellFactory =
                param->new TableCell<>() {
                    private final Button editarBtn = new Button("Editar");
                    private final Button eliminarBtn = new Button("Eliminar");
                    {
                        editarBtn.setOnAction((event)->{
                            Participante p =getTableView().getItems().get(getIndex());
                            editarParticipante(p, getIndex());

                        });
                        eliminarBtn.setOnAction((event)->{
                            eliminarParticipante(getIndex());
                        });
                    }

            @Override
            public void updateItem(Void item, boolean empty){
                super.updateItem(item, empty);
                if(empty){
                    setGraphic(null);
                }else{
                    HBox hbox = new HBox(editarBtn,eliminarBtn);
                    hbox.setSpacing(10);
                    setGraphic(hbox);
                }
            }
                };
        opcColum.setCellFactory(cellFactory);
    }



    public void listaParticipante(){
        dniColum.setCellValueFactory(cellData->cellData.getValue().getDni());
        nombreColum.setCellValueFactory(cellData->cellData.getValue().getNombre());
        apellidoColum.setCellValueFactory(cellData->cellData.getValue().getApellido());

        carreraColum.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getCarrera().toString()));
        agregarAccionBotones();
        listaParticipante= FXCollections.observableArrayList(ps.findAll());
        tableView.setItems(listaParticipante);
    }
    public void eliminarParticipante(int index){
        ps.delete(index);
        listaParticipante();
    }
    public void editarParticipante(Participante p, int index){
        txtDni.setText(p.getDni().getValue());
        txtNombre.setText(p.getNombre().toString());
        txtApellidos.setText(p.getApellido().getValue());
        bcxCarrera.setValue(p.getCarrera());
        tbxTipoParticipante.setValue(p.getTipoParticipante());
        indexE=index;

    }

}
