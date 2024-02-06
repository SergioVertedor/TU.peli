package application;

import connector.HibernateUtils;
import java.sql.*;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;
import model.AppUser;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.*;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.util.WaitForAsyncUtils;
import utils.DialogNotificator;
import utils.PropertiesManager;
import utils.SceneSwitcher;
import utils.SessionHandler;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(ApplicationExtension.class)
public class AppTest {
  private static FxRobot bot = new FxRobot();
  private static AppUser appUser;

  @Start
  public void setup(Stage primaryStage) {
    PropertiesManager.setRememberLogin("0");
    try {
      try {
        HibernateUtils.openSession();
      } catch (Exception e) {
        System.err.println("Error al conectar con la base de datos");
        var dialogNotificator = new DialogNotificator();
        dialogNotificator.databaseConnectionError();
        System.exit(1);
      }
      if (PropertiesManager.getRememberLogin() == 1) {
        // Gestiona el cambio de escena a "Pantalla Modelo"
        SceneSwitcher sceneSwitch = new SceneSwitcher();
        sceneSwitch.switchScene("PantallaModelo");
        SessionHandler.setAppUser(PropertiesManager.getUser());
      } else {
        // Gestiona el cambio de escena a "Pantalla Login"
        SceneSwitcher sceneSwitch = new SceneSwitcher();
        sceneSwitch.switchScene("PantallaLogin");
      }
    } catch (Exception e) {
      // Imprime un mensaje en caso de error
      System.err.println("Error al cargar la ventana");
    }
  }

  @AfterEach
  public void closeStage() {
    SceneSwitcher.setStage(null);
  }

  @BeforeEach
  public void nullifyStage() {
    PropertiesManager.setRememberLogin("0");
    try {
      try {
        HibernateUtils.openSession();
      } catch (Exception e) {
        System.err.println("Error al conectar con la base de datos");
        var dialogNotificator = new DialogNotificator();
        dialogNotificator.databaseConnectionError();
        System.exit(1);
      }
      if (PropertiesManager.getRememberLogin() == 1) {
        // Gestiona el cambio de escena a "Pantalla Modelo"
        SceneSwitcher sceneSwitch = new SceneSwitcher();
        sceneSwitch.switchScene("PantallaModelo");
        SessionHandler.setAppUser(PropertiesManager.getUser());
      } else {
        // Gestiona el cambio de escena a "Pantalla Login"
        SceneSwitcher sceneSwitch = new SceneSwitcher();
        sceneSwitch.switchScene("PantallaLogin");
      }
    } catch (Exception e) {
      // Imprime un mensaje en caso de error
      System.err.println("Error al cargar la ventana");
    }
  }

  @BeforeAll
  public static void cleanBBDD() {
    String url = "jdbc:mariadb://srv980.hstgr.io:3306/u512132496_db512132496_";
    Connection conexion = null;
    try {
      conexion = DriverManager.getConnection(url);
    } catch (SQLException e) {
      System.err.println("Error al conectar con la base de datos: " + e);
      throw new RuntimeException(e);
    }

    try {
      Statement sentencia = conexion.createStatement();
      ResultSet resultado = sentencia.executeQuery("DELETE FROM usuarios WHERE name = 'prueba'");
    } catch (SQLException e) {
      System.err.println(e);
    } finally {
      if (conexion != null) {
        try {
          conexion.close();
        } catch (Exception ignored) {
        }
      }
    }
  }

  @Test
  @Order(1)
  public void registroLogin(FxRobot robot) {
    AppUser appUser = new AppUser("prueba", "prueba@test.case", "l4ND3V1R", null, null, null);
    robot.clickOn("#btnLoginRegister");
    robot.clickOn("#txtUserName");
    robot.write("prueba");
    robot.clickOn("#txtEmail");
    robot.write("prueba@test.case");
    robot.clickOn("#txtPassword");
    robot.write("l4ND3V1R");
    robot.clickOn("#txtPasswordRepeat");
    robot.write("l4ND3V1R");
    robot.clickOn("#btnLoginRegister");
    // Espera a que aparezca el Alert
    WaitForAsyncUtils.waitForFxEvents();

    // Busca el botón de aceptar en el Alert y haz clic en él
    DialogPane dialogPane =
        (DialogPane)
            robot.lookup(".dialog-pane").queryAll().stream()
                .filter(node -> node instanceof DialogPane)
                .findFirst()
                .orElse(null);
    assert dialogPane != null;
    String headerText = dialogPane.getHeaderText();
    robot.lookup(".dialog-pane .button").queryAll().stream()
        .filter(node -> "Aceptar".equals(((Button) node).getText()))
        .findFirst()
        .ifPresent(robot::clickOn);
    FxAssert verify = new FxAssert();
    assert headerText.equals("Registro correcto");
  }

  @Test
  @Order(2)
  public void login(FxRobot robot) {
    WaitForAsyncUtils.waitForFxEvents();
    robot.clickOn("#txtLoginUser");
    robot.write("prueba");
    robot.clickOn("#txtLoginPassword");
    robot.write("l4ND3V1R");
    robot.clickOn("#btnLoginEnter");
    // Espera a que aparezca el Alert
    WaitForAsyncUtils.waitForFxEvents();

    // Busca el botón de aceptar en el Alert y haz clic en él
    DialogPane dialogPane =
        (DialogPane)
            robot.lookup(".dialog-pane").queryAll().stream()
                .filter(node -> node instanceof DialogPane)
                .findFirst()
                .orElse(null);
    assert dialogPane != null;
    String headerText = dialogPane.getHeaderText();
    robot.lookup(".dialog-pane .button").queryAll().stream()
        .filter(node -> "Aceptar".equals(((Button) node).getText()))
        .findFirst()
        .ifPresent(robot::clickOn);
    assert headerText.equals("Login correcto");
  }
}
