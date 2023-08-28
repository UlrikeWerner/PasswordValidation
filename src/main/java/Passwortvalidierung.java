import java.util.regex.Pattern;

public class Passwortvalidierung {
    static int MIN_PASSWORD_LENGTH = 8;
    public static void main(String[] args) {

    }

    public static boolean hasMinPasswordLength(String password) {
        return password.length() >= MIN_PASSWORD_LENGTH;
    }

    public static boolean hasANumber(String password) {
        char[] cPassword = password.toCharArray();
        for(char c : cPassword){
            if(Character.isDigit(c)){
                return true;
            }
        }
        return false;
    }

    public static boolean hasUpperAndLowerCaseLetter(String password) {
        return Pattern.matches("(.*[a-z].*)(.*[A-Z].*)", password);
    }
}
