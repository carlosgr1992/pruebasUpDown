module garcia.carlos.ejercicio5practicaexamen2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens garcia.carlos.ejercicio5practicaexamen2 to javafx.fxml;
    exports garcia.carlos.ejercicio5practicaexamen2;
    exports controlador;
    opens controlador to javafx.fxml;
    exports servicios;
    exports modelo;
}