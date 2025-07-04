package clientecuadrado; 

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClienteCuadrado {

    public static void main(String[] args) {
       

        try (Socket socket = new Socket("localhost", 5000)) {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);

            System.out.print("Ingresa tu nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingresa un número entero: ");
            int numero = scanner.nextInt();

            salida.println(nombre);
            salida.println(numero);

            System.out.println(entrada.readLine());
            System.out.println(entrada.readLine());
            System.out.println(entrada.readLine());

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}