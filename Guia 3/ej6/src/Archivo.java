import java.util.Date;

public class Archivo extends ItemFS{
    private double size; // tamaño en KiB

    public Archivo(String nombre, String extension, double size, Date fechaCreacion) {
        super(nombre, extension, fechaCreacion);
        this.size = size;
    }

    public Archivo(String nombre, String extension, double size){
        this(nombre, extension, size, new Date());
    }

    public double getSize(){
        return this.size;
    }

    public void setSize(double size){
        this.size = size;
    }

    @Override
    public String toString() {
        return "[Archivo] " + super.toString();
    }
}