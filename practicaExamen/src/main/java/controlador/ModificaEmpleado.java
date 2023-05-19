package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelo.Empleado;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ModificaEmpleado {

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFechaNac;

    @FXML
    private Button btnModificarDatos;


    private Empleado empleado;

    @FXML
    void initialize(){

        txtNombre.setText(empleado.getNombre());
        txtApellidos.setText(empleado.getApellidos());
        txtEdad.setText(String.valueOf(empleado.calculaEdad()));
        txtEmail.setText(empleado.getEmail());

        txtFechaNac.setText(String.valueOf(empleado.getFechaNac().format(TablaEmpleados.FORMATO)));


       /* DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(txtFechaNac.getText(), formatter);*/
    }

    @FXML
    private TextField txtNombre;


    public ModificaEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @FXML
    void clicModificarDatos(MouseEvent event) {

        String nombre = txtApellidos.getText();
        String apellidos = txtApellidos.getText();
        //int edad =Integer.parseInt(txtEdad.getText());
        String fechaNac = txtFechaNac.getText();
        String email = txtEmail.getText();

        empleado.setNombre(nombre);
        empleado.setApellidos(apellidos);
        //empleado.setFechaNac(LocalDate.parse(fechaNac));
        empleado.setEmail(email);

        ((Stage) btnModificarDatos.getScene().getWindow()).close();

    }

}