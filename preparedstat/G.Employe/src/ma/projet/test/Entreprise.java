/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import man.projet.service.DeveloppeurService;
import man.projet.service.ManagerService;

/**
 *
 * @author DELL
 */
public class Entreprise {
     public static void main(String[] args) {
          DeveloppeurService ds = new DeveloppeurService();
          ManagerService ms = new ManagerService();
     ds.create("Développeur 1", 50000);
        ds.create( "Développeur 2", 55000);

       
         ms.create( "Manager", 80000);
        ms.ajouterSousOrdre(ds);
        ms.ajouterSousOrdre(ds);

      
        
    }

}
