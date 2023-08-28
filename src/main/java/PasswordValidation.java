import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PasswordValidation {
    static int MIN_PASSWORD_LENGTH = 8;
    static String[] BLACK_LIST = {"password", "password123", "passWord", "passWord123", "PassWord123", "12345678", "abcDEFgh"};

    public static void main(String[] args) {
        System.out.println("Wie Lang soll dein neues Passwort sein? (min 8 Zeichen)");
        Scanner scan = new Scanner(System.in);
        int passwordLength = -1;

        do{
            if(passwordLength < MIN_PASSWORD_LENGTH && passwordLength != -1){
                System.out.println("Die Länge muss mindestens 8 Zeichen haben!");
            }
            passwordLength = scan.nextInt();
        }while (passwordLength < MIN_PASSWORD_LENGTH);

        String p = generateRandomPassword(passwordLength);
        System.out.println("Dein neues Password ist: ");
        System.out.println(p);
    }

    public static boolean hasMinPasswordLength(@NotNull String password) {
        return password.length() >= MIN_PASSWORD_LENGTH;
    }

    public static boolean hasANumber(@NotNull String password) {
        return Pattern.matches("(.*\\d.*)", password);
    }

    public static boolean hasUpperAndLowerCaseLetter(@NotNull String password) {
        return Pattern.matches("(.*[a-z].*)(.*[A-Z].*)|(.*[A-Z].*)(.*[a-z].*)", password);
    }

    public static boolean hasSpecialCharacter(@NotNull String password) {
        return Pattern.matches("(.*[~`!@#$%^&*()\\-_=+\\[{\\]}\\\\|;:'\",<.>/?].*)", password);
    }

    public static boolean isBadPassword(@NotNull String password) {
        return Arrays.asList(BLACK_LIST).contains(password);
    }

    public static boolean checkPassword(@NotNull String password){
        boolean minLength = hasMinPasswordLength(password);
        boolean minOneNumber = hasANumber(password);
        boolean upperAndLowerCase = hasUpperAndLowerCaseLetter(password);
        boolean minOneSpecialCharacter = hasSpecialCharacter(password);
        boolean isNotBad = !isBadPassword(password);
        return minLength && minOneNumber && upperAndLowerCase && minOneSpecialCharacter && isNotBad;
    }
    @NotNull
    public static String generateRandomPassword(int len)
    {
        if(len < MIN_PASSWORD_LENGTH){
            len = MIN_PASSWORD_LENGTH -4;
        }

        final char[] lowercase = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        final char[] uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        final char[] numbers = "0123456789".toCharArray();
        final char[] symbols = "~`!@#$%^&*()-_=+[{]}|;\\:'\",<.>/?".toCharArray();
        final char[] allAllowed = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}|;\\:'\",<.>/?".toCharArray();

        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < len; i++)
        {
            password.append(allAllowed[random.nextInt(allAllowed.length)]);
        }

        password.insert(random.nextInt(password.length()), lowercase[random.nextInt(lowercase.length)]);
        password.insert(random.nextInt(password.length()), uppercase[random.nextInt(uppercase.length)]);
        password.insert(random.nextInt(password.length()), numbers[random.nextInt(numbers.length)]);
        password.insert(random.nextInt(password.length()), symbols[random.nextInt(symbols.length)]);

        return password.toString();
    }
}
