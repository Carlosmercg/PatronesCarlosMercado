package co.edu.java.implementacion;

import java.util.HashMap;
import java.util.Map;

/**
 * Fábrica Flyweight para manejar instancias únicas de Artistas.
 *
 * @author Fabrizio
 */
public class FabricaArtistas {
    private static final Map<String, Artista> ARTISTAS = new HashMap<>();
    private static Long secuencia = 0L;

    public static Artista obtenerArtista(String nombre) {
        if (ARTISTAS.containsKey(nombre)) {
            return ARTISTAS.get(nombre);
        } else {
            Artista nuevo = new Artista(++secuencia, nombre);
            ARTISTAS.put(nombre, nuevo);
            return nuevo;
        }
    }

    public static int totalArtistas() {
        return ARTISTAS.size();
    }
}
