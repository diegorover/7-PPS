package TCP;

import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        String hostName = "127.0.0.1"; // IP del servidor
        int portNumber = 65432; // Puerto del servidor

        try (
                // Creamos un socket para conectarnos al servidor
                Socket socket = new Socket(hostName, portNumber);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
        ) {
            System.out.print("Introduce un número: ");
            String userInput;
            // Leemos el número ingresado por el usuario
            while ((userInput = stdIn.readLine()) != null) {
                // Enviamos el número al servidor
                out.println(userInput);
                // Imprimimos la respuesta del servidor (el cuadrado del número)
                System.out.println("Respuesta del servidor: " + in.readLine());
                System.out.print("Introduce otro número (o CTRL+C para salir): ");
            }
        }
    }
}
