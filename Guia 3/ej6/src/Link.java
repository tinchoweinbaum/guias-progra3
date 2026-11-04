import java.util.Date;

public class Link extends Archivo{
    private ItemFS ref; // Referencia un directorio o un archivo

    public Link(String nombre, ItemFS ref, Date fechaCreacion){
        super(nombre, ".link", 1, fechaCreacion);
    }

    public Link(String nombre, ItemFS ref){
        this(nombre, ref, new Date());
    }

    public ItemFS getRef(){
        return this.ref;
    }

    public void setRef(ItemFS item){
        this.ref = item;
    }

    @Override
    public String toString() {
        String apuntaA = (ref != null) ? ref.getNombre() + ref.getExtension() : "null";
        return "[Link] " + super.toString() + " -> " + apuntaA;
    }
}
