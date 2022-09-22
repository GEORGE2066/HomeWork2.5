import javax.imageio.metadata.IIOMetadataFormatImpl;

public class Validator {

    private static final String VALID = "1234567890_abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";



    public static boolean check(String login, String password, String confirmPassword) {
        try {
            validate(login, password, confirmPassword);
        } catch (WrongPasswordException | WrongLoginException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static void validate(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException{
        if (login == null || login.length() >= 20) {
            throw new WrongLoginException("Длинна пароля превышает допустимое");
        }
        if (password.length() >= 20 || password == null) {
            throw new WrongPasswordException("Длинна пароля превышает допустимое");
        } else if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Неверный пароль");
        }
        for (int i = 0; i < login.length(); i++) {
            if (!VALID.contains(String.valueOf(login.charAt(i)))) {
                throw new WrongLoginException("Логин может содержать латинские символы, цифры от 0 до 9 и нижнее подчёркивание");
            }
        }
        for (int i = 0; i < password.length(); i++) {
            if (!VALID.contains(String.valueOf(password.charAt(i)))) {
                throw new WrongPasswordException("Пароль может содержать латинские символы, цифры от 0 до 9 и нижнее подчёркивание");
            }
        }
    }
}
