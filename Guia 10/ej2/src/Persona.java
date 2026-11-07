public class Persona implements Runnable{
    private String nombre;
    private int orden;
    private final int cantVueltas;
    private Empleado empleado;


    public Persona(String nombre, int orden, int cantVueltas, Empleado empleado) {
        this.nombre = nombre;
        this.orden = orden;
        this.cantVueltas = cantVueltas;
        this.empleado = empleado;
    }

    @Override
    public void run(){
        for (int i = 0; i < cantVueltas; i++) {
            this.empleado.pedirAtencion(this);
            System.out.println(this + " está siendo atendido");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Error al atender a " + this);
            }
            this.empleado.liberarEmpleado(this);
        }
    }

    public int getOrden() {
        return orden;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
