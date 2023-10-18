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
import ma.projet.dao.IDao;
import ma.projet.beans.Developpeur;
import ma.projet.connexion.Connexion;
/**
 *
 * @author DELL
 */
public class DeveloppeurService implements IDao<Developpeur>{
    private Connection connection;  // Assurez-vous d'avoir initialisé cette connexion correctement

 
    
    
  @Override
public boolean create(Developpeur o) {
try {
String req = "insert into developpeur (nom, prenom) values(?,?)";

PreparedStatement ps =Connexion.getConnection().prepareStatement(req);
ps.setString(1, o.getNom());
ps.setDouble(2, o.getSalaire());
if (ps.executeUpdate() == 1) {
return true;
}
} catch (SQLException ex) {
Logger.getLogger(DeveloppeurService.class.getName()).log(Level.SEVERE,
null, ex);
}
return false;
}
@Override
public boolean update(Developpeur o) {
try {
String req = "update developpeur set nom = ? , prenom = ? where id =?";
PreparedStatement ps =Connexion.getConnection().prepareStatement(req);
ps.setString(1, o.getNom());
ps.setDouble(2, o.getSalaire());

if (ps.executeUpdate() == 1) {
return true;
}
} catch (SQLException ex) {
Logger.getLogger(DeveloppeurService.class.getName()).log(Level.SEVERE,
null, ex);
}
return false;
}
@Override
public boolean delete(Developpeur o) {
try {
String req = "delete from developpeur where id = ?";
PreparedStatement ps =Connexion.getConnection().prepareStatement(req);

if (ps.executeUpdate() == 1) {
return true;
}
} catch (SQLException ex) {
Logger.getLogger(DeveloppeurService.class.getName()).log(Level.SEVERE,
null, ex);
}
return false;
}
@Override
public Developpeur getById(int id) {
Developpeur developpeur = null;
try {
String req = "select * from developpeur where id = ?";
PreparedStatement ps =Connexion.getConnection().prepareStatement(req);
ps.setInt(1, id);
ResultSet rs = ps.executeQuery();
if(rs.next())
developpeur = new Developpeur( rs.getString("nom"),rs.getDouble("salaire"));
} catch (SQLException ex) {
Logger.getLogger(DeveloppeurService.class.getName()).log(Level.SEVERE,
null, ex);
}
return developpeur;
}
@Override
public List<Developpeur> getAll() {
List <Developpeur> developpeurs = new ArrayList<>();
try {
String req = "select * from developpeur ";
PreparedStatement ps =
Connexion.getConnection().prepareStatement(req);
ResultSet rs = ps.executeQuery();
while(rs.next())
developpeurs.add(new Developpeur(rs.getString("nom"), rs.getDouble("salaire")));
} catch (SQLException ex) {
Logger.getLogger(DeveloppeurService.class.getName()).log(Level.SEVERE,null, ex);
}
return developpeurs;
}

    public void create(String développeur_1, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
} 

