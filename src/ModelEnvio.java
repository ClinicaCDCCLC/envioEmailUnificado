
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ramiro
 */
public class ModelEnvio implements  Serializable{
    private int hora;
    private String mail;
    private boolean completoCountry;
    private boolean mailCountry;
            
    private boolean completoColina;
    private boolean mailColina;
    private boolean sinFacturar;
    

    public ModelEnvio(String mail, boolean completoCountry, boolean mailCountry, boolean completoColina, boolean mailColina,boolean sinFacturar) {
        this.mail = mail;
        this.completoCountry = completoCountry;
        this.mailCountry = mailCountry;
        this.completoColina = completoColina;
        this.mailColina = mailColina;
        this.sinFacturar = sinFacturar;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }    
    
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isCompletoCountry() {
        return completoCountry;
    }

    public void setCompletoCountry(boolean completoCountry) {
        this.completoCountry = completoCountry;
    }

    public boolean isMailCountry() {
        return mailCountry;
    }

    public void setMailCountry(boolean mailCountry) {
        this.mailCountry = mailCountry;
    }

    public boolean isCompletoColina() {
        return completoColina;
    }

    public void setCompletoColina(boolean completoColina) {
        this.completoColina = completoColina;
    }

    public boolean isMailColina() {
        return mailColina;
    }

    public void setMailColina(boolean mailColina) {
        this.mailColina = mailColina;
    }

    public boolean isSinFacturar() {
        return sinFacturar;
    }

    public void setSinFacturar(boolean sinFacturar) {
        this.sinFacturar = sinFacturar;
    }
    
    
}

    