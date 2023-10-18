/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import ma.preojet.beans.Employe;
import ma.preojet.beans.Message;
import ma.projet.connexion.Connexion;
import ma.projet.dao.IDao;

/**
 *
 * @author DELL
 */
public class MessageService implements IDao<Message>{
   private EmployeService es;
public MessageService() {
es = new EmployeService();
}
@Override
public boolean create(Message o) {
try {
String req = "insert into message (objet, sujet, date, idE, idR)values(?,?,?,?,?)";
PreparedStatement ps =Connexion.getConnection().prepareStatement(req);
ps.setString(1, o.getObjet());
ps.setString(2, o.getSujet());
ps.setDate(3, new Date(o.getDate().getTime()));
ps.setInt(4, o.getExp().getId());
ps.setInt(5, o.getDest().getId());
if (ps.executeUpdate() == 1) {
return true;
}
} catch (SQLException ex) {
Logger.getLogger(MessageService.class.getName()).log(Level.SEVERE,null, ex);
}
return false;
}

@Override
public boolean update(Message o) {
return false;
}
@Override
public boolean delete(Message o) {
return false;
}
@Override
public Message getById(int id) {
Message message = null;
try {
    String query = "SELECT * FROM message WHERE id = ?";
        PreparedStatement ps = Connexion.getConnection().prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
    
        if(rs.next()){
             if (rs.next()) {
                message = new Message( rs.getString("objet"),rs.getString("sujet"),rs.getDate("date"),es.getById(rs.getInt("idE")),es.getById(rs.getInt("idR")));
               
        }
        }
    }catch (SQLException ex) {
Logger.getLogger(MessageService.class.getName()).log(Level.SEVERE,null, ex);
}
return message;
}
@Override
public List<Message> getAll() {
List<Message> employes = new ArrayList<>();
try {
String req = "select * from message ";
PreparedStatement ps =
Connexion.getConnection().prepareStatement(req);
ResultSet rs = ps.executeQuery();
while (rs.next()) {
// à compléter
}
} catch (SQLException ex) {
Logger.getLogger(MessageService.class.getName()).log(Level.SEVERE,
null, ex);
}
return employes;
}
}

