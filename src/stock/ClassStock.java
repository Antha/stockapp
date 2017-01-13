/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stock;

/**
 *
 * @author intel
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class ClassStock {
    
    int id;
    String nama_barang;
    double harga;
    String kategori;
    
    public ClassStock()
    {
        
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public void setNamaBarang(String nama_barang)
    {
        this.nama_barang = nama_barang;
    }
    
    public void setHarga(double harga)
    {
        this.harga = harga;
    }
    
    public void setKategori(String kategori)
    {
        this.kategori = kategori;
    }
    
    public int getId()
    {
        return this.id;
    }
    
    public double getHarga()
    {
        return this.harga;
    }
    
    public String getKategori()
    {
        return this.kategori;
    }      
    
    public String getNamaBarang()
    {
        return this.nama_barang;
    }
    
    public ResultSet getAllData() throws SQLException
    {
         String sql = "Select * From product";
         Connection conn = new DBConnection().connect();
         Statement stmt = conn.createStatement();
         ResultSet rslt = stmt.executeQuery(sql);
         
         return rslt;
    }
    
    public void insertAllData() throws SQLException
    {
         Connection conn = new DBConnection().connect();
         String sql = "Insert Into product "
                 + "(NAMA_BARANG,HARGA,KATEGORI) "
                 + "Values (?,?,?)";
         PreparedStatement stmt = null;
         stmt = conn.prepareStatement(sql);
         stmt.setString(1, this.getNamaBarang());
         stmt.setString(2, ""+this.getHarga());
         stmt.setString(3, ""+this.getKategori());
         stmt.executeUpdate();
         stmt.close();
    }
    
    
    public void updateData() throws SQLException
    {
         Connection conn = new DBConnection().connect();
         String sql = "update product "
                 + "set NAMA_BARANG = ? "
                 + ",HARGA = ? "
                 + ",KATEGORI = ? "
                 + "where ID = ? ";
         PreparedStatement stmt = null;
         stmt = conn.prepareStatement(sql);
         stmt.setString(1, this.getNamaBarang());
         stmt.setString(2, ""+this.getHarga());
         stmt.setString(3, this.getKategori());
         stmt.setString(4, ""+this.getId());
         stmt.executeUpdate();
         stmt.close();
    }
      
}
