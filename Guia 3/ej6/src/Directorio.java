import java.util.ArrayList;
import java.util.Date;

public class Directorio extends ItemFS {
    private ArrayList<ItemFS> items;

    public Directorio(String nombre, Date fechaCreacion){
        super(nombre, ".dir", fechaCreacion);
        this.items = new ArrayList<>();
    }

    public Directorio(String nombre){
        this(nombre, new Date());
    }

    public void agregarItem(ItemFS item){
        this.items.add(item);
    }

    @Override
    public double getSize() { // Recorre recursivamente la lista de items de un directorio
        double peso = 0;
        for (ItemFS item : items)
            peso += item.getSize();
        return peso;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Directorio] ").append(super.toString()).append(":\n");
        for (ItemFS item : items) {
            // Indenta el contenido para visualizar la jerarquía
            sb.append("   ├── ").append(item.toString().replace("\n", "\n   │   ")).append("\n");
        }
        return sb.toString();
    }
}
