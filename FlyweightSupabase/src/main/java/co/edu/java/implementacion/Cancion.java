package co.edu.java.implementacion;

public class Cancion {

    private Long id;
    private String nombreCancion;
    private Artista artista;
    private byte[] datosCancion;   // Solo se carga si es necesario en memoria real

    // Constructor para canciones nuevas (con datos pesados)
    public Cancion(Long id, String nombreCancion, Artista artista) {
        this.id = id;
        this.nombreCancion = nombreCancion;
        this.artista = artista;

        // Solo las canciones creadas por el programa tienen este peso
        this.datosCancion = new byte[1000000];
    }

    // Constructor para canciones cargadas desde BD (sin peso)
    public Cancion(Long id, String nombreCancion, Artista artista, boolean cargarDatosPesados) {
        this.id = id;
        this.nombreCancion = nombreCancion;
        this.artista = artista;

        if (cargarDatosPesados) {
            this.datosCancion = new byte[1000000];
        }
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombreCancion;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "Cancion{" +
                "id=" + id +
                ", Tema='" + nombreCancion + '\'' +
                ", Artista=" + artista.getNombre() +
                '}';
    }
}
