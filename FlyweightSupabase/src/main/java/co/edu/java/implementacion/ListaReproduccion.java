package co.edu.java.implementacion;

import java.util.ArrayList;
import java.util.List;

public class ListaReproduccion implements Comparable<ListaReproduccion> {

    private String nombre;
    private List<Cancion> canciones = new ArrayList<>();
    private int uso = 0;

    public ListaReproduccion(String nombre) {
        this.nombre = nombre;
    }

    public void addCancion(String nombreCancion) {
        canciones.add(FabricaCanciones.CrearItem(nombreCancion));
    }

    public void incrementarUso() {
        uso++;
    }

    public int getUso() {
        return uso;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    @Override
    public int compareTo(ListaReproduccion o) {
        return Integer.compare(this.uso, o.uso);
    }
}
