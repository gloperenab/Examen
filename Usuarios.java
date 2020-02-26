package com.practica.cajero;

public class Usuarios {

    private String numeroTarjeta;
    private String nip;
    private String saldo;
    private String tipoTarjeta;

    public Usuarios(String numeroTarjeta, String nip, String saldo, String tipoTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
        this.nip = nip;
        this.saldo = saldo;
        this.tipoTarjeta = tipoTarjeta;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }
}
