package co.edu.java.implementacion;

import co.edu.java.encriptacion.InterfaceEncriptar;

import java.io.FileInputStream;
import java.util.Properties;

public class FactoryEncriptador {

    private static final String CONFIG_FILE = "src/config.properties";

    public static InterfaceEncriptar crearEncriptador() {
        try {
            Properties props = new Properties();
            props.load(new FileInputStream(CONFIG_FILE));

            // Leer nombre de la clase desde config
            String clase = props.getProperty("encriptacion");
            String paquete = "co.edu.java.encriptacion." + clase;

            System.out.println(" Leyendo archivo de configuración...");
            System.out.println(" Clase seleccionada para encriptación: " + clase);

            // Crear la clase dinámicamente
            Class<?> clazz = Class.forName(paquete);
            InterfaceEncriptar instancia = (InterfaceEncriptar) clazz.getDeclaredConstructor().newInstance();

            System.out.println(" Encriptador creado correctamente: " + instancia.getClass().getSimpleName());
            System.out.println("----------------------------------------------------");

            return instancia;

        } catch (Exception e) {
            throw new RuntimeException(" Error creando encriptador desde Factory", e);
        }
    }
}
