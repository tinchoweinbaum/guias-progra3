public class Empleado {
    private int cantPersonas;
    private boolean ocupado = false;
    private int personaActual = 1;

    public Empleado(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }

    /**
     * Como a esta función la llaman las Personas, tiene que ser synchronized para que la usen de a una a la vez.
     *
     */
    public synchronized void pedirAtencion(Persona p){
        System.out.println(p + " llama al empleado.");
        try {
            while(ocupado || p.getOrden() != this.personaActual){
                wait();
            }
            this.ocupado = true;
        }
        catch (InterruptedException e){
            System.out.println("Interrupción en Empleado.java");
        }
    }

    public synchronized void liberarEmpleado(Persona p){
        this.ocupado = false;
        System.out.println(p + " fue atendido.\n");
        this.personaActual = (this.personaActual % cantPersonas) + 1;
        notifyAll(); // Una vez terminó de atender a uno, despierta al resto de hilos.
    }
}
