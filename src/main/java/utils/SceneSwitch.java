package utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneSwitch {
    public void switchScene(String fxml, Object controller) throws IOException {
        StringBuilder path = new StringBuilder();
        String fxmlFile = path.append("/view/").append(fxml).append(".fxml").toString();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/PantallaSecundaria.fxml"));
        Parent root = loader.load(); // Carga pantalla principal
        controller  = loader.getController();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.showAndWait();
    }

}
