/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rmartinez
 */
public class Utiles {

     

    public static void WriteObject(List<ModelEnvio> model,String pathConf) {
        
        try {
            File resultFile=new File(pathConf);
            resultFile.createNewFile();
            FileOutputStream f = new FileOutputStream(resultFile);
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(model);

            o.close();
            f.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error initializing stream");
        }
    }
    // TODO Auto-generated catch block    

    public static List<ModelEnvio> readObject(String pathConf) {
        List<ModelEnvio> result = null;
        try {

            FileInputStream fi = new FileInputStream(new File(pathConf));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            result = (List<ModelEnvio>) oi.readObject();

            oi.close();
            fi.close();
            return result;

        } catch (FileNotFoundException e) {
            System.out.println("File \".conf\" not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            System.out.println("Error while try to cast file");
        }
        return null;
    }
    
    
    
    
     public static void WriteObjectNumeros(ModelNoNumeros model,String pathConf) {
        
        try {
            File resultFile=new File(pathConf);
            resultFile.createNewFile();
            FileOutputStream f = new FileOutputStream(resultFile);
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(model);

            o.close();
            f.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error initializing stream");
        }
    }
    // TODO Auto-generated catch block    

    public static  ModelNoNumeros  readObjectNumeros(String pathConf) {
         ModelNoNumeros  result = null;
        try {

            FileInputStream fi = new FileInputStream(new File(pathConf));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            result = (ModelNoNumeros)oi.readObject();

            oi.close();
            fi.close();
            return result;

        } catch (FileNotFoundException e) {
            System.out.println("File \".conf\" not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            System.out.println("Error while try to cast file");
        }
        return null;
    }

}
