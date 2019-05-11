package sisbanco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServidorElapas {
    private static String getFacturas(int id) throws SQLException, ClassNotFoundException{
        ResultSet result;
        String facts="";
        PostgreSQL pg = new PostgreSQL();
        pg.conectar();
        pg.consultar(id);
        result= pg.getResultado();
        while(result.next()){
            if(facts.equals("")){
                facts=facts+result.getInt("id_factura")+"-"+result.getInt("monto");
            }
            else{
            facts=facts+","+result.getInt("id_factura")+"-"+result.getInt("monto");
            }
        }
        pg.cerrar();
        return facts;
    }
    
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        int port = 5001; // puerto en el que escuchara el socket
        String Respuesta="";
        try 
        {
            ServerSocket server = new ServerSocket(port); //instanciamos un servidor socket
            System.out.println("El servidor esta listo\n");
            Socket client;
            BufferedReader fromClient;  // buffer de lectura
            PrintStream toClient;       // stream para escritura
            while (true) {   // ciclo al infinito para elfuncionamiento del server
                client = server.accept(); // aceptala conexion
                fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
                String cadena;
                cadena = fromClient.readLine(); //cadena obtenida desde el lector
                toClient = new PrintStream(client.getOutputStream()); //prepara el objetopara devolver
                System.out.println("Comando Recibido"+cadena);
                if (cadena.substring(3, 4).equals("-")) {
                    String  comando = cadena.substring(0, 3);
                    
                    if (comando.equals("fac")) {
                        Integer idcliente  = Integer.parseInt(cadena.substring(4));
                        Respuesta=getFacturas(idcliente);
                        }
                    if (comando.equals("pag")) {
                            Respuesta="SI";
                    }
                    System.out.print(Respuesta);
                    toClient.flush();
                    toClient.println(Respuesta);
                } else {
                    toClient.flush();
                    toClient.println("No se reconoce el comando");
                }
            }

        }
        catch(IOException e

    
        ){
            System.out.println(e.getMessage());
    }
    }
}
