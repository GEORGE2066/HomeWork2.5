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
        correcter(login, true);
        correcter(password, true);
        correcter(confirmPassword, true);
    }

    public static void correcter(String str, boolean isLogin) throws WrongPasswordException, WrongLoginException {
        for (int i = 0; i < str.length(); i++) {
            if (!VALID.contains(String.valueOf(str.charAt(i)))) {
                if (isLogin) {
                    throw new WrongLoginException("В логине некорректный символ");
                } else {
                    throw new WrongPasswordException("В пароле содержится некорретный символ");
                }
            }
        }
    }
}
