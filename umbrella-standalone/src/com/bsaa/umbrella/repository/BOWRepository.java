package com.bsaa.umbrella.repository;

import com.bsaa.umbrella.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Repositorio que gestiona el almacenamiento y recuperación de especímenes B.O.W.
 * Versión standalone sin Spring - demuestra el patrón sin IoC
 */
public class BOWRepository {
    
    private final List<BOW> especimenes;
    
    public BOWRepository() {
        this.especimenes = inicializarEspecimenes();
    }
    
    public List<BOW> findAll() {
        return new ArrayList<>(especimenes);
    }
    
    public List<BOW> findByVirusBase(VirusBase virusBase) {
        return especimenes.stream()
                .filter(bow -> bow.getVirusBase() == virusBase)
                .collect(Collectors.toList());
    }
    
    public List<BOW> findByEstadoActual(EstadoActual estadoActual) {
        return especimenes.stream()
                .filter(bow -> bow.getEstadoActual() == estadoActual)
                .collect(Collectors.toList());
    }
    
    public List<VirusBase> findDistinctVirusBaseByEstadoEnLibertad() {
        return especimenes.stream()
                .filter(bow -> bow.getEstadoActual() == EstadoActual.EN_LIBERTAD)
                .map(BOW::getVirusBase)
                .distinct()
                .collect(Collectors.toList());
    }
    
    private List<BOW> inicializarEspecimenes() {
        List<BOW> lista = new ArrayList<>();
        
        // Especímenes del T-Virus
        lista.add(new BOW("Licker", VirusBase.T_VIRUS, 4, "Cabeza", EstadoActual.EN_LIBERTAD, UbicacionReportada.COMISARIA, "Laboratorio de Microbiología"));
        lista.add(new BOW("Hunter", VirusBase.T_VIRUS, 3, "Cuello", EstadoActual.CONTENIDO, UbicacionReportada.LABORATORIO, "Laboratorio de Genética"));
        lista.add(new BOW("Tyrant", VirusBase.T_VIRUS, 5, "Corazón expuesto", EstadoActual.EN_LIBERTAD, UbicacionReportada.MANSION, "Laboratorio de Biotecnología"));
        lista.add(new BOW("Zombie", VirusBase.T_VIRUS, 2, "Cabeza", EstadoActual.ELIMINADO, UbicacionReportada.PUEBLO, "Laboratorio de Virología"));
        
        // Especímenes del G-Virus
        lista.add(new BOW("G-Mutante Etapa 1", VirusBase.G_VIRUS, 4, "Ojo en el hombro", EstadoActual.EN_LIBERTAD, UbicacionReportada.LABORATORIO, "Laboratorio de Bioquímica"));
        lista.add(new BOW("G-Mutante Etapa 5", VirusBase.G_VIRUS, 5, "Núcleo central", EstadoActual.ELIMINADO, UbicacionReportada.LABORATORIO, "Laboratorio de Genética Molecular"));
        
        // Especímenes de Las Plagas
        lista.add(new BOW("Ganado", VirusBase.LAS_PLAGAS, 2, "Cabeza", EstadoActual.CONTENIDO, UbicacionReportada.PUEBLO, "Laboratorio de Parasitología"));
        lista.add(new BOW("El Gigante", VirusBase.LAS_PLAGAS, 4, "Espalda", EstadoActual.EN_LIBERTAD, UbicacionReportada.PUEBLO, "Laboratorio de Fisiología"));
        lista.add(new BOW("Regenerador", VirusBase.LAS_PLAGAS, 3, "Parásitos internos", EstadoActual.ELIMINADO, UbicacionReportada.LABORATORIO, "Laboratorio de Anatomía"));
        
        // Especímenes del Cadou
        lista.add(new BOW("Lycanthrope", VirusBase.CADOU, 3, "Núcleo Cadou", EstadoActual.EN_LIBERTAD, UbicacionReportada.PUEBLO, "Laboratorio de Bioingeniería"));
        lista.add(new BOW("Varcolac Alfa", VirusBase.CADOU, 4, "Cristales expuestos", EstadoActual.CONTENIDO, UbicacionReportada.MANSION, "Laboratorio de Cristalografía"));
        lista.add(new BOW("Soldado Samca", VirusBase.CADOU, 3, "Cabeza mecánica", EstadoActual.ELIMINADO, UbicacionReportada.LABORATORIO, "Laboratorio de Robótica"));
        
        return lista;
    }
}
