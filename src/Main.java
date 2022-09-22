public class Main {
    public static void main(String[] args) {
        boolean result = Validator.check("gworgw2066", "qwerty890", "qwerty890");
        if (result) {
            System.out.println("Данные введены верно");
        } else {
            System.out.println("Данные введены не верно");
        }
    }
}