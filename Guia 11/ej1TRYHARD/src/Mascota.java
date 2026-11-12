// Mascota es el OBSERVABLE de la relacion Observer/Observable
public class Mascota implements Runnable{
    private String nombre;
    private State estadoActual = new SinNecesidadState(this);
    private ObserverMascotas observerMascotas;

    public Mascota(String nombre, ObserverMascotas observer) {
        this.nombre = nombre;
        this.observerMascotas = observer;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstadoActual(State estadoActual) {
        this.estadoActual = estadoActual;
    }

    @Override
    public String toString(){
        return nombre;
    }

    public void cambioDeEstadoAleatorio() {
        int estadoProx = (int) (Math.random() * 4) + 1;
        switch (estadoProx) {
            case 1:
                this.setEstadoActual(new HambreState(this));
                break;
            case 2:
                this.setEstadoActual(new AburridaState(this));
                break;
            case 3:
                this.setEstadoActual(new SedState(this));
                break;
            case 4:
                this.setEstadoActual(new SuenioState(this));
                break;
            default:
                System.out.println("Estado desconocido.");
                break;
        }
    }

    @Override
    public void run(){
        while(true){
            try {
                Thread.sleep((int) (Math.random() * 7001) + 3000); // Espera entre 3 y 10 segundos.
                this.estadoActual.informarNecesidad();
                this.cambioDeEstadoAleatorio();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ObserverMascotas getObserver() {
        return this.observerMascotas;
    }
}
