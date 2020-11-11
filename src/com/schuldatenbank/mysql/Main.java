package com.schuldatenbank.mysql;


public class Main {

    public static void main(String[] args){
        MySQL mySQL = new MySQL("localhost","schuldatenbank","root","");
        mySQL.connect();
        Database database = new Database(mySQL);

        database.createTables();

        database.createSchueler(1, "Thomas", "Meyer", 14);
        database.createSchueler(2, "Eva", "Selke", 16);
        database.createSchueler(3, "Konny" , "Zuse", 10);
        database.createSchueler(4, "Frank" , "Frisch", 12);


        System.out.println("Das hier ist " + database.getVorname(1) + " " + database.getName(1) + ". Diese/r ist " + database.getAge(1) + " Jahre alt.");
        System.out.println("Das hier ist " + database.getVorname(2) + " " + database.getName(2) + ". Diese/r ist " + database.getAge(2) + " Jahre alt.");
        System.out.println("Das hier ist " + database.getVorname(3) + " " + database.getName(3) + ". Diese/r ist " + database.getAge(3) + " Jahre alt.");
        System.out.println("Das hier ist " + database.getVorname(4) + " " + database.getName(4) + ". Diese/r ist " + database.getAge(4) + " Jahre alt.");

        mySQL.close();
    }
}
