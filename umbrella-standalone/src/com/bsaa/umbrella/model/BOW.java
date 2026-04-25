package com.bsaa.umbrella.model;

import java.util.Objects;

/**
 * Modelo que representa una Amenaza Biológica (B.O.W.)
 * registrada en el sistema de clasificación de la B.S.A.A.
 */
public class BOW {
    
    private String nombreEspecimen;
    private VirusBase virusBase;
    private int nivelPeligro;
    private String puntoDebil;
    private EstadoActual estadoActual;
    private UbicacionReportada ultimaUbicacionReportada;
    private String laboratorioUniversidad;
    
    // Constructor vacío
    public BOW() {}
    
    // Constructor completo
    public BOW(String nombreEspecimen, VirusBase virusBase, int nivelPeligro, 
               String puntoDebil, EstadoActual estadoActual, 
               UbicacionReportada ultimaUbicacionReportada, String laboratorioUniversidad) {
        this.nombreEspecimen = nombreEspecimen;
        this.virusBase = virusBase;
        this.nivelPeligro = nivelPeligro;
        this.puntoDebil = puntoDebil;
        this.estadoActual = estadoActual;
        this.ultimaUbicacionReportada = ultimaUbicacionReportada;
        this.laboratorioUniversidad = laboratorioUniversidad;
    }
    
    // Getters y Setters
    public String getNombreEspecimen() { return nombreEspecimen; }
    public void setNombreEspecimen(String nombreEspecimen) { this.nombreEspecimen = nombreEspecimen; }
    
    public VirusBase getVirusBase() { return virusBase; }
    public void setVirusBase(VirusBase virusBase) { this.virusBase = virusBase; }
    
    public int getNivelPeligro() { return nivelPeligro; }
    public void setNivelPeligro(int nivelPeligro) { this.nivelPeligro = nivelPeligro; }
    
    public String getPuntoDebil() { return puntoDebil; }
    public void setPuntoDebil(String puntoDebil) { this.puntoDebil = puntoDebil; }
    
    public EstadoActual getEstadoActual() { return estadoActual; }
    public void setEstadoActual(EstadoActual estadoActual) { this.estadoActual = estadoActual; }
    
    public UbicacionReportada getUltimaUbicacionReportada() { return ultimaUbicacionReportada; }
    public void setUltimaUbicacionReportada(UbicacionReportada ultimaUbicacionReportada) { this.ultimaUbicacionReportada = ultimaUbicacionReportada; }
    
    public String getLaboratorioUniversidad() { return laboratorioUniversidad; }
    public void setLaboratorioUniversidad(String laboratorioUniversidad) { this.laboratorioUniversidad = laboratorioUniversidad; }
    
    @Override
    public String toString() {
        return "BOW{" +
               "nombreEspecimen='" + nombreEspecimen + '\'' +
               ", virusBase=" + virusBase +
               ", nivelPeligro=" + nivelPeligro +
               ", puntoDebil='" + puntoDebil + '\'' +
               ", estadoActual=" + estadoActual +
               ", ultimaUbicacionReportada=" + ultimaUbicacionReportada +
               ", laboratorioUniversidad='" + laboratorioUniversidad + '\'' +
               '}';
    }
}
