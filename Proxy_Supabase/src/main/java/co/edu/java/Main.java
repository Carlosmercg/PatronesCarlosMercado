package co.edu.java;

import co.edu.java.implementacion.FabricaServicios;
import co.edu.java.implementacion.InterfaceProcesos;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=======================================");
        System.out.println("      SISTEMA DE EJECUCIÓN DE PROCESOS");
        System.out.println("=======================================\n");

        System.out.print("Ingrese usuario: ");
        String usuario = sc.nextLine();

        System.out.print("Ingrese contraseña: ");
        String password = sc.nextLine();

        System.out.println("\nSeleccione el tipo de Proxy:");
        System.out.println("1. Proxy Auditador");
        System.out.println("2. Proxy No Auditador");

        System.out.print("➡ Opción: ");
        int opcion = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        String tipoProxy;

        if (opcion == 1) {
            tipoProxy = "auditado";
        } else if (opcion == 2) {
            tipoProxy = "noauditado";
        } else {
            System.out.println("Opción inválida. Saliendo...");
            return;
        }

        // Crear proxy desde la Factory
        InterfaceProcesos proxy = FabricaServicios.CrearEjecucionProceso(tipoProxy);

        System.out.println("\n✔ Proxy seleccionado: " + tipoProxy.toUpperCase());

        int proceso = 1;

        System.out.println("\nIniciando ejecución del proceso…\n");

        // Intentar ejecutar varias veces (para probar el límite)
        for (int i = 1; i <= 4; i++) {
            System.out.println("Intento #" + i);

            try {
                proxy.EjecutarProcesos(proceso, usuario, password);
            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }

            System.out.println("------------------------------------");
        }

        System.out.println("\nProceso terminado.");
    }
}
