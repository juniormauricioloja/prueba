package com.tec.controlador;
import com.tec.modelo.DatoTCP;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class TCPServidor {
    private ServerSocket serverSocket;
    private Socket socket;
    private InputStream flujoEntrada;
    private DataInputStream flujo;
    private DatoTCP dato;
    private int puerto;
    public TCPServidor(int puerto) throws IOException {
        this.puerto = puerto;
        serverSocket = new ServerSocket(puerto);
        System.out.println("Servidor configurado.");
    }
    public DatoTCP rxTCP() throws IOException{
        socket= serverSocket.accept();
        flujoEntrada= socket.getInputStream();
        flujo= new DataInputStream(flujoEntrada);
        dato = new DatoTCP(flujo.readUTF(), socket.getInetAddress().toString());
        System.out.println("Mensaje recibido.");
        return dato;
    } 
    public void cerrarTCP() throws IOException{
        flujo.close();
        flujoEntrada.close();
        socket.close();
        serverSocket.close();
    }
    
}
