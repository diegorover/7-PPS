package UDP;

import java.io.*;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        // Creamos un socket UDP
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("127.0.0.1"); // IP del servidor
        byte[] sendData;
        byte[] receiveData = new byte[1024];

        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Introduce un número: ");
        String num = userInput.readLine();
        sendData = num.getBytes();

        // Enviamos el datagrama al servidor
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, 65433);
        socket.send(sendPacket);

        // Recibimos el datagrama con la respuesta del servidor (el cuadrado del número)
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        socket.receive(receivePacket);

        // Convertimos los datos recibidos en una cadena y la imprimimos
        String receivedSquare = new String(receivePacket.getData()).trim();
        System.out.println("El cuadrado del número es: " + receivedSquare);

        socket.close(); // Cerramos el socket
    }
}


