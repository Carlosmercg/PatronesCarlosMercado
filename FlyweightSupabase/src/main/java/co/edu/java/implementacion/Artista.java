package co.edu.java.implementacion;

/**
 * Clase Flyweight que representa a un artista.
 * Un artista puede tener muchas canciones, por lo que su instancia se reutiliza.
 *
 */
public class Artista {
    private Long id;
    private String nombre;

    public Artista(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Artista{" + "id=" + id + ", nombre='" + nombre + "'}";
    }
}
