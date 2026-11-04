public class Dragon extends Personaje{
    private int poderFuego = 100;

    public Dragon(String nombre, Posicion pos) {
        super(nombre, 1000, pos);
    }

    public Dragon(String nombre, int vitalidad) {
        this(nombre, new Posicion (0,0));
    }

    public void abrirCofre(Cofre c){
        c.abiertoPorDragon(this);
    }

    public int getPoderFuego() {
        return poderFuego;
    }

    public void setPoderFuego(int poderFuego) {
        this.poderFuego = poderFuego;
    }

    @Override
    public boolean ataca(Personaje p) {
        if(p.getPos().distanciaHasta(this.getPos()) > 50)
            return false;
        p.recibeDanio(poderFuego);
        return true;
    }

    @Override
    public void recibeDanio(int cantidad) {
        this.setVitalidad( (int) (cantidad/2));
    }
}
