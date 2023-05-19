package controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelo.Empleado;
import servicios.Repositorio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class creaEmpleadoController {

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtEdad;

    @FXML
    private Button btnCrearEmpleado;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFechaNac;

    @FXML
    private TextField txtNombre;

    @FXML
    void btnCreaEmpleado(MouseEvent event) {

        StringBuilder sb = generaMensajesError();

        agregarEmpleado(sb);
        }

    private StringBuilder generaMensajesError() {
        StringBuilder sb = new StringBuilder();

        try{
            if(txtNombre.getText().isEmpty()){
                sb.append("El campo nombre está vacío\n");
            }
            if(txtApellidos.getText().isEmpty()){
                sb.append("El campo apellidos está vacio\n");
            }
            if(txtEmail.getText().isEmpty()){
                sb.append("El campo email está vacio\n");
            }
            if(txtFechaNac.getText().isEmpty()){
                sb.append("El campo fecha está vacio\n");
            }
        }catch (IllegalArgumentException ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Incidencia");
            alert.setContentText("Datos introducidos incorrectos");
            alert.showAndWait();
        }catch(Exception exc){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Incidencia");
            alert.setContentText(exc.getMessage());
            alert.showAndWait();
        }
        return sb;
    }

    private void agregarEmpleado(StringBuilder sb) {

        if(!sb.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Incidencia");
            alert.setContentText(sb.toString());
            alert.showAndWait();
            sb.replace(0,sb.length(),"");
        }else{

             String nombre = txtNombre.getText();
             String apellidos =  txtApellidos.getText();
             String email = txtEmail.getText();
             DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
             LocalDate fechaNac = LocalDate.parse(txtFechaNac.getText(), formatter);

        Repositorio.empleados.add(new Empleado(nombre, apellidos, fechaNac, email));

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Enhorabuena");
            alert.setContentText("Su empleado ha sido registrado con éxito");
            alert.showAndWait();
            ((Stage) btnCrearEmpleado.getScene().getWindow()).close();
    }

    }

}