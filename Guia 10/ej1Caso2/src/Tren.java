public class Tren implements Runnable{
    private String nombre;
    private TramoCompartido tramo;
    private boolean sentido;

    public Tren(String nombre, boolean sentido, TramoCompartido tramo) {
        this.nombre = nombre;
        this.sentido = sentido;
        this.tramo = tramo;
    }

    @Override
    public void run(){
        tramo.pedirPaso(this);
        System.out.println(this + " esta cruazando.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        tramo.liberar(this);
    }

    public boolean getSentido() {
        return sentido;
    }

    @Override
    public String toString() {
        return "Tren " + this.nombre + "Con sentido " + this.sentido;
    }
}
