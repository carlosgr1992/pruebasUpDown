package controlador;

import garcia.carlos.ejercicio5practicaexamen2.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    @FXML
    void btnMisterioso(ActionEvent event) {

    }

    @FXML
    void btnTablaEmpleados(ActionEvent event) {

        try{
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("tablaEmpleados-view.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/bloque_interrogacion.jpg")));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Nuestros empleados");

            stage.setScene(scene);
            stage.showAndWait();
        }catch (IOException exception){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Incidencia");
            alert.setContentText("Se ha producido el siguiente error.\n" + exception);
            alert.showAndWait();
        }
    }

}
