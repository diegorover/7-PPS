package TCP;

import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        // Creamos un servidor en el puerto 65432
        ServerSocket serverSocket = new ServerSocket(65432);
        System.out.println("Esperando conexiones...");

        // Aceptamos la conexión entrante
        try (Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            // Imprimimos la dirección IP del cliente
            System.out.println("Conexión establecida desde: " + clientSocket.getInetAddress());

            String inputLine;
            // Leemos el número enviado por el cliente
            while ((inputLine = in.readLine()) != null) {
                int num = Integer.parseInt(inputLine);
                // Calculamos el cuadrado del número
                int square = num * num;
                // Enviamos el cuadrado al cliente
                out.println(square);
            }
        }
    }
}
