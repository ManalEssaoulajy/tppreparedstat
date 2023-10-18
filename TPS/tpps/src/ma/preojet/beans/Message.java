/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.preojet.beans;

import java.sql.Date;

/**
 *
 * @author DELL
 */
public class Message {
    private String objet;
    private String sujet;
    private Date date;
    private Employe exp;
    private Employe dest;

    public Message() {
    }

    public Message(String objet, String sujet, Date date, Employe exp, Employe dest) {
        this.objet = objet;
        this.sujet = sujet;
        this.date = date;
        this.exp = exp;
        this.dest = dest;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Employe getExp() {
        return exp;
    }

    public void setExp(Employe exp) {
        this.exp = exp;
    }

    public Employe getDest() {
        return dest;
    }

    public void setDest(Employe dest) {
        this.dest = dest;
    }
    
}
