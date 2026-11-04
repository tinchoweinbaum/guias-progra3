import vista.Ventana;
import modelo.Contador;
import controlador.Controlador;

public static void main(String[] args){
    Contador modelo = new Contador();
    Ventana vista = new Ventana();
    Controlador controlador = new Controlador(vista, modelo);
}