import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.Random;

public class PasswortvalidierungTest {
    static int MIN_PASSWORD_LENGTH = 8;

    @Test
    void returnTrueWhenPasswordIsMinMIN_PASSWORD_LEMGTH(){
        byte[] array = new byte[MIN_PASSWORD_LENGTH];
        new Random().nextBytes(array);
        String password = new String(array, StandardCharsets.UTF_8);

        boolean actual = Passwortvalidierung.hasMinPasswordLength(password);
        Assertions.assertTrue(actual);
    }

    @Test
    void returnFalseWhenPasswordLengthIsUnder8(){
        byte[] array = new byte[MIN_PASSWORD_LENGTH -2];
        new Random().nextBytes(array);
        String password = new String(array, StandardCharsets.UTF_8);

        boolean actual = Passwortvalidierung.hasMinPasswordLength(password);
        Assertions.assertFalse(actual);
    }
}
