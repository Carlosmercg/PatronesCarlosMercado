package co.edu.java.implementacion;

public class FabricaServicios {

    public static InterfaceProcesos CrearEjecucionProceso(String tipo) {

        if (tipo.equalsIgnoreCase("auditado")) {
            return new ProxyAuditado();
        }

        if (tipo.equalsIgnoreCase("noauditado")) {
            return new ProxyNoAuditado();
        }

        throw new RuntimeException("Tipo de proxy no válido");
    }
}
