public class Tren implements Runnable{
    private String nombre;
    TramoCompartido tramo;

    public Tren(String nombre, TramoCompartido tramo) {
        this.nombre = nombre;
        this.tramo = tramo;
    }

    @Override
    public void run(){
        tramo.pedirPaso(this);
        System.out.println(this + " tiene el paso libre.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        tramo.liberar(this);
    }

    @Override
    public String toString() {
        return "Tren " + this.nombre;
    }
}
