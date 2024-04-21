package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {
    public String bd = "";
    public String url = "jdbc:mysql://localhost:3306/";
    public String user = "root";
    public String password = "";
    public String driver = "com.mysql.cj.jdbc.Driver";
    public Connection cx;
    
    public Conexion(String b){
        bd = b;
        try {
            Class.forName(driver);
            cx = DriverManager.getConnection(url+bd,user,password);
            //System.out.println("Conexion Exitosa A La BD: "+bd);
            //JOptionPane.showMessageDialog(null,"Conexion Exitosa.");
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null,"Conexion Fallida.");
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }
    }
    
    public void Desconectar(){
        try {
            //System.out.println("Desconexion Exitosa A La BD: "+bd);
            cx.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Desconexion Fallida.");
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }    
    }

}
