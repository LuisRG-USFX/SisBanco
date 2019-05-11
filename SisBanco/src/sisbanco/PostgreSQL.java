
package sisbanco;

import java.sql.*;


public class PostgreSQL {
    Connection con;
    Statement st;
    ResultSet resultado;
    
    public void conectar() throws SQLException, ClassNotFoundException{ 
        Class.forName("org.postgresql.Driver");
        con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbElapas","postgres","9874563210");
    }
    
    public void consultar(int id)throws SQLException, ClassNotFoundException{
        String consulta= "SELECT * FROM facturas WHERE id_cliente="+id+";";
        conectar();
        st=con.createStatement();
        resultado=st.executeQuery(consulta);
    }
    
    public void cerrar() throws SQLException, ClassNotFoundException{
        resultado.close();
        st.close();
        con.close();
    }

    public ResultSet getResultado() {
        return resultado;
    }
    
    public void update(int idFactura, String nuevoEstado) throws SQLException, ClassNotFoundException{
        String consulta= "UPDATE facturas SET estado='"+nuevoEstado+"' WHERE id_factura="+idFactura+";";
        st=con.createStatement();
        st.executeQuery(consulta);
    }
    
}
