package co.edu.java.servicios;

import okhttp3.*;
import org.json.JSONArray;

public class Seguridad {

    private final OkHttpClient client = new OkHttpClient();

    private final String SUPABASE_URL = ConfigReader.get("supabase.url");
    private final String API_KEY = ConfigReader.get("supabase.api_key");
    private final String TABLE = ConfigReader.get("supabase.table_usuarios");

    public boolean Autorizacion(String user, String password) throws Exception {

        String url = SUPABASE_URL + "/rest/v1/" + TABLE +
                "?username=eq." + user +
                "&password=eq." + password;

        Request request = new Request.Builder()
                .url(url)
                .addHeader("apikey", API_KEY)
                .addHeader("Authorization", "Bearer " + API_KEY)
                .addHeader("Content-Type", "application/json")
                .addHeader("Prefer", "return=representation")
                .get()
                .build();

        Response response = client.newCall(request).execute();
        String json = response.body().string();

        JSONArray arr = new JSONArray(json);

        if (arr.length() == 1) {
            System.out.println("✔ Autenticado: " + user);
            return true;
        }

        System.out.println("No autorizado: " + user);
        return false;
    }
}

