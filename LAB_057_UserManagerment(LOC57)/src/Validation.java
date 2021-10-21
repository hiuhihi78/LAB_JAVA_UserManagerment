
import java.io.File;
import java.io.FileReader;
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
class Validation {

    public static boolean checkFileExisted(String fileName) {
//        FileReader file = null;
//        try {
//            file = new FileReader(fileName);
//            file.close();
//            return true;
//        } catch (Exception e) {
//            try {
//                file.close();
//            } catch (Exception ex) {
//            }
//            return false;
//        }
        try {
            File file = new File(fileName);
            if(file.exists()){
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public static boolean checkUserNameExisted(ArrayList<Account> list, String userName) {
        for(Account account : list){
            if(account.getUserName().equalsIgnoreCase(userName)){
                return true;
            }
        }
        return false;
    }

    public static boolean checkAccountExisted(ArrayList<Account> list, Account obj) {
        for(Account account : list){
            if(account.getUserName().equalsIgnoreCase(obj.getUserName()) &&
                    account.getPassWord().equalsIgnoreCase(obj.getPassWord())){
                return true;
            }
        }
        return false;
    }
    
}
