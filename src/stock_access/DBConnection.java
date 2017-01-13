package stock_access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 * @author Agus Sumarna
 */
public class DBConnection {
    private Connection koneksi;

    public Connection connect(){
       //untuk koneksi ke driver
       try{
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           System.out.println("Sucess loading MS Access JDBC driver");
           System.out.println("berhasil load driver");
       }catch(ClassNotFoundException cnfe){
           System.out.println("Tidak ada Driver "+cnfe);
       }

       //untuk koneksi ke database
       try{
           String dbname = "C:/stock.accdb";
           String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};"
                   + "DSN="+dbname+";";
           koneksi = DriverManager.getConnection(url);
           System.out.println("Berhasil koneksi");
       }catch(SQLException se){
           System.out.println("Gagal koneksi "+se);
           JOptionPane.showMessageDialog(null,"Gagal Koneksi Database","Peringatan",JOptionPane.WARNING_MESSAGE);
       }
       return koneksi;
    }
}
