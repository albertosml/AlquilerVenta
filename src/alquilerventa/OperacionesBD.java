package alquilerventa;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author albertosml
 */
public class OperacionesBD {
    
    private String[] meses;
    
    public OperacionesBD() {
        meses = new String[]{"ENERO","FEBRERO","MARZO","ABRIL","MAYO","JUNIO",
            "JULIO","AGOSTO","SEPTIEMBRE","OCTUBRE","NOVIEMBRE","DICIEMBRE"};
    }
    
    public String obtainMes(int n) { return meses[n]; }
    
    private Connection conectar() throws ClassNotFoundException {
        // SQLite connection string
        String url = "jdbc:sqlite:bd.db";
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("error");
        }
        return conn;
    }
 
    private void desconectar(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println("error");
        }
    }
    
    public String addCliente(String nombre) throws ClassNotFoundException {
        String sql = "INSERT INTO Cliente(nombre) VALUES (?);";
 
        try {
            Connection conn = this.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nombre);
            pstmt.executeUpdate();
            
            this.desconectar(conn);
        } catch (SQLException e) {
            return "error";
        }
        
        return "";
    }
    
    public ArrayList<String> obtainClientsList() throws ClassNotFoundException {
        String sql = "SELECT * FROM Cliente;";
 
        ArrayList<String> nombres = new ArrayList<>();
        
        try {
            Connection conn = this.conectar();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            // loop through the result set
            while (rs.next()) {
                nombres.add(rs.getInt("id") + ": " + rs.getString("nombre"));
            }
            
            this.desconectar(conn);
            
            if(nombres.size() == 0) nombres.add("error");
            
            return nombres;
        } catch (SQLException e) {
            nombres.clear();
            nombres.add("error");
            return nombres;
        }
    }
    
    public String updateClient(String id, String nombre) throws ClassNotFoundException {
        String sentencia = "UPDATE Cliente SET nombre = ? WHERE id = ?;";     
        
        try {
            Connection conn = this.conectar();
            
            PreparedStatement stmt = conn.prepareStatement(sentencia);
            stmt.setString(1, nombre);
            stmt.setString(2, id);
            stmt.executeUpdate();
            
            this.desconectar(conn);
            
            return "";
        } catch (SQLException e) {
            return "error";
        }
    }
    
    public String deleteClient(String idCli) throws ClassNotFoundException{
        // Compruebo si ya hay registrado un alquiler de ese cliente
        String sql = "SELECT COUNT(*) AS num_pisos FROM Alquiler WHERE inquilino=?;";
      
        try {
            Connection conn = this.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, idCli);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.getInt("num_pisos") == 0) {
                // Compruebo si ya hay registrada una venta de ese cliente
                sql = "SELECT COUNT(*) AS num_ventas FROM Venta WHERE cliente=?;";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, idCli);
                rs = stmt.executeQuery();
                
                if(rs.getInt("num_ventas") == 0) {
                    // Compruebo si hay registrado un piso con ese cliente como inquilino
                    sql = "SELECT COUNT(*) AS num_pisos_inq FROM Piso WHERE inquilino=?;";
                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1, idCli);
                    rs = stmt.executeQuery();
              
                    if(rs.getInt("num_pisos_inq") == 0) {
                        // Eliminamos el cliente
                        sql = "DELETE FROM Cliente WHERE id=?;";
                        stmt = conn.prepareStatement(sql);
                        stmt.setString(1, idCli);
                        stmt.executeUpdate();
                        
                        this.desconectar(conn);

                        return "";
                    }
                    else {
                        this.desconectar(conn);
            
                        return "piso";
                    } 
                }
                else {
                    this.desconectar(conn);
            
                    return "ven";
                }
            }
            else {
                this.desconectar(conn);
            
                return "alq";
            }    
        } catch (SQLException e) {
            return "error";
        }
    }
    
    public String addPiso(String domicilio, String inquilinoId, String precio) throws ClassNotFoundException {
        String sql = "INSERT INTO Piso(domicilio,inquilino,preciomes) VALUES (?,?,?);";
 
        try {
            Connection conn = this.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, domicilio);
            if(inquilinoId.matches("[0-9]+")) pstmt.setString(2, inquilinoId);
            else pstmt.setString(2, null);
            pstmt.setFloat(3, Float.parseFloat(precio));
            pstmt.executeUpdate();
            
            this.desconectar(conn);
        } catch (SQLException e) {
            return "error";
        }
        
        return "";
    }
    
    public ArrayList<String> obtainPisosList() throws ClassNotFoundException {
        String sql = "SELECT id,domicilio FROM Piso;";
 
        ArrayList<String> nombres = new ArrayList<>();
        
        try {
            Connection conn = this.conectar();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            // loop through the result set
            while (rs.next()) {
                nombres.add(rs.getInt("id") + ": " + rs.getString("domicilio"));
            }
            
            this.desconectar(conn);
            
            if(nombres.size() == 0) nombres.add("error");
            
            return nombres;
        } catch (SQLException e) {
            nombres.clear();
            nombres.add("error");
            return nombres;
        }
    }
    
    public ArrayList<Object> obtainPiso(String id) throws ClassNotFoundException {
        String sql = "SELECT domicilio,inquilino,preciomes FROM Piso WHERE id=?";
        
        ArrayList<Object> trabajador = new ArrayList<>();
        
        try {
            Connection conn = this.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            
            // loop through the result set
            while (rs.next()) {
                trabajador.add(rs.getString("domicilio"));
                trabajador.add(rs.getString("inquilino"));
                trabajador.add(rs.getFloat("preciomes"));
            }
            
            this.desconectar(conn);
            
            return trabajador;
        } catch (SQLException e) {
            trabajador.clear();
            trabajador.add("error");
            return trabajador;
        }
       
    }
    
    public String updatePiso(String id, String domicilio, String inquilinoId, String preciomes) throws ClassNotFoundException, IOException {
        String sentencia = "UPDATE Piso SET domicilio=?,inquilino=?,preciomes=? WHERE id = ?";
        
        try {
            Connection conn = this.conectar();
            
            PreparedStatement stmt = conn.prepareStatement(sentencia);
            stmt.setString(1, domicilio);
            if(inquilinoId.matches("[0-9]+")) stmt.setString(2, inquilinoId);
            else stmt.setString(2, null);
            stmt.setString(3, preciomes);
            stmt.setString(4, id);
            stmt.executeUpdate();

            this.desconectar(conn);
            
            return "";
        } catch (SQLException e) { return "error"; }
    }
    
    public String deletePiso(String idPiso) throws ClassNotFoundException{
        // Compruebo si ya hay registrado un alquiler con ese piso
        String sql = "SELECT COUNT(*) AS num_pisos FROM Alquiler WHERE idPiso=?;";
      
        try {
            Connection conn = this.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, idPiso);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.getInt("num_pisos") == 0) {
                sql = "DELETE FROM Piso WHERE id=?;";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, idPiso);
                stmt.executeUpdate();
                
                this.desconectar(conn);
            
                return "";
            }
            else {
                this.desconectar(conn);
            
                return "no";
            }    
                
        } catch (SQLException e) {
            return "error";
        }
    }
    
    public String addElemento(String nombre, String preciouni) throws ClassNotFoundException {
        String sql = "INSERT INTO Elemento(nombre,preciounidad) VALUES (?,?);";
 
        try {
            Connection conn = this.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nombre);
            pstmt.setString(2, preciouni);
            pstmt.executeUpdate();
            
            this.desconectar(conn);
        } catch (SQLException e) {
            return "error";
        }
        
        return "";
    }
    
    public ArrayList<String> obtainElementosList() throws ClassNotFoundException {
        String sql = "SELECT id,nombre FROM Elemento;";
 
        ArrayList<String> nombres = new ArrayList<>();
        
        try {
            Connection conn = this.conectar();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            // loop through the result set
            while (rs.next()) {
                nombres.add(rs.getInt("id") + ": " + rs.getString("nombre"));
            }
            
            this.desconectar(conn);
            
            if(nombres.size() == 0) nombres.add("error");
            
            return nombres;
        } catch (SQLException e) {
            nombres.clear();
            nombres.add("error");
            return nombres;
        }
    }
    
    public ArrayList<Object> obtainElemento(String id) throws ClassNotFoundException {
        String sql = "SELECT nombre,preciounidad FROM Elemento WHERE id=?";
        
        ArrayList<Object> trabajador = new ArrayList<>();
        
        try {
            Connection conn = this.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            
            // loop through the result set
            while (rs.next()) {
                trabajador.add(rs.getString("nombre"));
                trabajador.add(rs.getFloat("preciounidad"));
            }
            
            this.desconectar(conn);
            
            return trabajador;
        } catch (SQLException e) {
            trabajador.clear();
            trabajador.add("error");
            return trabajador;
        }
       
    }
    
    public String updateElemento(String id, String nombre, String preciouni) throws ClassNotFoundException {
        String sentencia = "UPDATE Elemento SET nombre=?,preciounidad=? WHERE id = ?";
        
        try {
            Connection conn = this.conectar();
            
            PreparedStatement stmt = conn.prepareStatement(sentencia);
            stmt.setString(1, nombre);
            stmt.setString(2, preciouni);
            stmt.setString(3, id);
            stmt.executeUpdate();

            this.desconectar(conn);
            
            return "";
        } catch (SQLException e) { return "error"; }
    }
    
    public String deleteElemento(String idElem) throws ClassNotFoundException{
        // Compruebo si ya hay registrado una venta de ese elemento
        String sql = "SELECT COUNT(*) AS num_elem FROM Venta WHERE idElemento=?;";
      
        try {
            Connection conn = this.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, idElem);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.getInt("num_elem") == 0) {
                sql = "DELETE FROM Elemento WHERE id=?;";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, idElem);
                stmt.executeUpdate();
                
                this.desconectar(conn);
            
                return "";
            }
            else {
                this.desconectar(conn);
            
                return "no";
            }    
                
        } catch (SQLException e) {
            return "error";
        }
    }
    
    public ArrayList<Object> obtainAlquiler(String idPiso, int mes, int anio) throws ClassNotFoundException{
        String sql = "SELECT inquilino,precio FROM Alquiler WHERE mes=? and anio=? and idPiso=?;";

        ArrayList<Object> a = new ArrayList<>();
        
        try {
            Connection conn = this.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, meses[mes]);
            stmt.setInt(2, anio);
            stmt.setString(3, idPiso);
            ResultSet rs = stmt.executeQuery();
            
            sql = "SELECT inquilino,preciomes from Piso where id=?;";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, idPiso);
            ResultSet rs_c = stmt.executeQuery();
            
            
            // loop through the result set
            if (rs.next()) {
                a.add(rs.getString("inquilino"));
                a.add(rs.getFloat("precio"));
                a.add(true);
                a.add(rs.getInt("inquilino") == rs_c.getInt("inquilino"));
            }
            else if(rs_c.next()) {
                a.add(rs_c.getString("inquilino"));
                a.add(rs_c.getFloat("preciomes"));
                a.add(false);
                a.add(true);
            }
            
            sql = "SELECT id,nombre from Cliente where id=?;";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, (String) a.get(0));
            rs = stmt.executeQuery();
            
            if(rs.next()) a.set(0, rs.getString("id") + ": " + rs.getString("nombre"));
            
            this.desconectar(conn);
            
            return a;
        } catch (SQLException e) {
            a.clear();
            a.add("error");
            return a;     
        }
    }
    
    public String addVenta(String idElemento, String idCli, Float cantidad, Date fecha) throws ClassNotFoundException {
        String sql = "INSERT INTO Venta VALUES (?,?,?,?,?,?,?);";
 
        try {
            Connection conn = this.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, idElemento);
            pstmt.setString(2, idCli);
            
            pstmt.setInt(3, fecha.getDate());
            pstmt.setString(4, meses[fecha.getMonth()]);
            pstmt.setInt(5, fecha.getYear() + 1900);
            
            pstmt.setFloat(6, cantidad);
            
            ArrayList<Object> a = this.obtainElemento(idElemento);
            pstmt.setFloat(7, (float) a.get(1));
            
            pstmt.executeUpdate();
            
            this.desconectar(conn);
        } catch (SQLException e) {
            return "error";
        }
        
        return "";
    }
    
    public ArrayList<Vector<String>> obtainVentas(String idElemento, String idCli, String year) throws ClassNotFoundException {
        String sql = "SELECT cliente,idElemento,dia,mes,anio,cantidad,precio FROM Venta WHERE ";
        
        if(idElemento != null && idCli != null && year != null) sql += "idElemento=? and cliente=? and anio=?;";
        else if(idElemento != null && idCli != null) sql += "idElemento=? and cliente=?;";
        else if(idElemento != null && year != null) sql += "idElemento=? and anio=?;";
        else if(idCli != null && year != null) sql += "cliente=? and anio=?;";
        else if(idCli != null) sql += "cliente=?;";
        else if(year != null) sql += "anio=?;";
        else sql += "idElemento=?;";
        
        ArrayList<Vector<String>> a = new ArrayList<>();
        
        try {
            Connection conn = this.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            if(idElemento != null && idCli != null && year != null) {
                stmt.setString(1, idElemento);
                stmt.setString(2, idCli);
                stmt.setString(3, year);
            }
            else if(idElemento != null && idCli != null) {
                stmt.setString(1, idElemento);
                stmt.setString(2, idCli);
            }
            else if(idElemento != null && year != null) {
                stmt.setString(1, idElemento);
                stmt.setString(2, year);
            }
            else if(idCli != null && year != null) {
                stmt.setString(1, idCli);
                stmt.setString(2, year);
            }
            else if(idCli != null) stmt.setString(1, idCli);
            else if(year != null) stmt.setString(1, year);
            else stmt.setString(1, idElemento);
                
            ResultSet rs = stmt.executeQuery();
            
            // loop through the result set
            while (rs.next()) {
                Vector<String> v = new Vector<>();
                v.add(rs.getString("dia"));
                v.add(rs.getString("mes"));
                v.add(rs.getString("anio"));
                v.add(rs.getString("cantidad"));
                v.add(rs.getString("precio"));
                
                sql = "SELECT nombre from Cliente where id=?;";
                
                PreparedStatement stmt_c = conn.prepareStatement(sql);
                stmt_c.setString(1, rs.getString("cliente"));
                ResultSet rs_c = stmt_c.executeQuery();
                
                if(rs_c.next()) v.add(rs_c.getString("nombre"));
                else v.add("No hay cliente");
                
                sql = "SELECT nombre from Elemento where id=?;";
                
                stmt_c = conn.prepareStatement(sql);
                stmt_c.setString(1, rs.getString("idElemento"));
                rs_c = stmt_c.executeQuery();
                
                if(rs_c.next()) v.add(rs_c.getString("nombre"));
                else v.add("No hay elemento");
                    
                a.add(v);
            }
            
            this.desconectar(conn);
            
            return a;
        } catch (SQLException e) {
            a.clear();
            
            Vector<String> v = new Vector<>();
            v.add("error");
            
            a.add(v);
            return a;
        }
       
    }
    
    public String deleteAlquiler(String idPiso, int mes, int anio) throws ClassNotFoundException{
        String sql = "DELETE FROM Alquiler WHERE mes=? and anio=? and idPiso=?;";
      
        try {
            Connection conn = this.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, meses[mes]);
            stmt.setInt(2, anio);
            stmt.setString(3, idPiso);
            stmt.executeUpdate();
            
            this.desconectar(conn);
            
            return "";
        } catch (SQLException e) {
            return "error";
        }
    }
    
    public String insertAlquiler(String idPiso, int mes, int anio, String idInquilino, Float precio) throws ClassNotFoundException{
        String sql = "INSERT INTO Alquiler VALUES (?,?,?,?,?);";
        
        try {
            Connection conn = this.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, idPiso);
            stmt.setString(2, meses[mes]);
            stmt.setInt(3, anio);
            stmt.setString(4, idInquilino);
            stmt.setFloat(5, precio);
            stmt.executeUpdate();
            
            this.desconectar(conn);
            
            return "";
        } catch (SQLException e) {
            return "error";
        }
    }
    
    public ArrayList<Vector<String>> obtainAlquileres(String idPiso, String idCli, String year) throws ClassNotFoundException {
        String sql = "SELECT inquilino,idPiso,mes,anio,precio FROM Alquiler WHERE ";
        
        if(idPiso != null && idCli != null && year != null) sql += "idPiso=? and inquilino=? and anio=?;";
        else if(idPiso != null && idCli != null) sql += "idPiso=? and inquilino=?;";
        else if(idPiso != null && year != null) sql += "idPiso=? and anio=?;";
        else if(idCli != null && year != null) sql += "inquilino=? and anio=?;";
        else if(idCli != null) sql += "inquilino=?;";
        else if(year != null) sql += "anio=?;";
        else sql += "idPiso=?;";
        
        ArrayList<Vector<String>> a = new ArrayList<>();
        
        try {
            Connection conn = this.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            if(idPiso != null && idCli != null && year != null) {
                stmt.setString(1, idPiso);
                stmt.setString(2, idCli);
                stmt.setString(3, year);
            }
            else if(idPiso != null && idCli != null) {
                stmt.setString(1, idPiso);
                stmt.setString(2, idCli);
            }
            else if(idPiso != null && year != null) {
                stmt.setString(1, idPiso);
                stmt.setString(2, year);
            }
            else if(idCli != null && year != null) {
                stmt.setString(1, idCli);
                stmt.setString(2, year);
            }
            else if(idCli != null) stmt.setString(1, idCli);
            else if(year != null) stmt.setString(1, year);
            else stmt.setString(1, idPiso);
                
            ResultSet rs = stmt.executeQuery();
            
            // loop through the result set
            while (rs.next()) {
                Vector<String> v = new Vector<>();
                v.add(rs.getString("mes"));
                v.add(rs.getString("anio"));
                v.add(rs.getString("precio"));
                
                sql = "SELECT nombre from Cliente where id=?;";
                
                PreparedStatement stmt_c = conn.prepareStatement(sql);
                stmt_c.setString(1, rs.getString("inquilino"));
                ResultSet rs_c = stmt_c.executeQuery();
                
                if(rs_c.next()) v.add(rs_c.getString("nombre"));
                else v.add("No hay inquilino");
                
                sql = "SELECT domicilio from Piso where id=?;";
                
                stmt_c = conn.prepareStatement(sql);
                stmt_c.setString(1, rs.getString("idPiso"));
                rs_c = stmt_c.executeQuery();
                
                if(rs_c.next()) v.add(rs_c.getString("domicilio"));
                else v.add("No hay domicilio");
                    
                a.add(v);
            }
            
            this.desconectar(conn);
            
            return a;
        } catch (SQLException e) {
            a.clear();
            
            Vector<String> v = new Vector<>();
            v.add("error");
            
            a.add(v);
            return a;
        }
       
    }
}
