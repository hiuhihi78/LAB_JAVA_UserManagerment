
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
class FileProcess {

    static ArrayList<Account> readData(String fileName) {
        ArrayList<Account> list = new ArrayList<>();
        FileInputStream fileInputStream = null;
        try {
            // check file exsited
            boolean fileExisted = Validation.checkFileExisted(fileName);
            if(fileExisted == false){
                writeData(new ArrayList<Account>(), fileName);
            }
            fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            list = (ArrayList<Account>) objectInputStream.readObject();
        } catch (Exception e) {
        } finally{
            try {
                fileInputStream.close();
            } catch (Exception e) {
            }
        }
        return list;
    }

    public static void writeData(ArrayList<Account> list, String fileName) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                fileOutputStream.close();
            } catch (Exception e) {
            }
        }
        
    }
    
}
