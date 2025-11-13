package co.edu.java.implementacion;

public class ProxyNoAuditado extends Proxybase {

    @Override
    protected void ProcesarAuditoria(String usuario, String servicio) {
        // No audita nada
    }
}