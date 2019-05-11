
package example;

import java.util.logging.Level;
import java.util.logging.Logger;
import example.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CotesImpl extends cotesPOA {
    Conectar con;
  
    @Override
  
    public String pedientes(int idcliente){
        try {
            String cadena = "";
            idcliente = 1;
            con = new Conectar();
            Connection reg = con.getConnection();
            String query = "SELECT * FROM Facturas WHERE IdCliente = "+idcliente;
            PreparedStatement prepStmnt = reg.prepareStatement(query);
            ResultSet dataset = prepStmnt.executeQuery(); 
            while(dataset.next()){
                if(dataset.getString("Estado").equals("Pendiente")){
                    if(cadena.equals("")){
                        cadena= cadena+dataset.getString("IdFactura");
                        cadena= cadena+"-"+dataset.getString("Monto")+",";
                    }
                    else{
                        cadena= cadena+"-"+dataset.getString("IdFactura");
                        cadena= cadena+"-"+dataset.getString("Monto")+",";
                    }
                }
            }
            cadena = cadena.substring(0, cadena.length()-1);
            return cadena;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
        
        
    }
    public String pagar(String facturas){
        try {
            con = new Conectar();
            Connection reg = con.getConnection();
            PreparedStatement pstmt = reg.prepareStatement("UPDATE Facturas set Estado = 'Pagado' Where IdFactura = "+facturas );
            int i = pstmt.executeUpdate();
            System.out.println(""+i+"actualizado con exito");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "SI";
    }
}

