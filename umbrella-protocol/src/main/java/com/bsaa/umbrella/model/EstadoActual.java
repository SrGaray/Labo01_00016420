package com.bsaa.umbrella.model;

public enum EstadoActual {
    CONTENIDO("Contenido"),
    EN_LIBERTAD("En libertad"),
    ELIMINADO("Eliminado");
    
    private final String descripcion;
    
    EstadoActual(String descripcion) {
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
