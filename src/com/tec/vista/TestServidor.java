package com.tec.vista;

import com.tec.controlador.TCPServidor;
import com.tec.modelo.DatoTCP;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestServidor {

    public static void main(String[] args) {
        try {
            TCPServidor servidor = new TCPServidor(7000);
            DatoTCP dato = servidor.rxTCP();
            System.out.println("IP: " + dato.getIpOrigen());
            System.out.println("Mensaje: " + dato.getMensajeOrigen());
            servidor.cerrarTCP();
        } catch (Exception ex) {
        }
    }
}
