public class TramoCompartido {
    private boolean ocupado = false;
    private boolean sentidoActual;

    public TramoCompartido() {

    }

    public synchronized void pedirPaso(Tren t){
        try {
            while (this.ocupado && this.sentidoActual != t.getSentido()) {
                // System.out.println(t + " esta esperando");
                wait();
            }
            this.ocupado = true;
        }
        catch (InterruptedException e){
            System.out.println("Se rompio :/");
        }
    }

    public synchronized void liberar(Tren t){
        this.ocupado = false;
        //System.out.println(t + " libero el tramo.");
        notifyAll();
    }
}
