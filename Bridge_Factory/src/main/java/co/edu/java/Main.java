package co.edu.java;

import co.edu.java.encriptacion.InterfaceEncriptar;
import co.edu.java.implementacion.FactoryEncriptador;
import co.edu.java.implementacion.InterfaceMensajeEncriptacion;
import co.edu.java.implementacion.PuenteMensajeEncriptacion;

public class Main {
    public static void main(String[] args) {

        try {
            InterfaceEncriptar encriptador = FactoryEncriptador.crearEncriptador();
            InterfaceMensajeEncriptacion puente =
                    new PuenteMensajeEncriptacion(encriptador);

            final String message = "<Curso><Nombre>Patrones de Diseño de Software</Nombre></Curso>";

            String key;

            // Clave automática según algoritmo
            if (encriptador.getClass().getSimpleName().contains("AES")) {
                key = "HG58YZ3CR9123456";
            }
            else if (encriptador.getClass().getSimpleName().contains("DES")) {
                key = "12345678";
            }
            else if (encriptador.getClass().getSimpleName().contains("Cesar")) {
                key = "claveCesar";
            }
            else {
                key = null;
            }

            System.out.println(" Procesando mensaje usando: " +
                    encriptador.getClass().getSimpleName() + "\n");

            String resultado = puente.EncryptarMensaje(message, key);

            System.out.println(" Mensaje original  > " + message);
            System.out.println(" Mensaje procesado > " + resultado);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
