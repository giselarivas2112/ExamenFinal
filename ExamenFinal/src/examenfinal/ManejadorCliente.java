/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenfinal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ManejadorCliente implements Runnable {
    
    private Socket socketCliente;

    public ManejadorCliente(Socket socketClase) {
        this.socketCliente = socketClase;
    }

    @Override
    public void run() {
        try {
            
            InputStream inputStream = socketCliente.getInputStream();
            OutputStream outputStream = socketCliente.getOutputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter writer = new PrintWriter(outputStream, true);

            String nombre = reader.readLine();
            int numero = Integer.parseInt(reader.readLine());

            System.out.println("Cliente " + nombre + " conectado");

            int cuadrado = numero * numero;

            LocalDateTime ahora = LocalDateTime.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String fechaHora = ahora.format(formato);

            writer.println("Bienvenidooo " + nombre + ":D");
            writer.println("El cuadrado de tu número es: " + cuadrado);
            writer.println("Fecha y hora del servidor: " + fechaHora);


            socketCliente.close();
            System.out.println("Cliente " + nombre + " desconectado.");

        } catch (IOException e) {
            System.out.println(e); 
        }
    }
}
