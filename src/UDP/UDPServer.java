package UDP;

import java.io.*;
import java.net.*;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        // Creamos un socket UDP en el puerto 65433
        DatagramSocket serverSocket = new DatagramSocket(65433);
        System.out.println("Esperando datagramas...");

        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];

        while (true) {
            // Recibimos el datagrama del cliente
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);

            // Convertimos los datos recibidos en un número entero
            int num = Integer.parseInt(new String(receivePacket.getData()).trim());
            // Calculamos el cuadrado del número
            int square = num * num;

            // Obtenemos la dirección IP y el puerto del cliente
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            sendData = String.valueOf(square).getBytes();

            // Enviamos el cuadrado del número de vuelta al cliente
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
        }
    }
}
