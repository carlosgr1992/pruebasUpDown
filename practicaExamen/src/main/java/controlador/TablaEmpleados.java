package controlador;

import garcia.carlos.ejercicio5practicaexamen2.Main;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Empleado;
import servicios.Repositorio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class TablaEmpleados {
    public static DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @FXML
    private TableColumn<Empleado, String> apellidosColumna;

    @FXML
    private TableColumn<Empleado, Integer> edadColumna;

    @FXML
    private TableColumn<Empleado, String> emailColumna;

    @FXML
    private TableColumn<Empleado, String> fechaNacColumna;

    @FXML
    private TableColumn<Empleado, String> nombreColumna;

    @FXML
    private CheckBox checkFechas2000;

    @FXML
    private CheckBox checkMayoresEdad;

    @FXML
    private TableView<Empleado> tablaCompleta;

    @FXML
    void dragBorrarEmpleado(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Eliminación de empleado");
        alert.setContentText("¿Desea eliminar al empleado?");

        Optional<ButtonType> result = alert.showAndWait();
        result.ifPresent(buttonType -> {
            if (buttonType == ButtonType.OK) {
                Empleado empleado = tablaCompleta.getSelectionModel().getSelectedItem();
                Repositorio.empleados.remove(empleado);
                tablaCompleta.refresh();
            }
        });
    }

    @FXML
    void modificaEmpleado(MouseEvent event) {

        try {
            Empleado empleado = this.tablaCompleta.getSelectionModel().getSelectedItem();
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("modificaEmpleados-view.fxml"));
            loader.setController(new ModificaEmpleado(empleado));
            //ModificaEmpleado controller = new ModificaEmpleado(empleado);

            Parent root = loader.load();


            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Modifica Empleado");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.showAndWait();

        }catch (IOException ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Incidencia");
            alert.setContentText("Se ha producido el siguiente error.\n" + ex);
            alert.showAndWait();

            ex.printStackTrace();
        }

        tablaCompleta.refresh();
    }

    @FXML
    void btnAnadirEmpleado(ActionEvent event) {

        try{
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("crearEmpleado-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/bloque_interrogacion.jpg")));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Creación de empleados");

            stage.setScene(scene);
            stage.showAndWait();
            
            tablaCompleta.refresh();            //AQUI ACTUALIZAMOS LA TABLA PARA QUE SALGA AL MOMENTO

        }catch (IOException exception){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Incidencia");
            alert.setContentText("Se ha producido el siguiente error.\n" + exception);
            alert.showAndWait();
        }

    }

    @FXML
    void initialize(){

        tablaCompleta.setItems(FXCollections.observableList(Repositorio.getEmpleados()));

        seteaColumnas();

    }

    private void seteaColumnas() {

        this.nombreColumna.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getNombre()));
        this.apellidosColumna.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getApellidos()));
        this.fechaNacColumna.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getFechaNac().format(FORMATO)));
        this.edadColumna.setCellValueFactory(p -> new SimpleIntegerProperty(p.getValue().calculaEdad()).asObject());
        this.emailColumna.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getEmail()));
    }



}
