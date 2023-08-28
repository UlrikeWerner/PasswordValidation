import java.util.Arrays;
import java.util.regex.Pattern;

public class Passwortvalidierung {
    static int MIN_PASSWORD_LENGTH = 8;
    static String[] BLACK_LIST = {"password", "password123", "passWord", "passWord123", "PassWord123", "12345678", "abcDEFgh"};
    public static void main(String[] args) {

    }

    public static boolean hasMinPasswordLength(String password) {
        return password.length() >= MIN_PASSWORD_LENGTH;
    }

    public static boolean hasANumber(String password) {
        return Pattern.matches("(.*\\d.*)", password);
    }

    public static boolean hasUpperAndLowerCaseLetter(String password) {
        return Pattern.matches("(.*[a-z].*)(.*[A-Z].*)", password);
    }

    public static boolean isBadPassword(String password) {
        return Arrays.asList(BLACK_LIST).contains(password);
    }

    //Sonderzeichen
}
