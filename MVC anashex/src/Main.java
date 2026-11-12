void main(){
    IVista vista = new Vista();
    Modelo modelo = new Modelo();
    Controlador controlador = new Controlador(vista, modelo);
}