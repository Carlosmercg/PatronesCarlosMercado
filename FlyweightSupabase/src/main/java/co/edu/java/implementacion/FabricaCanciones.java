package co.edu.java.implementacion;

import java.util.HashMap;
import java.util.Map;

public class FabricaCanciones {

    public static boolean HabilitarFlyweight = true;

    private static final Map<String, Cancion> PLAY_CANCION = new HashMap<>();

    private static final Map<String, String> MAPA_CANCION_ARTISTA = new HashMap<>();

    private static Long Secuencia = 0L;


    public static void registrarArtistaCancion(String nombreCancion, String nombreArtista) {
        MAPA_CANCION_ARTISTA.put(nombreCancion, nombreArtista);
    }

    public static Cancion CrearItem(String nombreTema) {
        if (HabilitarFlyweight && PLAY_CANCION.containsKey(nombreTema)) {
            return PLAY_CANCION.get(nombreTema);
        } else {
            // Buscar el artista asociado a esa canción
            String nombreArtista = MAPA_CANCION_ARTISTA.get(nombreTema);
            if (nombreArtista == null) {
                nombreArtista = "Artista Desconocido";
            }
            Artista artista = FabricaArtistas.obtenerArtista(nombreArtista);
            Cancion playItem = new Cancion(++Secuencia, nombreTema, artista);
            PLAY_CANCION.put(nombreTema, playItem);
            return playItem;
        }
    }

    public static int totalCanciones() {
        return PLAY_CANCION.size();
    }
}
