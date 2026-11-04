import java.util.ArrayList; // import de la clase de array list

public class Estacion {
    private static Estacion _instancia = null;

    private String nombre;
    private ArrayList<Surtidor> surtidores;

    private Estacion(String nombre){ // Se puede tambien usar un constructor que espere una cantidad indeterminada de argumentos de tipo surtidor.
        this.surtidores = new ArrayList<>();
        this.nombre = nombre;
    }

    public static Estacion getInstancia(String nombre){
        if (Estacion._instancia != null)
            return Estacion._instancia;
        else
            return new Estacion(nombre);
    }
}
