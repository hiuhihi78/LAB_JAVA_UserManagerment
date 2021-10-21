/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // loop until user want to exit
        while (true) {
            String fileName = "user.dat";
            // display menu
            Manager.displayMeunu();
            // choice option
            int choice = GetValue.getChoiNumberInRange(1, 3);
            switch (choice) {
                case 1:
                    // create account
                    Manager.createAccount(fileName);
                    break;
                case 2:
                    // login system
                    Manager.loginSystem(fileName);
                    break;
                case 3:
                    Manager.display(fileName);
            }
        }
    }

}
