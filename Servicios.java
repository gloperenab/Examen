package com.practica.cajero;

public class Servicios {

    private String folio;
    private String montoAPagar;

    public Servicios(String folio, String montoAPagar) {
        this.folio = folio;
        this.montoAPagar = montoAPagar;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getMontoAPagar() {
        return montoAPagar;
    }

    public void setMontoAPagar(String montoAPagar) {
        this.montoAPagar = montoAPagar;
    }
}
