public class Passwortvalidierung {
    static int MIN_PASSWORD_LENGTH = 8;
    public static void main(String[] args) {

    }

    public static boolean hasMinPasswordLength(String password) {
        return password.length() >= MIN_PASSWORD_LENGTH;
    }
}
