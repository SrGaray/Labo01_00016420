package com.bsaa.umbrella.service;

import com.bsaa.umbrella.model.BOW;
import com.bsaa.umbrella.model.EstadoActual;
import com.bsaa.umbrella.model.VirusBase;
import com.bsaa.umbrella.repository.BOWRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio que implementa la lógica de negocio
 *
 */
@Service
public class BOWService {
    
    private final BOWRepository bowRepository;
    
    /**
     * Constructor con inyección de dependencias
     */
    @Autowired
    public BOWService(BOWRepository bowRepository) {
        this.bowRepository = bowRepository;
    }
    
    /**
     * Obtiene todos los datos registrados
     */
    public List<BOW> obtenerTodosLosEspecimenes() {
        return bowRepository.findAll();
    }
    
    /**
     * Filtra especímenes por virus base
     */
    public List<BOW> filtrarPorVirusBase(VirusBase virusBase) {
        return bowRepository.findByVirusBase(virusBase);
    }
    
    /**
     * Filtra especímenes por estado actual
     */
    public List<BOW> filtrarPorEstadoActual(EstadoActual estadoActual) {
        return bowRepository.findByEstadoActual(estadoActual);
    }
    
    /**
     * Obtiene virus activos sin repetición
     * Devuelve una lista única de todos los virus base que tienen
     * al menos un espécimen con estado "En libertad"
     */
    public List<VirusBase> obtenerVirusActivosSinRepeticion() {
        return bowRepository.findDistinctVirusBaseByEstadoEnLibertad();
    }
    
    /**
     * Genera reporte formateado para consola con tag S.T.A.R.S
     */
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
    
    /**
     * Genera reporte de virus activos
     */
    public String generarReporteVirusActivos(List<VirusBase> virusActivos) {
        StringBuilder reporte = new StringBuilder();
        reporte.append("[S.T.A.R.S-REPORT] === VIRUS ACTIVOS (EN LIBERTAD) ===\n");
        
        for (VirusBase virus : virusActivos) {
            reporte.append(String.format("[S.T.A.R.S-REPORT] Virus Activo: %s%n", virus.getDescripcion()));
        }
        
        return reporte.toString();
    }
}
