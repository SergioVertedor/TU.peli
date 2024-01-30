import org.junit.jupiter.api.Test;
import org.testfx.api.FxRobot;

public class Launcher {
    FxRobot bot = new FxRobot();

    @Test
    public void test() {
        bot.clickOn("#helloButton");
                }
}
