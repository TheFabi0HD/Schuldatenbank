package com.schuldatenbank.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

    public MySQL mySQL = new MySQL("localhost","schuldatenbank","root","");

    public Database(MySQL pMySQL){
        this.mySQL = pMySQL;
    }



    public void createTables(){
        try {
            mySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS SCHUELER(ID INT(255),VORNAME VARCHAR(100), NAME VARCHAR(100), AGE INT(255))").executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public boolean schuelerExists(int pID){
        try {
            PreparedStatement ps = mySQL.getConnection().prepareStatement("SELECT * FROM SCHUELER WHERE ID = ?");
            ps.setInt(1, pID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public void createSchueler(int pID, String pVorname, String pName, int pAlter){
        if (!schuelerExists(pID)) {
            try {
                PreparedStatement ps = mySQL.getConnection().prepareStatement("INSERT INTO SCHUELER(ID, VORNAME, NAME, AGE) VALUES (?,?,?,?)");
                ps.setInt(1, pID);
                ps.setString(2, pVorname);
                ps.setString(3, pName);
                ps.setInt(4, pAlter);
                ps.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else {
            System.out.println("Es existiert bereits ein Schüler mit der ID " + pID + " !");
        }
    }

    public Integer getID(String pVorname, String pName){
        try {
            PreparedStatement ps = mySQL.getConnection().prepareStatement("SELECT ID FROM SCHUELER WHERE VORNAME,NAME = ?");
            ps.setString(1, pVorname);
            ps.setString(2, pName);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                return rs.getInt("ID");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public Integer getAge(int pID){
        try {
            PreparedStatement ps = mySQL.getConnection().prepareStatement("SELECT AGE FROM SCHUELER WHERE ID = ?");
            ps.setInt(1, pID);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                return rs.getInt("AGE");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public String getVorname(int pID){
        try {
            PreparedStatement ps = mySQL.getConnection().prepareStatement("SELECT VORNAME FROM SCHUELER WHERE ID = ?");
            ps.setInt(1, pID);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                return rs.getString("VORNAME");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public String getName(int pID){
        try {
            PreparedStatement ps = mySQL.getConnection().prepareStatement("SELECT NAME FROM SCHUELER WHERE ID = ?");
            ps.setInt(1, pID);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                return rs.getString("NAME");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void updateVorname(int pID, String pVorname){
        try {
            PreparedStatement ps = mySQL.getConnection().prepareStatement("UPDATE SCHUELER SET VORNAME = ? WHERE ID = ?");
            ps.setString(1, pVorname);
            ps.setInt(2, pID);
            ps.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateName(int pID, String pName){
        try {
            PreparedStatement ps = mySQL.getConnection().prepareStatement("UPDATE SCHUELER SET NAME = ? WHERE ID = ?");
            ps.setString(1, pName);
            ps.setInt(2, pID);
            ps.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateAge(int pID, int pAlter){
        try {
            PreparedStatement ps = mySQL.getConnection().prepareStatement("UPDATE SCHUELER SET AGE = ? WHERE ID = ?");
            ps.setInt(1, pAlter);
            ps.setInt(2, pID);
            ps.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
