public class TramoCompartido {
    private boolean ocupado = false;
    private boolean ultimoSentido;
    private int cantSur = 0;
    private int cantNorte = 0;


    public TramoCompartido() {

    }

    private int cantSentidoOpuesto(boolean sentido){
        if (sentido)
            return this.cantSur;
        return this.cantNorte;
     }

    private boolean puedePasar(Tren t){
        if (this.ocupado)
            return false;
        if (this.ultimoSentido == t.getSentido() && this.cantSentidoOpuesto(t.getSentido()) != 0) // Si el ultimo sentido se repite y hay alguien del otro lado esperando
            return false;
        return true;
    }

    public synchronized void pedirPaso(Tren t){
        try {
            if (t.getSentido())
                this.cantNorte++;
            else
                this.cantSur++;

            while (!this.puedePasar(t)) {
                //System.out.println(t + " esta esperando");
                wait();
            }
            this.ocupado = true;
            this.ultimoSentido = t.getSentido();
        }
        catch (InterruptedException e){
            System.out.println("Se rompio :/");
        }
    }

    public synchronized void liberar(Tren t){
        this.ocupado = false;
        //System.out.println(t + " libero el tramo.");
        System.out.println();
        if (t.getSentido())
            this.cantNorte--;
        else
            this.cantSur--;
        notifyAll();
    }
}
