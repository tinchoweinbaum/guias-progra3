public class Arquero extends Personaje{
    private int cantFlechas = 20;

    public Arquero(String nombre, Posicion pos) {
        super(nombre, 500, pos);
    }

    public Arquero(String nombre) {
        this(nombre, new Posicion (0,0));
    }

    public int getCantFlechas() {
        return cantFlechas;
    }

    public void setCantFlechas(int cantFlechas) {
        this.cantFlechas = cantFlechas;
    }

    @Override
    public void recibeDanio(int cantidad) {
        this.vitalidad -= cantidad;
    }

    @Override
    public boolean ataca(Personaje p) {
        if(this.cantFlechas > 0){
            if(p.getPos().distanciaHasta(this.pos) < 100){
                p.recibeDanio(15);
                this.cantFlechas -= 1;
                return true;
            }
            return false;
        }
        if(p.getPos().distanciaHasta(this.pos) < 5){
            p.recibeDanio(5);
            return true;
        }
        return false;
    }

    public void abrirCofre(Cofre cofre){
        cofre.abiertoPorArquero(this);
    }
}
