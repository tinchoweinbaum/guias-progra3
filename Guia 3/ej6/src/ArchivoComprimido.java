import java.util.ArrayList;
import java.util.Date;

public class ArchivoComprimido extends Archivo{
    double tasaComp;
    ArrayList<ItemFS> items;

    public ArchivoComprimido(String nombre, Date fechaCreacion, double tasaComp, ArrayList<ItemFS> items) {
        double tamanoItems = 0; // Calculo el tamaño de los items y multiplica por tasa de compresion.
        for (ItemFS item : items)
            tamanoItems += item.getSize();
        tamanoItems *= tasaComp;

        super(nombre, ".tar", tamanoItems, fechaCreacion); // Llamo al constructor de Archivo.
        this.tasaComp = tasaComp;
        this.items = items;
    }

    @Override
    public String toString() {
        return String.format("[Comprimido] %s [Tasa: %.2f, Elementos: %d]",
                super.toString(), tasaComp, items.size());
    }
}
