package biti.danilkup23.view.utils;

import java.util.Scanner;

public class InputValidatorUtil {
    public static String getValidatedString(String prompt, String fieldName, Scanner scanner) {
        String input;
        do {
            System.out.print(prompt + " >> ");
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println(fieldName + " must not be empty!");
            }
        } while (input.isEmpty());
        return input;
    }

    public static int getValidatedInteger(String prompt, String fieldName, Scanner scanner) {
        int input = 0;
        boolean valid = false;

        do {
            System.out.print(prompt + " >> ");
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                scanner.nextLine();
                valid = true;
            } else {
                System.out.println(fieldName + " must be a valid integer number!");
                scanner.next();
            }
        } while (!valid);

        return input;
    }

    public static boolean getValidatedBoolean(String prompt, String fieldName, Scanner scanner) {
        String input;
        boolean status = true;

        while (true) {
            System.out.print(prompt + " >> ");
            input = scanner.next().trim();
            if (input.equals("Yes")) break;
            else if (input.equals("No")) status = false;
            else System.out.println(fieldName + " must be like Yes/No");
        }

        return status;
    }

}