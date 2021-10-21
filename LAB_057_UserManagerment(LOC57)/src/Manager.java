
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
class Manager {

    public static void displayMeunu() {
        System.out.println("====== USER MANAGEMENT SYSTEM ======");
        System.out.println("1. Create a new account");
        System.out.println("2. Login system");
        System.out.println("3. Exit");
    }

    public static void createAccount(String fileName) {
        ArrayList<Account> list = new ArrayList<>();
        // check file was existed
        boolean fileExisted = Validation.checkFileExisted(fileName);
        if (fileExisted == false) {
            System.out.println("File is not exist!\n");
        }
        System.out.println("Creat account");
        System.out.println("---------------------------");
        // get data from file
        list.addAll(FileProcess.readData(fileName));
        // create account
        String userName = GetValue.getUserName(list);
        String passWord = GetValue.getInputStringNoSpace(6, "Password");
        list.add(new Account(userName, passWord));
        // write data to file
        FileProcess.writeData(list, fileName);
        System.out.println("Successfully!\n");
    }

    public static void loginSystem(String fileName) {
        ArrayList<Account> list = new ArrayList<>();
        // check file was existed
        boolean fileExisted = Validation.checkFileExisted(fileName);
        if (fileExisted = false) {
            System.out.println("File is not exist!");
            return;
        }
        System.out.println("Login");
        System.out.println("---------------------------");
        // get data from file
        list.addAll(FileProcess.readData(fileName));
        // login system
        String userName = GetValue.getInputStringNoSpace(5, "Username");
        String passWord = GetValue.getInputStringNoSpace(6, "Password");
        Account account = new Account(userName, passWord);
        // check account existed 
        boolean accountExisted = Validation.checkAccountExisted(list, account);
        if (accountExisted == false) {
            System.out.println("Incorrect username or Password!");
            System.out.println("Cannot login!\n");
            return;
        } else {
            System.out.println("Login successfully!\n");
        }
    }

    public static void display(String fileName) {
        ArrayList<Account> list = new ArrayList<>();
        // get data from file
        list.addAll(FileProcess.readData(fileName));
        for (Account account : list) {
            System.out.println(account.getUserName() + " " + account.getPassWord());
        }
    }

}
