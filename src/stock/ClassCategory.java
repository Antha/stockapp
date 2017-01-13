/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stock;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author intel
 */
public class ClassCategory {
    
    public int Id;
    public String Category;
    
    public ClassCategory()
    {
        
    }
    
    public void setId(int Id)
    {
        this.Id = Id;
    }
    
    public void setCategory(String Category)
    {
        this.Category = Category;
    }
    
    public int getId()
    {
        return this.Id;
    }
    
    public String getCategory()
    {
        return this.Category;
    }
    
    public ResultSet getAllData() throws SQLException
    {
         String sql = "Select * From category";
         Connection conn = new DBConnection().connect();
         Statement stmt = conn.createStatement();
         ResultSet rslt = stmt.executeQuery(sql);
         
         return rslt;
    }
    
    public void insertAllData() throws SQLException
    {
         Connection conn = new DBConnection().connect();
         String sql = "Insert Into category "
                 + "(KATEGORI) "
                 + "Values (?)";
         PreparedStatement stmt = null;
         stmt = conn.prepareStatement(sql);
         stmt.setString(1, this.getCategory());
         stmt.executeUpdate();
         stmt.close();
    }
    
    public void updateData() throws SQLException
    {
         Connection conn = new DBConnection().connect();
         String sql = "update category set "
                 + "KATEGORI = ? "
                 + "where ID = ? ";
         PreparedStatement stmt = null;
         stmt = conn.prepareStatement(sql);
         stmt.setString(1, this.getCategory());
         stmt.setString(2, ""+this.getId());
         stmt.executeUpdate();
         stmt.close();
    }
}
