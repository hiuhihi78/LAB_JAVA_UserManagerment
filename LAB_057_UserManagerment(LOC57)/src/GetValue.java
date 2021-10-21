
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
class GetValue {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getChoiNumberInRange(int from, int to) {
        int choice = 0;
        // loop until user input correct
        while (true) {
            try {
                System.out.print("> Choose: ");
                String string = scanner.nextLine().trim();
                if (string.isEmpty()) {
                    System.err.println("Invalid of choice, choice must be not empty!");
                    continue;
                }
                choice = Integer.parseInt(string);
                if (choice < from || choice > to) {
                    System.err.println("Invalid of choice, choice must be a number in range [" + from + " - " + to + "]!");
                    continue;
                }
                return choice;
            } catch (Exception e) {
                System.err.println("Invalid of choice, choice must be a number!");
                continue;
            }

        }
    }

    public static String getInputString(String msg) {
        String result = null;
        // loop until user input correct
        while (true) {
            System.out.print("Enter " + msg + ": ");
            result = scanner.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Invalid of " + msg + ", " + msg + " must not be empty!");
            } else {
                return result.trim();
            }
        }
    }

    public static int getInputPositiveInt(String msg) {
        int result = 0;
        // loop until user input correct
        while (true) {
            try {
                String input = getInputString(msg);
                result = Integer.parseInt(input);
                if (result < 0) {
                    System.err.println("Invalid of " + msg + ", " + msg
                            + " must be positive number!");
                    continue;
                }
                return result;
            } catch (Exception e) {
                System.err.println("Invalid of " + msg + ", " + msg
                        + " must be a number!");
            }
        }
    }

    public static String getUserName(ArrayList<Account> list) {
        // loop until user
        while (true) {
            // input userName
            String userName = getInputStringNoSpace(5, "Username");
            // check userName existed
            boolean userNameExisted = Validation.checkUserNameExisted(list,userName);
            if(userNameExisted == true){
                System.err.println("Invalid of username, username was existed!");
                continue;
            }
            return userName;
        }

    }

    public static String getInputStringNoSpace(int lengthString, String msg) {
        while(true){
            String input = getInputString(msg);
            if(input.length() < 5){
                System.err.println("Invalid of " + msg + ", " + msg + " must be least " + lengthString + " character!");
                continue;
            }
            if(input.contains(" ")){
                System.err.println("Invalid of " + msg + ", " + msg + " must be not contain space character!");
                continue;
            }
            return input;
        }
    }

}
