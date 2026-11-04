import java.util.Date;

public abstract class ItemFS {
    private String nombre;
    private String extension;
    private final Date fechaCreacion;
    private Date fechaModificacion;

    public ItemFS(String nombre, String extension, Date fechaCreacion) {
        this.nombre = nombre;
        this.extension = extension;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaCreacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public abstract double getSize(); // Metodo abstracto getSize para llamar al getSize que corresponda.

    @Override
    public String toString() {
        return String.format("%s%s (%.2f KiB)",
                nombre,
                (extension != null && !extension.isEmpty()) ? extension : "",
                getSize());
    }
}
