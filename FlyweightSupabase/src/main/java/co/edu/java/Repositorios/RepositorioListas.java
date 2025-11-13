package co.edu.java.Repositorios;

import co.edu.java.DB.SupabaseClient;
import co.edu.java.implementacion.Cancion;
import co.edu.java.implementacion.ListaReproduccion;
import org.json.JSONArray;
import org.json.JSONObject;

public class RepositorioListas {

    public static void guardarLista(ListaReproduccion lista) {

        try {
            // 1. Guardar la lista en la tabla "listas"
            JSONObject listaJson = new JSONObject();
            listaJson.put("nombre", lista.getNombre());
            listaJson.put("uso", lista.getUso());

            String listaResponse = SupabaseClient.insert("listas?on_conflict=nombre", listaJson.toString());
            JSONArray arrLista = new JSONArray(listaResponse);
            long listaId = arrLista.getJSONObject(0).getLong("id");

            // 2. Guardar canciones relacionadas
            JSONArray jsonArray = new JSONArray();

            for (Cancion c : lista.getCanciones()) {
                JSONObject obj = new JSONObject();
                obj.put("lista_id", listaId);
                obj.put("cancion_id", c.getId());
                jsonArray.put(obj);
            }

            if (jsonArray.length() > 0) {
                SupabaseClient.insert("lista_canciones", jsonArray.toString());
            }

        } catch (Exception e) {
            System.out.println("Error guardando lista: " + lista.getNombre());
        }
    }
}
