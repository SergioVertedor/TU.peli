import connector.HibernateUtils;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.util.WaitForAsyncUtils;
import utils.DialogNotificator;
import utils.PropertiesManager;
import utils.SceneSwitcher;
import utils.SessionHandler;

@ExtendWith(ApplicationExtension.class)
public class AppTest {

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

 /* @AfterEach
  public void tearDown() {
    HibernateUtils.openSession();
    HibernateUtils.startTransaction();
    String hql = "DELETE FROM AppUser WHERE username = 'prueba'";
    HibernateUtils.getSession().createQuery(hql, AppUser.class).executeUpdate();
    HibernateUtils.commitTransaction();
    HibernateUtils.closeSession();
  }*/

@Test
  public void test() {
    FxRobot bot = new FxRobot();
    bot.clickOn("#btnLoginRegister");
    bot.clickOn("#txtNombre");
    bot.write("prueba");
    bot.clickOn("#txtEmail");
    bot.write("prueba@test.case");
    bot.clickOn("#txtPassword");
    bot.write("l4ND3V1R");
    bot.clickOn("#txtPasswordRepeat");
    bot.write("l4ND3V1R");
    bot.clickOn("#btnLoginRegister");
    // Espera a que aparezca el Alert
    WaitForAsyncUtils.waitForFxEvents();

    // Busca el botón de aceptar en el Alert y haz clic en él
    bot.lookup(".dialog-pane .button").queryAll().stream()
        .filter(node -> "Aceptar".equals(((Button) node).getText()))
        .findFirst()
        .ifPresent(bot::clickOn);
  }
}
