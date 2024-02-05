package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class PaneBusquedaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView btnBuscar;

    @FXML
    private ToggleGroup btnGroup;

    @FXML
    private ImageView imgResultado00;

    @FXML
    private ImageView imgResultado01;

    @FXML
    private ImageView imgResultado02;

    @FXML
    private ImageView imgResultado03;

    @FXML
    private ImageView imgResultado04;

    @FXML
    private ImageView imgResultado05;

    @FXML
    private ImageView imgResultado06;

    @FXML
    private ImageView imgResultado10;

    @FXML
    private ImageView imgResultado11;

    @FXML
    private ImageView imgResultado12;

    @FXML
    private ImageView imgResultado13;

    @FXML
    private ImageView imgResultado14;

    @FXML
    private ImageView imgResultado15;

    @FXML
    private ImageView imgResultado16;

    @FXML
    private ImageView imgResultado20;

    @FXML
    private ImageView imgResultado21;

    @FXML
    private ImageView imgResultado22;

    @FXML
    private ImageView imgResultado23;

    @FXML
    private ImageView imgResultado24;

    @FXML
    private ImageView imgResultado25;

    @FXML
    private ImageView imgResultado26;

    @FXML
    private ImageView imgResultado30;

    @FXML
    private ImageView imgResultado31;

    @FXML
    private ImageView imgResultado32;

    @FXML
    private ImageView imgResultado33;

    @FXML
    private ImageView imgResultado34;

    @FXML
    private ImageView imgResultado35;

    @FXML
    private ImageView imgResultado36;

    @FXML
    private HBox line0;

    @FXML
    private HBox line1;

    @FXML
    private HBox line2;

    @FXML
    private HBox line3;

    @FXML
    private RadioButton rbPeliculas;

    @FXML
    private RadioButton rbSeries;

    @FXML
    private RadioButton rbTodas;

    @FXML
    private TextField txtBusqueda;

    @FXML
    void btnBuscarClicked(MouseEvent event) {

    }

    @FXML
    void buscarKeyPressed(KeyEvent event) {

    }

    @FXML
    void initialize() {
        assert btnBuscar != null : "fx:id=\"btnBuscar\" was not injected: check your FXML file 'PaneBusqueda.fxml'.";
        assert btnGroup != null : "fx:id=\"btnGroup\" was not injected: check your FXML file 'PaneBusqueda.fxml'.";
        assert imgResultado00 != null : "fx:id=\"imgResultado00\" was not injected: check your FXML file 'PaneBusqueda.fxml'.";
        assert imgResultado01 != null : "fx:id=\"imgResultado01\" was not injected: check your FXML file 'PaneBusqueda.fxml'.";
        assert imgResultado02 != null : "fx:id=\"imgResultado02\" was not injected: check your FXML file 'PaneBusqueda.fxml'.";
        assert imgResultado03 != null : "fx:id=\"imgResultado03\" was not injected: check your FXML file 'PaneBusqueda.fxml'.";
        assert imgResultado04 != null : "fx:id=\"imgResultado04\" was not injected: check your FXML file 'PaneBusqueda.fxml'.";
        assert imgResultado05 != null : "fx:id=\"imgResultado05\" was not injected: check your FXML file 'PaneBusqueda.fxml'.";
        assert imgResultado06 != null : "fx:id=\"imgResultado06\" was not injected: check your FXML file 'PaneBusqueda.fxml'.";
        assert imgResultado10 != null : "fx:id=\"imgResultado10\" was not injected: check your FXML file 'PaneBusqueda.fxml'.";
        assert imgResultado11 != null : "fx:id=\"imgResultado11\" was not injected: check your FXML file 'PaneBusqueda.fxml'.";
        assert imgResultado12 != null : "fx:id=\"imgResultado12\" was not injected: check your FXML file 'PaneBusqueda.fxml'.";
        assert imgResultado13 != null : "fx:id=\"imgResultado13\" was not injected: check your FXML file 'PaneBusqueda.fxml'.";
        assert imgResultado14 != null : "fx:id=\"imgResultado14\" was not injected: check your FXML file 'PaneBusqueda.fxml'.";
        assert imgResultado15 != null : "fx:id=\"imgResultado15\" was not injected: check your FXML file 'PaneBusqueda.fxml'.";
        assert imgResultado16 != null : "fx:id=\"imgResultado16\" was not injected: check your FXML file 'PaneBusqueda.fxml'.";
        assert imgResultado20 != null : "fx:id=\"imgResultado20\" was not injected: check your FXML file 'PaneBusqueda.fxml'.";
        assert imgResultado21 != null : "fx:id=\"imgResultado21\" was not injected: check your FXML file 'PaneBusqueda.fxml'.";
        assert imgResultado22 != null : "fx:id=\"imgResultado22\" was not injected: check your FXML file 'PaneBusqueda.fxml'.";
        assert imgResultado23 != null : "fx:id=\"imgResultado23\" was not injected: check your FXML file 'PaneBusqueda.fxml'.";
        assert imgResultado24 != null : "fx:id=\"imgResultado24\" was not injected: check your FXML file 'PaneBusqueda.fxml'.";
        assert imgResultado25 != null : "fx:id=\"imgResultado25\" was not injected: check your FXML file 'PaneBusqueda.fxml'.";
        assert imgResultado26 != null : "fx:id=\"imgResultado26\" was not injected: check your FXML file 'PaneBusqueda.fxml'.";
        assert imgResultado30 != null : "fx:id=\"imgResultado30\" was not injected: check your FXML file 'PaneBusqueda.fxml'.";
        assert imgResultado31 != null : "fx:id=\"imgResultado31\" was not injected: check your FXML file 'PaneBusqueda.fxml'.";
        assert imgResultado32 != null : "fx:id=\"imgResultado32\" was not injected: check your FXML file 'PaneBusqueda.fxml'.";
        assert imgResultado33 != null : "fx:id=\"imgResultado33\" was not injected: check your FXML file 'PaneBusqueda.fxml'.";
        assert imgResultado34 != null : "fx:id=\"imgResultado34\" was not injected: check your FXML file 'PaneBusqueda.fxml'.";
        assert imgResultado35 != null : "fx:id=\"imgResultado35\" was not injected: check your FXML file 'PaneBusqueda.fxml'.";
        assert imgResultado36 != null : "fx:id=\"imgResultado36\" was not injected: check your FXML file 'PaneBusqueda.fxml'.";
        assert line0 != null : "fx:id=\"line0\" was not injected: check your FXML file 'PaneBusqueda.fxml'.";
        assert line1 != null : "fx:id=\"line1\" was not injected: check your FXML file 'PaneBusqueda.fxml'.";
        assert line2 != null : "fx:id=\"line2\" was not injected: check your FXML file 'PaneBusqueda.fxml'.";
        assert line3 != null : "fx:id=\"line3\" was not injected: check your FXML file 'PaneBusqueda.fxml'.";
        assert rbPeliculas != null : "fx:id=\"rbPeliculas\" was not injected: check your FXML file 'PaneBusqueda.fxml'.";
        assert rbSeries != null : "fx:id=\"rbSeries\" was not injected: check your FXML file 'PaneBusqueda.fxml'.";
        assert rbTodas != null : "fx:id=\"rbTodas\" was not injected: check your FXML file 'PaneBusqueda.fxml'.";
        assert txtBusqueda != null : "fx:id=\"txtBusqueda\" was not injected: check your FXML file 'PaneBusqueda.fxml'.";

    }

}
