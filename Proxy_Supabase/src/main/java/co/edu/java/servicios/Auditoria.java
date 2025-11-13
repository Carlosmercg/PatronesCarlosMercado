package co.edu.java.servicios;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Auditoria {
    public void AuditoriaServicioUsado(String user, String servicio){
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println(" AUDITORÍA | Usuario: " + user + " | Servicio: "
                + servicio + " | Fecha: " + f.format(new Date()));
    }
}
