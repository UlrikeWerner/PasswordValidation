import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Random;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordValidationTest {

    @Test
    void returnTrueWhenPasswordIsMinMIN_PASSWORD_LEMGTH(){
        String password = "hxiw253hd";

        boolean actual = PasswordValidation.hasMinPasswordLength(password);
        assertTrue(actual);
    }

    @Test
    void returnFalseWhenPasswordLengthIsUnder8(){
        String password = "hey";

        boolean actual = PasswordValidation.hasMinPasswordLength(password);
        assertFalse(actual);
    }

    @Test
    void returnTrueWhenThePasswordHasANumber(){
        String password = "currywurst17";

        boolean actual = PasswordValidation.hasANumber(password);
        assertTrue(actual);
    }

    @Test
    void returnTrueWhenThePasswordHasNotANumber(){
        String password = "currywurst";

        boolean actual = PasswordValidation.hasANumber(password);
        assertFalse(actual);
    }

    @Test
    void returnTrueWhenThePasswordContainsUpperAndLowerCaseLetter(){
        String password = "CUrrywurst";

        boolean actual = PasswordValidation.hasUpperAndLowerCaseLetter(password);
        assertTrue(actual);
    }

    @Test
    void returnFalseWhenThePasswordContainsOnlyLowerCaseLetter(){
        String password = "currywurst";

        boolean actual = PasswordValidation.hasUpperAndLowerCaseLetter(password);
        assertFalse(actual);
    }

    @Test
    void returnFalseWhenThePasswordContainsOnlyUpperCaseLetter(){
        String password = "CURRYWURST";

        boolean actual = PasswordValidation.hasUpperAndLowerCaseLetter(password);
        assertFalse(actual);
    }

    @Test
    void returnFalseWhenThePasswordContainsOnlyNumbers(){
        String password = "273456219487";

        boolean actual = PasswordValidation.hasUpperAndLowerCaseLetter(password);
        assertFalse(actual);
    }

    @Test
    void returnFalseWhenThePasswordContainsOnlySpecialCharacter(){
        String password = "§/&),*§#";

        boolean actual = PasswordValidation.hasUpperAndLowerCaseLetter(password);
        assertFalse(actual);
    }
    @Test
    void returnTrueWhenThePasswordIsABadPassword(){
        String password = "password123";

        boolean actual = PasswordValidation.isBadPassword(password);
        assertTrue(actual);
    }

    @Test
    void returnFalseWhenThePasswordIsABadPassword(){
        String password = "§/16Ak&),jH*9§#";

        boolean actual = PasswordValidation.isBadPassword(password);
        assertFalse(actual);
    }

    @Test
    void returnTrueWhenThePasswordHasAtLeastOneSpecialCharacter(){
        String password = "pasS12&3k=";

        boolean actual = PasswordValidation.hasSpecialCharacter(password);
        assertTrue(actual);
    }

    @Test
    void returnFalseWhenThePasswordHasNoSpecialCharacter(){
        String password = "aA12bB34cC";

        boolean actual = PasswordValidation.hasSpecialCharacter(password);
        assertFalse(actual);
    }

    @Test
    void returnTrueWhenThePasswordIsValidated(){
        String password = "4q75rRe)";

        boolean actual = PasswordValidation.checkPassword(password);
        assertTrue(actual);
    }

    @Test
    void returnFalseWhenThePasswordIsNotValidated(){
        String password = "aA12bB34cC";

        boolean actual = PasswordValidation.checkPassword(password);
        assertFalse(actual);
    }

    //static String[] passwordList = {"i|7+ptV3Es-H", "hT25,iez9"};
    @ParameterizedTest
    @MethodSource("generate5Passwords")
    void returnTrueWhenPasswordAreValided(String password){
        assertTrue(PasswordValidation.checkPassword(password));
    }

    static Stream<String> generate5Passwords(){
        int listLength = 5;
        String[] list = new String[listLength];
        Random random = new Random();
        int maxPasswordLength = 15;
        for(int i = 0; i < listLength; i++){
            list[i] = PasswordValidation.generateRandomPassword(random.nextInt(maxPasswordLength -4));
        }
        return Stream.of(list[0], list[1], list[2], list[3], list[4]);
    }
}
