package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class PaneTopController {

    @FXML private ResourceBundle resources;

    @FXML private URL location;

    // Imagenes Top Peliculas/Series
    @FXML private ImageView imgObra00;
    @FXML private ImageView imgObra01;
    @FXML private ImageView imgObra02;
    @FXML private ImageView imgObra03;
    @FXML private ImageView imgObra04;
    @FXML private ImageView imgObra05;
    @FXML private ImageView imgObra06;
    @FXML private ImageView imgObra07;

    // Elementos de detalle ordenados
    @FXML private Label lblTitulo;
    @FXML private Label lblDirectorGenero;
    @FXML private Label lblEstreno;
    @FXML private Label lblTituloSinopsis;
    @FXML private Label lblSinopsis;

    // Seleccion radioButton
    @FXML private RadioButton rbTodos;
    @FXML private RadioButton rbAnno;
    @FXML private RadioButton rbDecada;
    @FXML private RadioButton rb3Meses;

    
    /**
     * Muestra la información de la obra seleccionada
     * @param event
     */
    @FXML
    void onMouseEnteredTitle(MouseEvent event) {
    	// TODO: Mostrar en pantalla la información de la obra seleccionada
    }

    @FXML
    void initialize() {
    	// Cargar selección Top Peliculas/Series de Todos los tiempos 'imgObra00'
    }

}
