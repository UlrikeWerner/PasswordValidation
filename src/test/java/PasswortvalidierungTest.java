import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswortvalidierungTest {

    @Test
    void returnTrueWhenPasswordIsMinMIN_PASSWORD_LEMGTH(){
        String password = "hxiw253hd";

        boolean actual = Passwortvalidierung.hasMinPasswordLength(password);
        Assertions.assertTrue(actual);
    }

    @Test
    void returnFalseWhenPasswordLengthIsUnder8(){
        String password = "hey";

        boolean actual = Passwortvalidierung.hasMinPasswordLength(password);
        Assertions.assertFalse(actual);
    }

    @Test
    void returnTrueWhenThePasswordHasANumber(){
        String password = "currywurst17";

        boolean actual = Passwortvalidierung.hasANumber(password);
        Assertions.assertTrue(actual);
    }

    @Test
    void returnTrueWhenThePasswordHasNotANumber(){
        String password = "currywurst";

        boolean actual = Passwortvalidierung.hasANumber(password);
        Assertions.assertFalse(actual);
    }
}
