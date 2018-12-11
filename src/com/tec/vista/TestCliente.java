package com.tec.vista;

import com.tec.controlador.TCPCliente;
import com.tec.modelo.DatoTCP;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestCliente {

    public static void main(String[] args) {
        try {
            DatoTCP dato = new DatoTCP("localhost", 7000);
            TCPCliente cliente = new TCPCliente(dato);
            cliente.txTCP("21-11-2018");
            cliente.cerrarTCP();
        } catch (Exception ex) {
        }
    }

}
