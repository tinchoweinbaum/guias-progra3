public class Tren implements Runnable{
    private String nombre;
    TramoCompartido tramo;
    private boolean sentido;

    public Tren(String nombre, boolean sentido, TramoCompartido tramo) {
        this.nombre = nombre;
        this.sentido = sentido;
        this.tramo = tramo;
    }

    public boolean getSentido() {
        return sentido;
    }

    @Override
    public void run(){
        tramo.pedirPaso(this);
        System.out.println(this + " esta cruzando.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        tramo.liberar(this);
    }

    @Override
    public String toString() {
        return "Tren " + this.nombre + " con sentido " + this.sentido;
    }
}
