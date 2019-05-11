
package sisbanco;

import com.mongodb.*;
import java.net.UnknownHostException;
import java.util.logging.Logger;

public class MongoDB {
    DB data;
    DBCollection coleccion;
    BasicDBObject documento= new BasicDBObject();
    
    public void conectar(){
        try{
        Mongo mongo= new Mongo("localhost",27017);
        data=mongo.getDB("dbCessa");
        coleccion= data.getCollection("facturas");
        }
        catch(UnknownHostException ex){
                System.out.println("No se pudo conectar");
        }
    }
    
    public Factura[] consultar(int idCliente){
        documento.put("id_cliente", idCliente);
        BasicDBObject doc= new BasicDBObject();
        doc.put("_id", 0);
        DBCursor cursor= coleccion.find(documento,doc);
        String[] datos;
        Factura[] facturasPendientes= new Factura[cursor.count()];
        int i=0;
        while(cursor.hasNext()){
            String aux=cursor.next().toString();
            datos=aux.split(",");
            System.out.println("Datos: "+aux);
            String[] partIdFac= datos[0].split(":");
            String[] partMonto= datos[2].split(":");
            int id_factura=Integer.valueOf(partIdFac[1].replaceAll("\\D", ""));
            double monto=Integer.valueOf(partMonto[1].replaceAll("\\D",""))/10;
            facturasPendientes[i]=new Factura("Cessa",id_factura,monto);
            i++;
        }
        return facturasPendientes;
    }
    
}

