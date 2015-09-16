/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maratonworldskills;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Daniel M. Sánchez
 */
public class Conection {
    protected Connection conection;
    protected PreparedStatement query;
    protected ResultSet response;
    
    private String url;
    private String user;
    private String password;
    
    public Conection(String url,String user,String password){
        this.url = url;
        this.user = user;
        this.password = password;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void conectar(){
        try {
            this.conection = DriverManager.getConnection(this.url, this.user, this.password);
            System.out.println("Conection Stablish!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public ResultSet query(String sql){
        try {
            this.query = this.conection.prepareStatement(sql);
            this.response = this.query.executeQuery();
            return this.response;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public void logout(){
        try {
            this.conection.close();
            System.out.println("The conection is close!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
