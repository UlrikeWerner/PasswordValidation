import java.security.SecureRandom;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Passwortvalidierung {
    static int MIN_PASSWORD_LENGTH = 8;
    static String[] BLACK_LIST = {"password", "password123", "passWord", "passWord123", "PassWord123", "12345678", "abcDEFgh"};

    public static void main(String[] args) {
        String password = "";
        int passwordLength = MIN_PASSWORD_LENGTH;
        while(!checkPassword(password)){
            password = generateRandomPassword(passwordLength);
        }
            System.out.println(password);
    }

    public static boolean hasMinPasswordLength(String password) {
        return password.length() >= MIN_PASSWORD_LENGTH;
    }

    public static boolean hasANumber(String password) {
        return Pattern.matches("(.*\\d.*)", password);
    }

    public static boolean hasUpperAndLowerCaseLetter(String password) {
        return Pattern.matches("(.*[a-z].*)(.*[A-Z].*)|(.*[A-Z].*)(.*[a-z].*)", password);
    }

    public static boolean hasSpecialCharacter(String password) {
        return Pattern.matches("(.*[~`!@#$%^&*()\\-_=+\\[{\\]}\\\\|;:'\",<.>/?].*)", password);
    }

    public static boolean isBadPassword(String password) {
        return Arrays.asList(BLACK_LIST).contains(password);
    }

    public static boolean checkPassword(String password){
        boolean minLength = hasMinPasswordLength(password);
        boolean minOneNumber = hasANumber(password);
        boolean upperAndLowerCase = hasUpperAndLowerCaseLetter(password);
        boolean minOneSpecialCharacter = hasSpecialCharacter(password);
        boolean isNotBad = !isBadPassword(password);
        return minLength && minOneNumber && upperAndLowerCase && minOneSpecialCharacter && isNotBad;
    }

    public static String generateRandomPassword(int len)
    {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\\\|;:\\'\\\",<.>/?";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        return sb.toString();
    }
}
