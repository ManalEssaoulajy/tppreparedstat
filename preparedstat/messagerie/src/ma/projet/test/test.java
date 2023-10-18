/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.sql.Date;
import ma.preojet.beans.Employe;
import ma.preojet.beans.Message;
import ma.projet.service.EmployeService;
import ma.projet.service.MessageService;

/**
 *
 * @author DELL
 */
public class test {
    public static void main(String[] args) {
        
        EmployeService es = new EmployeService();

es.create(new Employe("LACHGAR", "Mohamed"));
es.create(new Employe("RAMI", "ALI"));
es.create(new Employe("SAFI", "Fatima"));

Employe e = es.getById(3);
if (e != null) {
e.setNom("ALAOUI");
e.setPrenom("Manale");
es.update(e);
}

//es.delete(es.getById(4));

for(Employe emp : es.getAll()){
System.out.println(""+emp.getNom());
}

MessageService ms = new MessageService();
ms.create(new Message("Réunion", "Réunion de fin d’année", new Date(16/10/2023),es.getById(1), es.getById(2)));
ms.create(new Message("Réunion", "Réunion de fin d’année", new Date(12/01/2023),es.getById(1), es.getById(3)));
ms.create(new Message("Stage", "Stage àMarrakech", new Date(12/01/2023),es.getById(2), es.getById(1)));
ms.create(new Message("Stage", "Stage àMarrakech", new Date(12/12/2023),es.getById(2), es.getById(3)));
//Les message reçus par l’employé 3
for (Message m : ms.getAll()) {
if(m.getDest().getId() == 3)
System.out.println(""+m.getSujet());
}
    }
    
}
