package examenfinal;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorCuadrado {

    
    public static void main(String[] args) {
           try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Servidor iniciado en el puerto " + 5000);
            System.out.println("Esperando conexiones...");

            while (true) {
                Socket socketCliente = serverSocket.accept();
                ManejadorCliente cliente = new ManejadorCliente(socketCliente);
                Thread hilo = new Thread(cliente);
                hilo.start();
            }

        } catch (IOException e) {
            System.out.println(e); 
        } 
    }
    
}
