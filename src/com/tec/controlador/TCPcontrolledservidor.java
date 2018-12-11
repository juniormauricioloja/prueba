
package com.tec.controlador;

import com.tec.modelo.DatoTCP;
import com.tec.vista.InterfazServidor;
import com.tec1.controlador.SerialTx;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TCPcontrolledservidor extends Thread {
    TCPServidor servidor;
    DatoTCP dato;
    SerialTx serial;
    public TCPcontrolledservidor(int puertoServidor) throws IOException {
        servidor = new TCPServidor(puertoServidor);
        serial = new SerialTx();
    }
    public void run(){
        while (true) {            
            try {
                DatoTCP dato = servidor.rxTCP();
                if(dato.getMensajeOrigen()=="ASwitch1"){
                serial.txMensaje("COM1","ALed1");   
                InterfazServidor.jpLed1.setBackground(Color.GREEN);
                }
                if(dato.getMensajeOrigen()=="BSwitch1"){
                serial.txMensaje("COM1","BLed1");   
                InterfazServidor.jpLed1.setBackground(Color.RED);
                }
                if(dato.getMensajeOrigen()=="ASwitch2"){
                serial.txMensaje("COM1","ALed2");   
                InterfazServidor.jpLed2.setBackground(Color.GREEN);
                }
                if(dato.getMensajeOrigen()=="BSwitch2"){
                serial.txMensaje("COM1","BLed2");   
                InterfazServidor.jpLed2.setBackground(Color.RED);
                }               
            } catch (Exception ex) {
                Logger.getLogger(TCPcontrolledservidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
