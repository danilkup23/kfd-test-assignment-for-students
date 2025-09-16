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
            input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("Yes")) break;
            else if (input.equalsIgnoreCase("No")) {
                status = false;
                break;
            }
            else System.out.println(fieldName + " must be like Yes/No");
        }

        return status;
    }

    public static String getValidatedType(String prompt, String fieldName, Scanner scanner) {
        String input;

        while (true) {
            System.out.print(prompt + " >> ");
            input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("STUDENT") || input.equalsIgnoreCase("GUEST") || input.equalsIgnoreCase("FACULTY")) break;
        }

        return input;
    }

//    public static String getValidatedLocalDate(String prompt, String fieldName, Scanner scanner) {
//        String input;
//
//        while (true) {
//            System.out.print(prompt + " >> ");
//            input = scanner.nextLine().trim();
//
//        }
//
//        return input;
//    }

}