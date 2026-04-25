package com.bsaa.umbrella.controller;

import com.bsaa.umbrella.model.BOW;
import com.bsaa.umbrella.model.EstadoActual;
import com.bsaa.umbrella.model.VirusBase;
import com.bsaa.umbrella.service.BOWService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Controlador princiapl
 */
@Component
public class BOWController {
    
    private final BOWService bowService;
    
    /**
     * Constructor con inyección de dependencias
     */
    @Autowired
    public BOWController(BOWService bowService) {
        this.bowService = bowService;
    }
    
    /**
     * Ejecuta todas las operaciones del sistema y muestra reportes en consola
     */
    public void ejecutarProtocoloContencion() {
        System.out.println("==================================================");
        System.out.println("    PROTOCOLO DE CONTENCIÓN DE UMBRELLA ");
        System.out.println("==================================================\n");
        
        // 1. Mostrar todos los especímenes registrados
        mostrarTodosLosEspecimenes();
        
        // 2. Filtrado por virus base
        ejecutarFiltradoPorVirusBase();
        
        // 3. Filtrado por estado actual
        ejecutarFiltradoPorEstado();
        
        // 4. Virus activos sin repetición
        ejecutarReporteVirusActivos();
        
        System.out.println("==================================================");
        System.out.println("         EJECUCIÓN DE PROTOCOLO FINALIZADO");
        System.out.println("==================================================");
    }
    
    /**
     * VISUALIZACIÓN DE REGISTROS
     */
    private void mostrarTodosLosEspecimenes() {
        System.out.println("=== REGISTRO COMPLETO DE ESPECÍMENES B.O.W. ===");
        List<BOW> todosLosEspecimenes = bowService.obtenerTodosLosEspecimenes();
        String reporte = bowService.generarReporteSTARS(todosLosEspecimenes);
        System.out.print(reporte);
        System.out.println();
    }
    
    /**
     *  Ejecución de filtros
     */
    private void ejecutarFiltradoPorVirusBase() {
        System.out.println("=== FILTRADO POR VIRUS BASE ===");
        
        for (VirusBase virus : VirusBase.values()) {
            System.out.printf("--- Especímenes infectados con %s ---%n", virus.getDescripcion());
            List<BOW> especimenesPorVirus = bowService.filtrarPorVirusBase(virus);
            
            if (especimenesPorVirus.isEmpty()) {
                System.out.printf("[S.T.A.R.S-REPORT] No se encontraron especímenes con %s%n", virus.getDescripcion());
            } else {
                String reporte = bowService.generarReporteSTARS(especimenesPorVirus);
                System.out.print(reporte);
            }
            System.out.println();
        }
    }
    
    /**
     * Ejecuta filtrado por cada estado posible
     */
    private void ejecutarFiltradoPorEstado() {
        System.out.println("=== FILTRADO POR ESTADO ACTUAL ===");
        
        for (EstadoActual estado : EstadoActual.values()) {
            System.out.printf("--- Especímenes en estado: %s ---%n", estado.getDescripcion());
            List<BOW> especimenesPorEstado = bowService.filtrarPorEstadoActual(estado);
            
            if (especimenesPorEstado.isEmpty()) {
                System.out.printf("[S.T.A.R.S-REPORT] No se encontraron especímenes en estado %s%n", estado.getDescripcion());
            } else {
                String reporte = bowService.generarReporteSTARS(especimenesPorEstado);
                System.out.print(reporte);
            }
            System.out.println();
        }
    }
    
    /**
     * Ejecución del reporte sin repetición
     */
    private void ejecutarReporteVirusActivos() {
        System.out.println("=== ANÁLISIS DE VIRUS ACTIVOS (DISTINCT) ===");
        List<VirusBase> virusActivos = bowService.obtenerVirusActivosSinRepeticion();
        
        if (virusActivos.isEmpty()) {
            System.out.println("[S.T.A.R.S-REPORT] No se detectaron virus activos en especímenes en libertad.");
        } else {
            String reporteVirusActivos = bowService.generarReporteVirusActivos(virusActivos);
            System.out.print(reporteVirusActivos);
            
            System.out.printf("[S.T.A.R.S-REPORT] ALERTA: %d tipo(s) de virus detectados en especímenes en libertad.%n", 
                            virusActivos.size());
        }
        System.out.println();
    }
}
