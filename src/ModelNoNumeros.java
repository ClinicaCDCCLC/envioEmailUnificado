/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author rmartinez
 */
public class ModelNoNumeros implements Serializable {

    private List<String> mails = new LinkedList<String>();
    

 
    public List<String> getMails() {
        return mails;
    }

    public void setMails(List<String> mails) {
        this.mails = mails;
    }
    
    
     public boolean noEnviarDatos(String mail){
        if(mails!=null){
            for(String m:mails){
                if(m.trim().equals(mail.trim()))
                    return true;
            }
        }
        return false;
    }

}
