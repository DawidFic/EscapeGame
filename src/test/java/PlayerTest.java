import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    Player player = new Player(5, 5, 10, 10, '@', 0, 100);

    @Test
    public void testMove() {
        int tempX = player.getX();
        int tempY = player.getY();
        player.playerMove('W');
        Assertions.assertEquals((tempX-1), player.getX(), "PLAYER HAS NOT MOVED UP SUCCESSFULLY");
        player.playerMove('S');
        Assertions.assertEquals((tempX), player.getX(), "PLAYER HAS NOT MOVED DOWN SUCCESSFULLY");
        player.playerMove('A');
        Assertions.assertEquals((tempY-1), player.getY(), "PLAYER HAS NOT MOVED LEFT SUCCESSFULLY");
        player.playerMove('D');
        Assertions.assertEquals((tempY), player.getY(), "PLAYER HAS NOT MOVED RIGHT SUCCESSFULLY");
    }

    @Test
    public void testGetHP() {
        //AssertEquals(Expected, Actual, Error Message)
        Assertions.assertEquals(100, player.getHp(), "PLAYER HP HAS NOT BEEN RETURNED CORRECTLY");

        player.setHp(50);

        Assertions.assertEquals(50, player.getHp(), "PLAYER HP HAS NOT BEEN CHANGED");
    }

    @Test
    public void testGetX() {
        Assertions.assertEquals(5, player.getX(), "PLAYER X COORDINATE HAS NOT BEEN RETURNED CORRECTLY");

        player.setX(50);

        Assertions.assertEquals(50, player.getX(), "PLAYER X HAS NOT BEEN CHANGED");
    }

    @Test
    public void testGetY() {
        Assertions.assertEquals(5, player.getY(), "PLAYER Y COORDINATE HAS NOT BEEN RETURNED CORRECTLY");

        player.setY(50);

        Assertions.assertEquals(50, player.getY(), "PLAYER Y HAS NOT BEEN CHANGED");
    }

    @Test
    public void testGetPlayerSymbol() {
        Assertions.assertEquals('@', player.getPlayerSymbol(), "PLAYER SYMBOL COORDINATE HAS NOT BEEN RETURNED CORRECTLY");

        player.setPlayerSymbol('£');

        Assertions.assertEquals('£', player.getPlayerSymbol(), "PLAYER X HAS NOT BEEN CHANGED");
    }

    @Test
    public void testGetScore() {
        Assertions.assertEquals(0, player.getScore(), "PLAYER SCORE HAS NOT BEEN RETURNED CORRECTLY");

        player.setScore(100);

        Assertions.assertEquals(100, player.getScore(), "PLAYER SCORE HAS NOT BEEN CHANGED");
    }
}
