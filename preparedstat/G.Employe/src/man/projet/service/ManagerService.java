/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package man.projet.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ma.projet.beans.Manager;
import ma.projet.connexion.Connexion;
import ma.projet.dao.IDao;

/**
 *
 * @author DELL
 */
public class ManagerService implements IDao<Manager>{
    
     private Connection connection;  // Assurez-vous d'avoir initialisé cette connexion correctement

 
    
    
  @Override
public boolean create(ma.projet.beans.Manager o) {
try {
String req = "insert into manager (nom, prenom) values(?,?)";

PreparedStatement ps =Connexion.getConnection().prepareStatement(req);
ps.setString(1, o.getNom());
ps.setDouble(2, o.getSalaire());
if (ps.executeUpdate() == 1) {
return true;
}
} catch (SQLException ex) {
Logger.getLogger(ManagerService.class.getName()).log(Level.SEVERE,
null, ex);
}
return false;
}
@Override
public boolean update(ma.projet.beans.Manager o) {
try {
String req = "update manager set nom = ? , prenom = ? where id =?";
PreparedStatement ps =Connexion.getConnection().prepareStatement(req);
ps.setString(1, o.getNom());
ps.setDouble(2, o.getSalaire());

if (ps.executeUpdate() == 1) {
return true;
}
} catch (SQLException ex) {
Logger.getLogger(ManagerService.class.getName()).log(Level.SEVERE,
null, ex);
}
return false;
}
@Override
public boolean delete(ma.projet.beans.Manager o) {
try {
String req = "delete from manager where id = ?";
PreparedStatement ps =Connexion.getConnection().prepareStatement(req);

if (ps.executeUpdate() == 1) {
return true;
}
} catch (SQLException ex) {
Logger.getLogger(ManagerService.class.getName()).log(Level.SEVERE,
null, ex);
}
return false;
}
@Override
public ma.projet.beans.Manager getById(int id) {
ma.projet.beans.Manager manager = null;
try {
String req = "select * from manager where id = ?";
PreparedStatement ps =Connexion.getConnection().prepareStatement(req);
ps.setInt(1, id);
ResultSet rs = ps.executeQuery();
if(rs.next())
manager = new ma.projet.beans.Manager( rs.getString("nom"),rs.getDouble("salaire"));
} catch (SQLException ex) {
Logger.getLogger(ManagerService.class.getName()).log(Level.SEVERE,
null, ex);
}
return manager;
}
@Override
public List<ma.projet.beans.Manager> getAll() {
List <ma.projet.beans.Manager> managers = new ArrayList<>();
try {
String req = "select * from manager ";
PreparedStatement ps =
Connexion.getConnection().prepareStatement(req);
ResultSet rs = ps.executeQuery();
while(rs.next())
managers.add(new ma.projet.beans.Manager(rs.getString("nom"), rs.getDouble("salaire")));
} catch (SQLException ex) {
Logger.getLogger(ManagerService.class.getName()).log(Level.SEVERE,null, ex);
}
return managers;
}

    public void create(String manager, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void ajouterSousOrdre(DeveloppeurService ds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
} 
