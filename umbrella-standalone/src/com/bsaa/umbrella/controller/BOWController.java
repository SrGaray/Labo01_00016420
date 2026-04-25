package com.bsaa.umbrella.controller;

import com.bsaa.umbrella.model.*;
import com.bsaa.umbrella.service.BOWService;
import java.util.List;

/**
 * Controlador principal - versión standalone
 * En Spring, esto sería un @Component con inyección automática
 */
public class BOWController {
    
    private final BOWService bowService;
    
    // Constructor standalone (usa 'new' - no recomendado en Spring)
    public BOWController() {
        this.bowService = new BOWService(); // ¡Esto va en contra de DI!
    }
    
    // Constructor que acepta dependencia (sería usado por Spring)
    public BOWController(BOWService bowService) {
        this.bowService = bowService;
    }
    
    public void ejecutarProtocoloContencion() {
        System.out.println("==================================================");
        System.out.println("    PROTOCOLO DE CONTENCIÓN UMBRELLA - B.S.A.A.");
        System.out.println("==================================================\n");
        
        mostrarTodosLosEspecimenes();
        ejecutarFiltradoPorVirusBase();
        ejecutarFiltradoPorEstado();
        ejecutarReporteVirusActivos();
        
        System.out.println("==================================================");
        System.out.println("         PROTOCOLO DE CONTENCIÓN FINALIZADO");
        System.out.println("==================================================");
    }
    
    private void mostrarTodosLosEspecimenes() {
        System.out.println("=== REGISTRO COMPLETO DE ESPECÍMENES B.O.W. ===");
        List<BOW> todosLosEspecimenes = bowService.obtenerTodosLosEspecimenes();
        String reporte = bowService.generarReporteSTARS(todosLosEspecimenes);
        System.out.print(reporte);
        System.out.println();
    }
    
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
