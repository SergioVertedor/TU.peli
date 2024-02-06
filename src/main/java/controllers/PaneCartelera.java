package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class PaneCartelera {

    // Imagenes cartelera
    @FXML private ImageView imgPoster00;
    @FXML private ImageView imgPoster01;
    @FXML private ImageView imgPoster02;
    @FXML private ImageView imgPoster10;
    @FXML private ImageView imgPoster11;
    @FXML private ImageView imgPoster12;
    
    // Titulo peliculas
    @FXML private Label lblTitulo00;
    @FXML private Label lblTitulo01;
    @FXML private Label lblTitulo02;
    @FXML private Label lblTitulo10;
    @FXML private Label lblTitulo11;
    @FXML private Label lblTitulo12;
    
    // Formato: "Director: " + director + "\nReparto: " + listaReparto string
    @FXML private Label lblInfo00;
    @FXML private Label lblInfo01;
    @FXML private Label lblInfo02;
    @FXML private Label lblInfo10;
    @FXML private Label lblInfo11;
    @FXML private Label lblInfo12;
    
    // Generos
    @FXML private Label lblGenero00;
    @FXML private Label lblGenero01;
    @FXML private Label lblGenero02;
    @FXML private Label lblGenero10;
    @FXML private Label lblGenero11;
    @FXML private Label lblGenero12;

    @FXML
    void initialize() {
    	// TODO: Busqueda 6 elementos cartelera
    	// Posibilidad de ampliar si nos da tiempo
    }

}
