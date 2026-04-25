package com.bsaa.umbrella;

import com.bsaa.umbrella.controller.BOWController;

/**
 * Aplicación principal - Versión Standalone
 * Esta versión NO usa Spring Framework para demostrar el concepto básico
 * 
 * NOTA IMPORTANTE: Esta implementación usa 'new' para crear dependencias,
 * lo cual va en contra de los principios de Spring IoC/DI.
 * 
 * En la versión Spring Boot completa, todas las dependencias son
 * inyectadas automáticamente por el contenedor de Spring.
 */
public class UmbrellaProtocolStandalone {

    public static void main(String[] args) {
        System.out.println("Iniciando Sistema B.S.A.A. - Protocolo de Contención Umbrella...\n");
        System.out.println("VERSIÓN STANDALONE (SIN SPRING FRAMEWORK)");
        System.out.println("==========================================\n");
        
        // ANTI-PATRÓN: Creación manual de dependencias con 'new'
        // En Spring Boot esto se hace automáticamente con IoC/DI
        BOWController controller = new BOWController();
        
        // Ejecutar el protocolo
        controller.ejecutarProtocoloContencion();
        
        System.out.println("\n==========================================");
        System.out.println("NOTA: En la versión Spring Boot completa:");
        System.out.println("- No se usa 'new' para crear dependencias");
        System.out.println("- Spring IoC maneja todas las instancias");
        System.out.println("- @Autowired inyecta dependencias automáticamente");
        System.out.println("- Cada clase es un Bean administrado (@Service, @Repository, etc.)");
        System.out.println("==========================================");
    }
}
