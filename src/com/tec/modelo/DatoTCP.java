package com.tec.modelo;
public class DatoTCP {
        private String mensajeOrigen;
        private String ipOrigen;
        private String hostServidor;
        private int puertoServidor;

    public DatoTCP(String hostServidor, int puertoServidor) {
        this.hostServidor = hostServidor;
        this.puertoServidor = puertoServidor;
    }
    public String getHostServidor() {
        return hostServidor;
    }
    public void setHostServidor(String hostServidor) {
        this.hostServidor = hostServidor;
    }
    public int getPuertoServidor() {
        return puertoServidor;
    }
    public void setPuertoServidor(int puertoServidor) {
        this.puertoServidor = puertoServidor;
    }
    public DatoTCP(String mensajeOrigen, String ipOrigen) {
        this.mensajeOrigen = mensajeOrigen;
        this.ipOrigen = ipOrigen;
    }
    public String getMensajeOrigen() {
        return mensajeOrigen;
    }
    public void setMensajeOrigen(String mensajeOrigen) {
        this.mensajeOrigen = mensajeOrigen;
    }
    public String getIpOrigen() {
        return ipOrigen;
    }
    public void setIpOrigen(String ipOrigen) {
        this.ipOrigen = ipOrigen;
    }   
}
