package co.edu.java.implementacion;

import co.edu.java.servicios.Seguridad;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public abstract class Proxybase implements InterfaceProcesos {

    protected static final HashMap<String, Integer> contadorEjecuciones = new HashMap<>();

    @Override
    public void EjecutarProcesos(int IdProceso, String Usuario, String Password) throws Exception {

        Seguridad security = new Seguridad();

        // Autenticar con Supabase
        if (!security.Autorizacion(Usuario, Password)) {
            throw new Exception("Usuario no autorizado");
        }

        // Limite diario
        String fecha = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        String key = Usuario + "_" + fecha + "_P" + IdProceso;

        int count = contadorEjecuciones.getOrDefault(key, 0);
        if (count >= 3) {
            throw new Exception("El usuario superó el máximo diario de uso.");
        }
        contadorEjecuciones.put(key, count + 1);

        // Proceso real
        ProcesoDefecto proceso = new ProcesoDefecto();
        proceso.EjecutarProcesos(IdProceso, Usuario, Password);

        // Auditoría (depende del proxy)
        ProcesarAuditoria(Usuario, ProcesoDefecto.class.getName());
    }

    protected abstract void ProcesarAuditoria(String usuario, String servicio);
}

