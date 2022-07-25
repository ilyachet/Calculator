import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(calc(s));
    }

        public static String calc(String input) {
            String[] all = input.split(" ");
            int a = Integer.parseInt(all[0]);
            int b = Integer.parseInt(all[2]);
            char expr = all[1].charAt(0);
            int result = calculation(a, b, expr);
            return String.valueOf(result);
        }

        public static int calculation(int a, int b, char operation){
            int result;
            switch (operation){
                case '+':
                    result = a+b;
                    break;
                case '-':
                    result = a-b;
                    break;
                case '*':
                    result = a*b;
                    break;
                case '/':
                    result = a/b;
                    break;
                default:
                    result = 0;
            }
            return result;
        }

    }