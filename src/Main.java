import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchMethodException {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(calc(s));

    }

    public static String calc(String input) throws IOException, NoSuchMethodException {
        String[] all = input.split(" ");
        char expr = all[1].charAt(0);
        if (isDigit(all[0]) && isDigit(all[2])) {
            int a = Integer.parseInt(all[0]);
            int b = Integer.parseInt(all[2]);
            if ((1 <= a && a <= 10) && (1 <= b && b <= 10)) {
                int result = calculation(a, b, expr);
                return String.valueOf(result);
            } else {
                throw new IOException("Каждое число должно быть целым и находится в интервале от 1 до 10");
            }
        } else {
            try {
                Romanian a = Romanian.valueOf(all[0]);
                Romanian b = Romanian.valueOf(all[2]);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Введите целое число");
            }
            Romanian a = Romanian.valueOf(all[0]);
            Romanian b = Romanian.valueOf(all[2]);
            if ((1 <= a.getValue() && a.getValue() <= 10) && (1 <= b.getValue() && b.getValue() <= 10)) {
                int result = calculation(a.getValue(), b.getValue(), expr);
                if (result <= 0) {
                    throw new ArithmeticException("Результат операции над римскими цифрами не может быть 0 или отрицательным числом");
                }
                Romanian[] r = Romanian.values();
                return r[result - 1].toString();
            } else {
                throw new IOException("Каждое число должно быть целым и находится в интервале от 1 до 10");
            }
        }
    }

    public static int calculation(int a, int b, char operation) throws NoSuchMethodException {
        int result;
        switch (operation) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a / b;
                break;
            default:
                throw new NoSuchMethodException("Введите корректное выражение");
        }
        return result;
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}