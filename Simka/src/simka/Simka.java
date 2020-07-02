/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simka;
import database.koneksi;
import java.sql.SQLException;
import view.data;
/**
 *
 * @author Nuril
 */
public class Simka {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException{
        new data().show();
//new koneksi();
    }
    
}
