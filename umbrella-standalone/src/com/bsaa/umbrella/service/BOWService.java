package com.bsaa.umbrella.service;

import com.bsaa.umbrella.model.*;
import com.bsaa.umbrella.repository.BOWRepository;
import java.util.List;

/**
 * Servicio que implementa la lógica de negocio
 * Versión standalone - en la versión Spring, esto sería un @Service
 * con inyección de dependencias
 */
public class BOWService {
    
    private final BOWRepository bowRepository;
    
    // En la versión standalone, usamos 'new' (no recomendado en Spring)
    public BOWService() {
        this.bowRepository = new BOWRepository(); // ¡Esto va en contra de DI!
    }
    
    // Constructor que acepta dependencia (sería usado por Spring)
    public BOWService(BOWRepository bowRepository) {
        this.bowRepository = bowRepository;
    }
    
    public List<BOW> obtenerTodosLosEspecimenes() {
        return bowRepository.findAll();
    }
    
    public List<BOW> filtrarPorVirusBase(VirusBase virusBase) {
        return bowRepository.findByVirusBase(virusBase);
    }
    
    public List<BOW> filtrarPorEstadoActual(EstadoActual estadoActual) {
        return bowRepository.findByEstadoActual(estadoActual);
    }
    
    public List<VirusBase> obtenerVirusActivosSinRepeticion() {
        return bowRepository.findDistinctVirusBaseByEstadoEnLibertad();
    }
    
    public String generarReporteSTARS(List<BOW> especimenes) {
        StringBuilder reporte = new StringBuilder();
        
        for (BOW bow : especimenes) {
            reporte.append(String.format(
                "[S.T.A.R.S-REPORT] Nombre: %s | Nivel de Peligro: %d | Punto Débil: %s%n",
                bow.getNombreEspecimen(),
                bow.getNivelPeligro(),
                bow.getPuntoDebil()
            ));
        }
        
        return reporte.toString();
    }
    
    public String generarReporteVirusActivos(List<VirusBase> virusActivos) {
        StringBuilder reporte = new StringBuilder();
        reporte.append("[S.T.A.R.S-REPORT] === VIRUS ACTIVOS (EN LIBERTAD) ===\n");
        
        for (VirusBase virus : virusActivos) {
            reporte.append(String.format("[S.T.A.R.S-REPORT] Virus Activo: %s%n", virus.getDescripcion()));
        }
        
        return reporte.toString();
    }
}
