package co.edu.java.implementacion;

import co.edu.java.servicios.Auditoria;

public class ProxyAuditado extends Proxybase {

    @Override
    protected void ProcesarAuditoria(String usuario, String servicio) {
        Auditoria audit = new Auditoria();
        audit.AuditoriaServicioUsado(usuario, servicio);
    }
}