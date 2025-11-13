package co.edu.java;

import co.edu.java.implementacion.FabricaArtistas;
import co.edu.java.implementacion.FabricaCanciones;
import co.edu.java.implementacion.ListaReproduccion;
import co.edu.java.implementacion.MemoryManager;

import java.util.Random;

public class Main {

    private static final String[] NombreCanciones = new String[100];
    private static final String[] NombresArtistas = new String[20];
    private static final String[] NombresListas = new String[500];

    public static void main(String[] args) {

        System.out.println(" Iniciando Flyweight + Supabase REST API...");

        FabricaCanciones.HabilitarFlyweight = true;

        InicializarArreglos();

        long inicio = System.currentTimeMillis();
        CrearListasDinamicas();
        long fin = System.currentTimeMillis();

        System.out.println("\n Tiempo total: " + ((fin - inicio) / 1000.0) + " segundos");
        System.out.println(" Total Listas generadas: " + MemoryManager.getTotalListasGeneradas());
        System.out.println(" Listas en memoria: " + MemoryManager.getCantidadListasEnMemoria());
        System.out.println(" Canciones únicas: " + FabricaCanciones.totalCanciones());
        System.out.println(" Artistas únicos: " + FabricaArtistas.totalArtistas());
    }

    private static void CrearListasDinamicas() {

        Random random = new Random();

        for (int c = 0; c < NombresListas.length; c++) {

            ListaReproduccion lista = new ListaReproduccion(NombresListas[c]);

            for (int i = 0; i < 5; i++) {
                int idx = random.nextInt(NombreCanciones.length);
                lista.addCancion(NombreCanciones[idx]);
            }

            // Simular uso realista (entre 0 y 10)
            lista.incrementarUso();
            lista.incrementarUso();
            if (random.nextBoolean()) lista.incrementarUso(); // aleatorio

            MemoryManager.agregarLista(lista);
        }
    }

    private static void InicializarArreglos() {

        Random random = new Random();

        for (int i = 0; i < NombresArtistas.length; i++) {
            NombresArtistas[i] = "Artist " + (i + 1);
        }

        for (int i = 0; i < NombreCanciones.length; i++) {
            NombreCanciones[i] = "Song " + (i + 1);

            int idxArtista = random.nextInt(NombresArtistas.length);
            FabricaCanciones.registrarArtistaCancion(NombreCanciones[i], NombresArtistas[idxArtista]);
        }

        for (int i = 0; i < NombresListas.length; i++) {
            NombresListas[i] = "Playlist " + (i + 1);
        }
    }
}
