package com.bsaa.umbrella.model;

public enum UbicacionReportada {
    LABORATORIO("Laboratorio"),
    COMISARIA("Comisaría"),
    MANSION("Mansión"),
    PUEBLO("Pueblo");
    
    private final String descripcion;
    
    UbicacionReportada(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    @Override
    public String toString() {
        return descripcion;
    }
}
