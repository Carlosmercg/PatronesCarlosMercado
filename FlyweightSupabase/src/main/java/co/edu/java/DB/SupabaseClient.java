package co.edu.java.DB;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class SupabaseClient {

    private static String SUPABASE_URL;
    private static String API_KEY;

    static {
        try (InputStream input = SupabaseClient.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {

            Properties props = new Properties();
            props.load(input);

            SUPABASE_URL = props.getProperty("SUPABASE_URL");
            API_KEY = props.getProperty("SUPABASE_API_KEY");

        } catch (Exception e) {
            throw new RuntimeException("Error cargando config.properties", e);
        }
    }

    public static String insert(String table, String jsonBody) {
        try {
            URL url = new URL(SUPABASE_URL + "/rest/v1/" + table);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("POST");
            con.setRequestProperty("apikey", API_KEY);
            con.setRequestProperty("Authorization", "Bearer " + API_KEY);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("Prefer", "return=representation");
            con.setDoOutput(true);

            try (OutputStream os = con.getOutputStream()) {
                os.write(jsonBody.getBytes(StandardCharsets.UTF_8));
            }

            int status = con.getResponseCode();
            InputStream input = status < 400 ? con.getInputStream() : con.getErrorStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                response.append(line);
            }

            con.disconnect();
            return response.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "{\"error\": \"No se pudo insertar\"}";
        }
    }
}
