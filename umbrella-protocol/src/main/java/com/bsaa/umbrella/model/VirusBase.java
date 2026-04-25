package com.bsaa.umbrella.model;

/**
 * Enumeración que representa los diferentes tipos de virus base
 * identificados en especímenes B.O.W.
 */
public enum VirusBase {
    T_VIRUS("T-Virus"),
    G_VIRUS("G-Virus"),
    LAS_PLAGAS("Las Plagas"),
    CADOU("Cadou");
    
    private final String descripcion;
    
    VirusBase(String descripcion) {
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
