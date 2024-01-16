package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class PaneTopPeliculaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView imgPoster1;

    @FXML
    private ImageView imgPoster2;

    @FXML
    private ImageView imgPoster3;

    @FXML
    private ImageView imgPoster4;

    @FXML
    private ImageView imgPoster5;

    @FXML
    private ImageView imgPoster6;

    @FXML
    private ImageView imgPoster7;

    @FXML
    private ImageView imgPoster8;

    @FXML
    private Label lblDirectorGenero;

    @FXML
    private Label lblEstreno;

    @FXML
    private Label lblSinopsis;

    @FXML
    private Label lblTitulo;

    @FXML
    private Label lblTituloSinopsis;

    @FXML
    void initialize() {
        assert imgPoster1 != null : "fx:id=\"imgPoster1\" was not injected: check your FXML file 'PaneTop.fxml'.";
        assert imgPoster2 != null : "fx:id=\"imgPoster2\" was not injected: check your FXML file 'PaneTop.fxml'.";
        assert imgPoster3 != null : "fx:id=\"imgPoster3\" was not injected: check your FXML file 'PaneTop.fxml'.";
        assert imgPoster4 != null : "fx:id=\"imgPoster4\" was not injected: check your FXML file 'PaneTop.fxml'.";
        assert imgPoster5 != null : "fx:id=\"imgPoster5\" was not injected: check your FXML file 'PaneTop.fxml'.";
        assert imgPoster6 != null : "fx:id=\"imgPoster6\" was not injected: check your FXML file 'PaneTop.fxml'.";
        assert imgPoster7 != null : "fx:id=\"imgPoster7\" was not injected: check your FXML file 'PaneTop.fxml'.";
        assert imgPoster8 != null : "fx:id=\"imgPoster8\" was not injected: check your FXML file 'PaneTop.fxml'.";
        assert lblDirectorGenero != null : "fx:id=\"lblDirectorGenero\" was not injected: check your FXML file 'PaneTop.fxml'.";
        assert lblEstreno != null : "fx:id=\"lblEstreno\" was not injected: check your FXML file 'PaneTop.fxml'.";
        assert lblSinopsis != null : "fx:id=\"lblSinopsis\" was not injected: check your FXML file 'PaneTop.fxml'.";
        assert lblTitulo != null : "fx:id=\"lblTitulo\" was not injected: check your FXML file 'PaneTop.fxml'.";
        assert lblTituloSinopsis != null : "fx:id=\"lblTituloSinopsis\" was not injected: check your FXML file 'PaneTop.fxml'.";

    }

}
