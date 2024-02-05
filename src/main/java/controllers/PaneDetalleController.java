package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PaneDetalleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private HBox boxReparto1;

    @FXML
    private HBox boxReparto11;

    @FXML
    private HBox boxReparto111;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnTrailer;

    @FXML
    private HBox elementReparto1;

    @FXML
    private HBox hBoxRating;

    @FXML
    private ImageView imgAppleTV;

    @FXML
    private ImageView imgDisney;

    @FXML
    private ImageView imgFav1;

    @FXML
    private ImageView imgFav11;

    @FXML
    private ImageView imgFav12;

    @FXML
    private ImageView imgFav13;

    @FXML
    private ImageView imgFav14;

    @FXML
    private ImageView imgFilmin;

    @FXML
    private ImageView imgHBO;

    @FXML
    private ImageView imgLike;

    @FXML
    private ImageView imgNetflix;

    @FXML
    private ImageView imgPen;

    @FXML
    private ImageView imgPoster;

    @FXML
    private ImageView imgPrimeVideo;

    @FXML
    private ImageView imgReparto1;

    @FXML
    private ImageView imgReparto2;

    @FXML
    private ImageView imgReparto4;

    @FXML
    private Label lblComentario;

    @FXML
    private Label lblEstrenoDuracion;

    @FXML
    private Label lblFechaVista;

    @FXML
    private Label lblReparto;

    @FXML
    private Label lblReparto1;

    @FXML
    private Label lblReparto2;

    @FXML
    private Label lblReparto21;

    @FXML
    private Label lblReparto4;

    @FXML
    private Label lblSinopsis;

    @FXML
    private Label lblSubtitulo;

    @FXML
    private Label lblTitulo;

    @FXML
    private Label lblTituloSinopsis;

    @FXML
    private Label lbluserRating;

    @FXML
    private VBox vBoxReparto;

    @FXML
    void btnAddPressed(ActionEvent event) {

    }

    @FXML
    void btnTrailerPressed(ActionEvent event) {

    }

    @FXML
    void editComentarioPressed(MouseEvent event) {

    }

    @FXML
    void fav1Selected(MouseEvent event) {

    }

    @FXML
    void fav2Selected(MouseEvent event) {

    }

    @FXML
    void fav3Selected(MouseEvent event) {

    }

    @FXML
    void fav4Selected(MouseEvent event) {

    }

    @FXML
    void fav5Selected(MouseEvent event) {

    }

    @FXML
    void imgLikePressed(MouseEvent event) {

    }

    @FXML
    void userRatingPressed(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert boxReparto1 != null : "fx:id=\"boxReparto1\" was not injected: check your FXML file 'PanePelicula.fxml'.";
        assert boxReparto11 != null : "fx:id=\"boxReparto11\" was not injected: check your FXML file 'PanePelicula.fxml'.";
        assert boxReparto111 != null : "fx:id=\"boxReparto111\" was not injected: check your FXML file 'PanePelicula.fxml'.";
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'PanePelicula.fxml'.";
        assert btnTrailer != null : "fx:id=\"btnTrailer\" was not injected: check your FXML file 'PanePelicula.fxml'.";
        assert elementReparto1 != null : "fx:id=\"elementReparto1\" was not injected: check your FXML file 'PanePelicula.fxml'.";
        assert hBoxRating != null : "fx:id=\"hBoxRating\" was not injected: check your FXML file 'PanePelicula.fxml'.";
        assert imgAppleTV != null : "fx:id=\"imgAppleTV\" was not injected: check your FXML file 'PanePelicula.fxml'.";
        assert imgDisney != null : "fx:id=\"imgDisney\" was not injected: check your FXML file 'PanePelicula.fxml'.";
        assert imgFav1 != null : "fx:id=\"imgFav1\" was not injected: check your FXML file 'PanePelicula.fxml'.";
        assert imgFav11 != null : "fx:id=\"imgFav11\" was not injected: check your FXML file 'PanePelicula.fxml'.";
        assert imgFav12 != null : "fx:id=\"imgFav12\" was not injected: check your FXML file 'PanePelicula.fxml'.";
        assert imgFav13 != null : "fx:id=\"imgFav13\" was not injected: check your FXML file 'PanePelicula.fxml'.";
        assert imgFav14 != null : "fx:id=\"imgFav14\" was not injected: check your FXML file 'PanePelicula.fxml'.";
        assert imgFilmin != null : "fx:id=\"imgFilmin\" was not injected: check your FXML file 'PanePelicula.fxml'.";
        assert imgHBO != null : "fx:id=\"imgHBO\" was not injected: check your FXML file 'PanePelicula.fxml'.";
        assert imgLike != null : "fx:id=\"imgLike\" was not injected: check your FXML file 'PanePelicula.fxml'.";
        assert imgNetflix != null : "fx:id=\"imgNetflix\" was not injected: check your FXML file 'PanePelicula.fxml'.";
        assert imgPen != null : "fx:id=\"imgPen\" was not injected: check your FXML file 'PanePelicula.fxml'.";
        assert imgPoster != null : "fx:id=\"imgPoster\" was not injected: check your FXML file 'PanePelicula.fxml'.";
        assert imgPrimeVideo != null : "fx:id=\"imgPrimeVideo\" was not injected: check your FXML file 'PanePelicula.fxml'.";
        assert imgReparto1 != null : "fx:id=\"imgReparto1\" was not injected: check your FXML file 'PanePelicula.fxml'.";
        assert imgReparto2 != null : "fx:id=\"imgReparto2\" was not injected: check your FXML file 'PanePelicula.fxml'.";
        assert imgReparto4 != null : "fx:id=\"imgReparto4\" was not injected: check your FXML file 'PanePelicula.fxml'.";
        assert lblComentario != null : "fx:id=\"lblComentario\" was not injected: check your FXML file 'PanePelicula.fxml'.";
        assert lblEstrenoDuracion != null : "fx:id=\"lblEstrenoDuracion\" was not injected: check your FXML file 'PanePelicula.fxml'.";
        assert lblFechaVista != null : "fx:id=\"lblFechaVista\" was not injected: check your FXML file 'PanePelicula.fxml'.";
        assert lblReparto != null : "fx:id=\"lblReparto\" was not injected: check your FXML file 'PanePelicula.fxml'.";
        assert lblReparto1 != null : "fx:id=\"lblReparto1\" was not injected: check your FXML file 'PanePelicula.fxml'.";
        assert lblReparto2 != null : "fx:id=\"lblReparto2\" was not injected: check your FXML file 'PanePelicula.fxml'.";
        assert lblReparto21 != null : "fx:id=\"lblReparto21\" was not injected: check your FXML file 'PanePelicula.fxml'.";
        assert lblReparto4 != null : "fx:id=\"lblReparto4\" was not injected: check your FXML file 'PanePelicula.fxml'.";
        assert lblSinopsis != null : "fx:id=\"lblSinopsis\" was not injected: check your FXML file 'PanePelicula.fxml'.";
        assert lblSubtitulo != null : "fx:id=\"lblSubtitulo\" was not injected: check your FXML file 'PanePelicula.fxml'.";
        assert lblTitulo != null : "fx:id=\"lblTitulo\" was not injected: check your FXML file 'PanePelicula.fxml'.";
        assert lblTituloSinopsis != null : "fx:id=\"lblTituloSinopsis\" was not injected: check your FXML file 'PanePelicula.fxml'.";
        assert lbluserRating != null : "fx:id=\"lbluserRating\" was not injected: check your FXML file 'PanePelicula.fxml'.";
        assert vBoxReparto != null : "fx:id=\"vBoxReparto\" was not injected: check your FXML file 'PanePelicula.fxml'.";

    }

}
