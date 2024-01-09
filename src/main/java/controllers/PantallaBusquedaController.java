package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class PantallaBusqueda {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView btnBuscar;

    @FXML
    private RadioButton rbPeliculas;

    @FXML
    private RadioButton rbSeries;

    @FXML
    private RadioButton rbTodas;

    @FXML
    private TextField txtBusqueda;

    @FXML
    void btnBuscarPressed(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert btnBuscar != null : "fx:id=\"btnBuscar\" was not injected: check your FXML file 'PantallaBusqueda.fxml'.";
        assert rbPeliculas != null : "fx:id=\"rbPeliculas\" was not injected: check your FXML file 'PantallaBusqueda.fxml'.";
        assert rbSeries != null : "fx:id=\"rbSeries\" was not injected: check your FXML file 'PantallaBusqueda.fxml'.";
        assert rbTodas != null : "fx:id=\"rbTodas\" was not injected: check your FXML file 'PantallaBusqueda.fxml'.";
        assert txtBusqueda != null : "fx:id=\"txtBusqueda\" was not injected: check your FXML file 'PantallaBusqueda.fxml'.";

    }

}
