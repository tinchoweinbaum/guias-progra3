import vista.*;
import controlador.*;
import modelo.*;

public static void main(String[] args){
    IVista vista = new Vista();
    Controlador controlador = new Controlador(vista);
}