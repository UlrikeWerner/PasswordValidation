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
        String password = "CUrrywurst";

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

    @Test
    void returnTrueWhenThePasswordHasAtLeastOneSpecialCharacter(){
        String password = "pasS12&3k=";

        boolean actual = Passwortvalidierung.hasSpecialCharacter(password);
        assertTrue(actual);
    }

    @Test
    void returnFalseWhenThePasswordHasNoSpecialCharacter(){
        String password = "aA12bB34cC";

        boolean actual = Passwortvalidierung.hasSpecialCharacter(password);
        assertFalse(actual);
    }

    @Test
    void returnTrueWhenThePasswordIsValidated(){
        String password = "4q75rRe)";

        boolean actual = Passwortvalidierung.checkPassword(password);
        assertTrue(actual);
    }

    @Test
    void returnFalseWhenThePasswordIsNotValidated(){
        String password = "aA12bB34cC";

        boolean actual = Passwortvalidierung.checkPassword(password);
        assertFalse(actual);
    }
}
