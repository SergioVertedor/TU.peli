package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class PaneUsuarioController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnEditarDispositivos;

    @FXML
    private Button btnGuardar;

    @FXML
    private HBox hBoxDispositivo1;

    @FXML
    private HBox hBoxDispositivo1111;

    @FXML
    private HBox hBoxDispositivo2;

    @FXML
    private HBox hBoxDispositivo3;

    @FXML
    private ImageView imgDispositivo1;

    @FXML
    private ImageView imgDispositivo2;

    @FXML
    private ImageView imgDispositivo3;

    @FXML
    private ImageView imgDispositivo4;

    @FXML
    private ImageView imgUser;

    @FXML
    private Label lblDispositivo1;

    @FXML
    private Label lblDispositivo2;

    @FXML
    private Label lblDispositivo3;

    @FXML
    private Label lblDispositivo4;

    @FXML
    private Button lblExportar;

    @FXML
    private Button lblImportar;

    @FXML
    private Label lblMiembrodesde;

    @FXML
    private Label lblTNumTitulosLista;

    @FXML
    private Label lblUltimaConexion;

    @FXML
    private Label lblUsername;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPass;

    @FXML
    private TextField txtPass2;

    @FXML
    private TextField txtUsername;

    /**
     * Edita el listado de dispositivos del usuario
     * @param event
     */
    @FXML
    void btnEditarDispositivosPressed(ActionEvent event) {
    	// TODO
    }

    /**
     * Guarda/Modifica la información del usuario
     * @param event
     */
    @FXML
    void btnGuardarPressed(ActionEvent event) {
    	// TODO
    }
    
    /**
     * Exportar datos
     * @param event
     */
    @FXML
    void exportarDatosPressed(ActionEvent event) {
    	// TODO
    }

    /**
     * Importar datos
     * @param event
     */
    @FXML
    void importarDatosPressed(ActionEvent event) {
    	// TODO
    }

    @FXML
    void initialize() {
    	imgUser.setImage(new Image("images/user.png"));
    }

}
