package com.tec.controlador;

import com.tec.modelo.DatoTCP;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
public class TCPCliente {
    private Socket socket;
    private OutputStream flujoSalida;
    private DataOutputStream flujo;
    private String mensaje;
    private DatoTCP dato;
    public TCPCliente(DatoTCP dato)throws IOException {
        this.dato=dato;
        socket = new Socket(dato.getHostServidor(), dato.getPuertoServidor());
        flujoSalida = socket.getOutputStream();
        flujo = new DataOutputStream(flujoSalida);
        System.out.println("Comunicación establecida.");
    }
    public void txTCP(String mensaje) throws IOException {
        this.mensaje = mensaje;
        flujo.writeUTF(mensaje);
        System.out.println("Mensaje enviado");
    }
    public void cerrarTCP() throws IOException {
        flujo.close();
        flujoSalida.close();
        socket.close();
    }
}
