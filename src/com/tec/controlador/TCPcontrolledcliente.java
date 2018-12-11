/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tec.controlador;

import com.tec.modelo.DatoTCP;
import com.tec.vista.InterfazCliente;
import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.comm.CommPortIdentifier;
import javax.comm.NoSuchPortException;
import javax.comm.PortInUseException;
import javax.comm.SerialPort;
import javax.comm.UnsupportedCommOperationException;

/**
 *
 * @author MAURICIO
 */
public class TCPcontrolledcliente extends Thread {
    private CommPortIdentifier idPuerto;
    private SerialPort puertoSerie;
    private InputStream flujoEntrada;
    private byte [] buffer=new byte[1024];
    private int leng;
    private TCPCliente cliente;

    public TCPcontrolledcliente(String puertoCom, DatoTCP dato) throws PortInUseException, IOException, UnsupportedCommOperationException, NoSuchPortException {
     
        cliente = new TCPCliente(dato);
        idPuerto = CommPortIdentifier.getPortIdentifier(puertoCom);
        System.out.println("Puerto identifcado:" + puertoCom);
        if (idPuerto.isCurrentlyOwned()) {
            System.out.println("Puerto en uso...");
        } else {
            puertoSerie = (SerialPort) idPuerto.open("RxSerial", 1000);
            System.out.println("Puerto abierto");
            flujoEntrada = puertoSerie.getInputStream();
            System.out.println("Flujo de entyrada creado");
            puertoSerie.setSerialPortParams(9600, SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            System.out.println("Puerto configurado");
        
    }
    }
  public void run (){
      
        try {
            if ((leng = flujoEntrada.read(buffer)) > -1) {
                String datoRecibido = new String (buffer, 0,leng);
                if (datoRecibido=="ASwitch1"){
                InterfazCliente.jpSwitch1.setBackground(Color.green);
                cliente.txTCP(datoRecibido);
                }
                if (datoRecibido=="BSwitch1"){
                InterfazCliente.jpSwitch1.setBackground(Color.red);
                cliente.txTCP(datoRecibido);
                }
                if (datoRecibido=="ASwitch2"){
                InterfazCliente.jpSwitch1.setBackground(Color.green);
                cliente.txTCP(datoRecibido);
                }
                if (datoRecibido=="BSwitch2"){
                InterfazCliente.jpSwitch1.setBackground(Color.red);
                cliente.txTCP(datoRecibido);
                }
                        
                
                
            }     } catch (IOException ex) {
            Logger.getLogger(TCPcontrolledcliente.class.getName()).log(Level.SEVERE, null, ex);
        }
       
}
    
    
    
}
