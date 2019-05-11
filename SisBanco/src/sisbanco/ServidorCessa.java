package sisbanco;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;


public class ServidorCessa 
    extends UnicastRemoteObject
    implements ICessa
	 
{
    ServidorCessa() throws java.rmi.RemoteException{
	super();
    }
    
    public Factura[] pedientes(int idcliente) throws RemoteException {
        MongoDB mongo= new MongoDB();
        mongo.conectar();
        Factura[] facturasPendientes=mongo.consultar(idcliente);
        return facturasPendientes;
    }

        public String pagar(Factura[] facturas) throws RemoteException {
            return "SI";
    }    
    
    
    
    public static void main(String args[]) { 
	try {
	    ServidorCessa cessa;
	    LocateRegistry.createRegistry(1099);
	    cessa=new ServidorCessa(); 
	    Naming.bind("Cessa", cessa); 
            System.out.println("El servidor esta listo\n");
        }
	catch (Exception e){
	    e.printStackTrace();
	}
    } 
   
}


