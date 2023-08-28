import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswortvalidierungTest {

    @Test
    void returnTrueWhenPasswordIsMinMIN_PASSWORD_LEMGTH(){
        String password = "hxiw253hd";

        boolean actual = Passwortvalidierung.hasMinPasswordLength(password);
        assertTrue(actual);
    }

    @Test
    void returnFalseWhenPasswordLengthIsUnder8(){
        String password = "hey";

        boolean actual = Passwortvalidierung.hasMinPasswordLength(password);
        assertFalse(actual);
    }

    @Test
    void returnTrueWhenThePasswordHasANumber(){
        String password = "currywurst17";

        boolean actual = Passwortvalidierung.hasANumber(password);
        assertTrue(actual);
    }

    @Test
    void returnTrueWhenThePasswordHasNotANumber(){
        String password = "currywurst";

        boolean actual = Passwortvalidierung.hasANumber(password);
        assertFalse(actual);
    }

    @Test
    void returnTrueWhenThePasswordContainsUpperAndLowerCaseLetter(){
        String password = "CUrryWursT";

        boolean actual = Passwortvalidierung.hasUpperAndLowerCaseLetter(password);
        assertTrue(actual);
    }

    @Test
    void returnFalseWhenThePasswordContainsOnlyLowerCaseLetter(){
        String password = "currywurst";

        boolean actual = Passwortvalidierung.hasUpperAndLowerCaseLetter(password);
        assertFalse(actual);
    }

    @Test
    void returnFalseWhenThePasswordContainsOnlyUpperCaseLetter(){
        String password = "CURRYWURST";

        boolean actual = Passwortvalidierung.hasUpperAndLowerCaseLetter(password);
        assertFalse(actual);
    }

    @Test
    void returnFalseWhenThePasswordContainsOnlyNumbers(){
        String password = "273456219487";

        boolean actual = Passwortvalidierung.hasUpperAndLowerCaseLetter(password);
        assertFalse(actual);
    }

    @Test
    void returnFalseWhenThePasswordContainsOnlySpecialCharacter(){
        String password = "§/&),*§#";

        boolean actual = Passwortvalidierung.hasUpperAndLowerCaseLetter(password);
        assertFalse(actual);
    }
    @Test
    void returnTrueWhenThePasswordIsABadPassword(){
        String password = "password123";

        boolean actual = Passwortvalidierung.isBadPassword(password);
        assertTrue(actual);
    }

    @Test
    void returnFalseWhenThePasswordIsABadPassword(){
        String password = "§/16Ak&),jH*9§#";

        boolean actual = Passwortvalidierung.isBadPassword(password);
        assertFalse(actual);
    }
}
