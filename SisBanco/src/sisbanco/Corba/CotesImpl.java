
package example;

import java.util.logging.Level;
import java.util.logging.Logger;
import example.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CotesImpl extends cotesPOA {
    Conectar con;
  
    @Override
  
    public String pedientes(int idcliente){
        try {
            idcliente = 1;
            con = new Conectar();
            Connection reg = con.getConnection();
            PreparedStatement count;
           /* count = reg.prepareStatement("select count(IdFactura) from facturas where IdCliente = "+Integer.toString(idcliente));
            count.executeQuery();*/
            PreparedStatement pstmt;
            pstmt = reg.prepareStatement("SELECT IdFactura, Monto FROM Facturas where IdCliente "+ "= "+Integer.toString(idcliente));
            pstmt.executeQuery();
            
            return pstmt.toString();
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

