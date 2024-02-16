package application;

import java.util.List;
import java.util.concurrent.TimeUnit;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;
import model.AppUser;
import model.connector.HibernateUtils;
import model.dao.AppUserImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.util.WaitForAsyncUtils;
import utils.DialogNotificator;
import utils.PropertiesManager;
import utils.SceneSwitcher;
import utils.SessionHandler;

/** Clase que contiene los test de la aplicación */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(ApplicationExtension.class)
public class AppTest {
  /**
   * Método que inicia la aplicación
   *
   * @param primaryStage
   */
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

  /** Método que limpia la base de datos antes de ejecutar los test */
  @BeforeAll
  public static void cleanBBDD() {
    AppUserImpl appUserImpl = new AppUserImpl(HibernateUtils.getSession());
    List<AppUser> appUsers = appUserImpl.searchAll();
    HibernateUtils.openSession();
    appUsers.stream()
        .filter(appUser -> appUser.getUsername().equals("prueba"))
        .forEach(appUserImpl::delete);
  }

  /** Método que cierra la sesión de Hibernate y la ventana después de ejecutar los test */
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

  /** Método que cierra la ventana después de ejecutar los test */
  @AfterEach
  public void closeStage() {
    SceneSwitcher.setStage(null);
  }

  /** Método que cierra la sesión de Hibernate después de ejecutar los test */
  @AfterAll
  public static void close() {
    AppUserImpl appUserImpl = new AppUserImpl(HibernateUtils.getSession());
    List<AppUser> appUsers = appUserImpl.searchAll();
    appUsers.stream()
        .filter(appUser -> appUser.getUsername().equals("prueba"))
        .forEach(appUserImpl::delete);
    HibernateUtils.closeSession();
  }

  /**
   * Test que comprueba el registro y login de un usuario
   *
   * @param robot
   */
  @Test
  @Order(1)
  public void registroLogin(FxRobot robot) {
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
    assert headerText.equals("Registro correcto");
  }

  /**
   * Test que comprueba el login de un usuario
   *
   * @param robot
   * @throws InterruptedException
   */
  @Test
  @Order(2)
  public void login(FxRobot robot) throws InterruptedException {
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
    // Esperamos unos segundos
    TimeUnit.SECONDS.sleep(3);
    String headerText = dialogPane.getHeaderText();
    assert headerText.equals("Login correcto");
  }
}
