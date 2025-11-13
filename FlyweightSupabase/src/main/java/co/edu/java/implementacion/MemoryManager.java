package co.edu.java.implementacion;

import co.edu.java.Repositorios.RepositorioListas;

import java.util.PriorityQueue;

public class MemoryManager {

    private static final int LIMITE_MEMORIA = 200; // antes 5000

    private static long totalListasGeneradas = 0;

    private static PriorityQueue<ListaReproduccion> listasEnMemoria =
            new PriorityQueue<>(); // ordenadas por uso ASC

    public static void agregarLista(ListaReproduccion lista) {

        totalListasGeneradas++;

        if (listasEnMemoria.size() < LIMITE_MEMORIA) {
            listasEnMemoria.add(lista);
            System.out.println("[MEMORIA] Guardada '" + lista.getNombre() + "' (uso=" + lista.getUso() + ")");
            return;
        }

        ListaReproduccion menosUsada = listasEnMemoria.peek();

        if (lista.getUso() > menosUsada.getUso()) {

            listasEnMemoria.poll();
            System.out.println("[SUPABASE] Expulsando '" + menosUsada.getNombre() + "' (uso=" + menosUsada.getUso() + ")");
            RepositorioListas.guardarLista(menosUsada);

            listasEnMemoria.add(lista);
            System.out.println("[MEMORIA] Guardada '" + lista.getNombre() + "' (uso=" + lista.getUso() + ")");
        }
        else {
            System.out.println("[SUPABASE] Enviando '" + lista.getNombre() + "' (uso=" + lista.getUso() + ")");
            RepositorioListas.guardarLista(lista);
        }
    }

    public static int getCantidadListasEnMemoria() {
        return listasEnMemoria.size();
    }

    public static long getTotalListasGeneradas() {
        return totalListasGeneradas;
    }
}
