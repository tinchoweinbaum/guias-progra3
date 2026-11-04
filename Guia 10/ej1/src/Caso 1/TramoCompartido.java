public class TramoCompartido {
    private boolean ocupado = false;

    public TramoCompartido() {

    }

    public synchronized void pedirPaso(Tren t){
        try {
            while (this.ocupado) {
                System.out.println(t + " esta esperando");
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
        System.out.println(t + " libero el tramo.");
        System.out.println("");
        notifyAll();
    }
}
